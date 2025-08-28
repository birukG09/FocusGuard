
package com.focusguard.ui

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class OverlayActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tv = TextView(this).apply {
            text = "FocusGuard: Stay in flow. Distracting app blocked."
            textSize = 18f
            setPadding(32, 64, 32, 64)
        }
        setContentView(tv)
    }
}
