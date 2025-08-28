
# FocusGuard (Android)

Android app that uses an Accessibility Service to detect foreground packages and block those on a local blocklist. Presents a lightweight overlay reminder and returns the user to Home.

## Build & Run
1. Open in Android Studio (Giraffe+).
2. Build & Run on device (minSdk 26).
3. Enable **FocusGuard** in **Settings → Accessibility**.
4. In the app, toggle **Stealth Mode** to hide the launcher icon (optional).

## Notes
- No network access. All data is local.
- Blocklist stored in SharedPreferences.
- Overlay is Activity-based (no special overlay permission).

## Packages to try
- TikTok: `com.zhiliaoapp.musically`
- Instagram: `com.instagram.android`
- Facebook: `com.facebook.katana`
- Snapchat: `com.snapchat.android`
