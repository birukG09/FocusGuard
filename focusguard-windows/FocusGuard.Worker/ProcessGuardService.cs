
using Microsoft.Extensions.Hosting;
using Microsoft.Extensions.Logging;
using System.Diagnostics;

namespace FocusGuard.Worker;

public class ProcessGuardService(ILogger<ProcessGuardService> logger, IConfiguration config) : BackgroundService
{
    private readonly ILogger<ProcessGuardService> _logger = logger;
    private readonly IConfiguration _config = config;
    private HashSet<string> _blockedExe = [];

    protected override Task ExecuteAsync(CancellationToken stoppingToken)
    {
        LoadBlocklist();
        _logger.LogInformation("FocusGuard Worker started at: {time}", DateTimeOffset.Now);

        _ = Task.Run(async () =>
        {
            while (!stoppingToken.IsCancellationRequested)
            {
                try
                {
                    ScanAndAct();
                }
                catch (Exception ex)
                {
                    _logger.LogError(ex, "Scan error");
                }
                await Task.Delay(TimeSpan.FromSeconds(2), stoppingToken);
            }
        }, stoppingToken);

        return Task.CompletedTask;
    }

    private void LoadBlocklist()
    {
        var list = _config.GetSection("Blocklist").Get<string[]>() ?? Array.Empty<string>();
        _blockedExe = list.Select(x => x.ToLowerInvariant()).ToHashSet();
        _logger.LogInformation("Loaded blocklist: {count} items", _blockedExe.Count);
    }

    private void ScanAndAct()
    {
        var procs = Process.GetProcesses();
        foreach (var p in procs)
        {
            try
            {
                var name = (p.ProcessName + ".exe").ToLowerInvariant();
                if (_blockedExe.Contains(name))
                {
                    _logger.LogInformation("Blocking process: {proc}", name);
                    p.Kill(entireProcessTree: true);
                }
            }
            catch { /* ignored */ }
        }
    }
}
