# FocusGuard 🚀
🕒📈✅💻⚡🖥️🛠️👨‍💻
shield + clock protecting your productivity by blocking distracting apps like TikTok, Instagram, YouTube, Snapchat, and more.*
Stay focused with **FocusGuard** ⏰💻🚀  
Block distracting apps like TikTok 📱❌ and gain productivity ✅  
Track your time ⏳ and efficiency 📈 with ease!
<p align="center">
  <img src="https://github.com/birukG09/FocusGuard/blob/2abe196c7481eab6fbde72fe3bc160d3a1d54097/2662154102canva%20design.png" alt="FocusGuard Banner" style="width:100%; max-width:100%;">
</p>


## Overview

**FocusGuard** is a **cross-platform productivity application** designed for engineers, students, and professionals who want to **stay focused** and eliminate distractions. It invisibly **blocks access to distracting apps** on Windows and Android devices, helping you regain control of your time and maintain deep work flow.

With FocusGuard, you can:

- Block apps like TikTok, Instagram, YouTube, Snapchat, Facebook, Twitter, and any other apps that affect your efficiency.
- Run discreetly in the background without intrusive notifications.
- Track and maintain your productivity without manually monitoring apps.
- Customize your own blocklist and schedule focus sessions.

FocusGuard is designed with **security, usability, and stealth** in mind.

---

## Features

### Android Version
- Accessibility Service-based blocking mechanism.
- **Stealth Mode:** hides launcher icon.
- Customizable **blocklist** to add/remove apps.
- Minimalistic **Material3 UI** with modern design.
- Lightweight, battery-efficient background service.
- Overlay notifications for blocked apps.

### Windows Version
- **.NET 8 Worker Service** that continuously monitors running processes.
- Auto-terminates apps listed in the blocklist.
- **Logging:** keeps detailed records of blocked attempts (`logs/focusguard.log`).
- Easy installation via PowerShell scripts (`install-service.ps1`, `uninstall-service.ps1`).
- Configurable blocklist in `appsettings.json`.
- Lightweight, runs silently in the background.

### Cross-Platform Highlights
- Full control over **blocked apps**.
- Maintains **productivity** across work and study sessions.
- Modern and minimalistic UI for both platforms.
- Scalable: can add more platforms or integrate cloud-sync in future updates.

---

---

## Installation

### Android
1. Open the `focusguard-android` project in **Android Studio**.
2. Build and install on your device (minSdk 26+).
3. Go to **Settings → Accessibility → FocusGuard** and enable the service.
4. Add apps to your blocklist and activate Stealth Mode if desired.

### Windows
1. Open the `focusguard-windows` project in Visual Studio or via command line.
2. Run:
   ```powershell
   dotnet publish -c Release -r win-x64 --self-contained true
.\scripts\install-service.ps1
Update appsettings.json with the processes you want to block.

Start the service; check logs in logs/focusguard.log.

Blocklist Example
json
Copy code
{
  "Blocklist": [
    "TikTok.exe",
    "Instagram.exe",
    "YouTube.exe",
    "Snapchat.exe",
    "Facebook.exe",
    "Twitter.exe"
  ]
}
Tip: Use exact process names from Task Manager for Windows or package names for Android.

Roadmap
 Web dashboard for remote management.

 Cloud sync of blocklists and focus sessions.

 Timer and schedule for automatic focus sessions.
Developed by 👨‍💻 Biruk G. – stay focused, stay productive!  
Join the coding journey 🧑‍💻🚀

