
# FocusGuard (Windows)

A Windows background **Worker Service** that monitors running processes and terminates those listed in `appsettings.json` under `Blocklist`.

## Build
- Requires **.NET SDK 8+**.
```bash
dotnet build FocusGuard.sln -c Release
```

## Run (Console)
```bash
cd FocusGuard.Worker/bin/Release/net8.0/win-x64
dotnet FocusGuard.Worker.dll
```

## Install as Service (Admin)
Use the provided PowerShell scripts:

```powershell
scripts\install-service.ps1
# later
scripts\uninstall-service.ps1
```

Logs are written to `logs/focusguard.log` next to the executable.

## Notes
- For personal productivity on your own device.
- Edit `appsettings.json` and restart service to apply changes.
