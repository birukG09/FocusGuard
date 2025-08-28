
package com.focusguard.store

import android.content.Context
import org.json.JSONArray

object Blocklist {
    private const val PREFS = "fg_blocklist"
    private const val KEY = "packages"
    fun getAll(ctx: Context): List<String> {
        val p = ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        val raw = p.getString(KEY, "[]") ?: "[]"
        val arr = JSONArray(raw)
        return (0 until arr.length()).map { arr.getString(it) }
    }
    fun isBlocked(ctx: Context, pkg: String): Boolean = getAll(ctx).contains(pkg)
    fun addAll(ctx: Context, pkgs: List<String>) {
        val all = (getAll(ctx) + pkgs).distinct()
        val arr = JSONArray()
        all.forEach { arr.put(it) }
        ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE).edit().putString(KEY, arr.toString()).apply()
    }
}
