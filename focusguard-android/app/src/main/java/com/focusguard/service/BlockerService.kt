
package com.focusguard.service

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import android.view.accessibility.AccessibilityEvent
import com.focusguard.ui.OverlayActivity
import com.focusguard.store.Blocklist

class BlockerService : AccessibilityService() {
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        if (event?.eventType != AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) return
        val pkg = event.packageName?.toString() ?: return
        if (Blocklist.isBlocked(this, pkg)) {
            // Bring overlay to front to nudge the user back to focus
            val i = Intent(this, OverlayActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            startActivity(i)
            // Optionally go Home
            performGlobalAction(GLOBAL_ACTION_HOME)
        }
    }
    override fun onInterrupt() {}
}
