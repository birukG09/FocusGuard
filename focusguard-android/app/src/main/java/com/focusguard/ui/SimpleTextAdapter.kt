
package com.focusguard.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SimpleTextAdapter(private val items: List<String>) : RecyclerView.Adapter<SimpleTextAdapter.VH>() {
    class VH(v: View): RecyclerView.ViewHolder(v) { val tv: TextView = v as TextView }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val tv = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false) as TextView
        return VH(tv)
    }
    override fun onBindViewHolder(holder: VH, position: Int) { holder.tv.text = items[position] }
    override fun getItemCount(): Int = items.size
}
