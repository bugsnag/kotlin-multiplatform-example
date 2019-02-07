package com.bugsnag.example.kotlinmp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

internal class LanguageListAdapter(
    val allValues: List<LanguageFact>,
    private val clickListener: View.OnClickListener
) : RecyclerView.Adapter<CellViewHolder>() {

    fun getItem(position: Int) = allValues[position]

    override fun getItemCount() = allValues.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CellViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.cell_language_item, parent, false)
        view.setOnClickListener(clickListener)
        return CellViewHolder(view)
    }

    override fun onBindViewHolder(holder: CellViewHolder, position: Int) {
        val item = getItem(position)
        holder.primaryTv.text = item.name
    }
}
