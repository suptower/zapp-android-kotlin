package com.example.othregensburg.zapp

import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class ListAdapter(private val data: List<String>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    private val itemStateArray = SparseBooleanArray()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: String = data[position]
        holder.checkBox.text = item

        holder.checkBox.isChecked = itemStateArray.get(position, false)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var checkBox: CheckBox = itemView.findViewById(R.id.checkbox)

        init {
            checkBox.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            val checkboxState: Boolean = checkBox.isChecked
            itemStateArray.put(layoutPosition, checkboxState)

            if (view != null) {
                Toast.makeText(
                    view.context,
                    String.format(
                        Locale.GERMAN,
                        "Position: %d is checked %s.",
                        layoutPosition,
                        checkBox.isChecked
                    ),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
