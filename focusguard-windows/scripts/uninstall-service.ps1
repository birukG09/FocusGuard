
param([string]$ServiceName="FocusGuard")
sc.exe stop $ServiceName
sc.exe delete $ServiceName
Write-Host "Removed $ServiceName"
