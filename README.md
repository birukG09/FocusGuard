
# FocusGuard Suite

**FocusGuard** is a cross-platform productivity suite for **Android** and **Windows** that blocks distracting apps/processes (e.g., TikTok) to help engineers and students stay in a deep work state.

> Built for personal productivity. Includes visible controls, logs, and opt-in "stealth mode".

## Projects
- `focusguard-android/` — Kotlin app using an Accessibility Service to detect foreground apps and block blacklisted packages via a focus overlay / auto-redirect.
- `focusguard-windows/` — .NET Worker Service that monitors and terminates/blocks configured processes. Includes scripts for install/uninstall as a Windows Service.

## Ethics & Safety
- Intended for **self-management** or managed devices with consent.
- All blocking lists are **local** and **transparent** by default.
- Optional **stealth mode** requires explicit enablement in settings.

## Quick Start
- Android: open `focusguard-android` in Android Studio, build & run. Enable the **FocusGuard Accessibility Service**.
- Windows: install .NET SDK 8+, run `scripts/install-service.ps1` as admin to register service; edit `appsettings.json` for your blocklist.

---

© 2025 FocusGuard Team (you). MIT License.
