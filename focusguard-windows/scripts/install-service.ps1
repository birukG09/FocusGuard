
param([string]$ServiceName="FocusGuard")

$here = Split-Path -Parent $MyInvocation.MyCommand.Path
$root = Resolve-Path "$here\.."
dotnet publish "$root\FocusGuard.Worker\FocusGuard.Worker.csproj" -c Release -r win-x64 --self-contained false

$pub = Resolve-Path "$root\FocusGuard.Worker\bin\Release\net8.0\win-x64\publish\FocusGuard.Worker.dll"

# Create service via sc - using dotnet as the binary
sc.exe create $ServiceName binPath= "dotnet `"$pub`"" start= auto DisplayName= "FocusGuard"
sc.exe description $ServiceName "FocusGuard blocks configured distracting processes."
sc.exe start $ServiceName
Write-Host "Installed and started $ServiceName from $pub"
