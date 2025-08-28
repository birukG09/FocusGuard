
package com.focusguard.ui

import android.content.ComponentName
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.focusguard.R
import com.focusguard.store.Blocklist

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rvBlocked)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = SimpleTextAdapter(Blocklist.getAll(this))

        val sw = findViewById<Switch>(R.id.switchStealth)
        sw.setOnCheckedChangeListener { _, checked ->
            val state = if (checked) PackageManager.COMPONENT_ENABLED_STATE_DISABLED else PackageManager.COMPONENT_ENABLED_STATE_ENABLED
            packageManager.setComponentEnabledSetting(
                ComponentName(this, MainActivity::class.java),
                state,
                PackageManager.DONT_KILL_APP
            )
        }

        findViewById<Button>(R.id.btnManageList).setOnClickListener {
            // Append common packages as demo
            val samples = listOf("com.zhiliaoapp.musically", "com.instagram.android", "com.facebook.katana", "com.snapchat.android")
            Blocklist.addAll(this, samples)
            rv.adapter = SimpleTextAdapter(Blocklist.getAll(this))
        }
    }
}
