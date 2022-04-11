package com.example.othregensburg.zapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val data: List<String>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: String = data[position]
        holder.checkBox.text = item
    }

    override fun getItemCount(): Int {
        return data.size
    }

    // TODO (1) Let the ViewHolder implement a View.OnClickListener
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var checkBox: CheckBox = itemView.findViewById(R.id.checkbox)

        // TODO (2) Set the OnCLickListener to the checkboxes

        // TODO (3) Show a Toast with position and state of the clicked checkbox

        // TODO (4) Fix the issue with checkbox state of the recycled views which occurs after scrolling up and down
        // Hint: Make use of a SpareBooleanArray
    }
}
