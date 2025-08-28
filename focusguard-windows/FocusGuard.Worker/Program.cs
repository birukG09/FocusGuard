
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Microsoft.Extensions.Logging;
using Serilog;

namespace FocusGuard.Worker;
public class Program
{
    public static void Main(string[] args)
    {
        Log.Logger = new LoggerConfiguration()
            .WriteTo.File("logs/focusguard.log", rollingInterval: RollingInterval.Day)
            .CreateLogger();

        var builder = Host.CreateApplicationBuilder(args);
        builder.Services.AddHostedService<ProcessGuardService>();
        builder.Services.AddWindowsService(options => options.ServiceName = "FocusGuard");
        builder.Logging.ClearProviders();
        builder.Logging.AddSerilog();

        builder.Configuration.AddJsonFile("appsettings.json", optional: false, reloadOnChange: true);

        var host = builder.Build();
        host.Run();
    }
}
