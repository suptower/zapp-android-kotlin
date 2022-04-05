import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.othregensburg.zapp.R
import java.util.*

class ListAdapter(private val data: List<String>) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): ViewHolder {

        // Use the factory method within our ListAdapter.ViewHolder
        // class to create a new instance of ViewHolder to return
        return ViewHolder.create(parent)
    }

    override fun onBindViewHolder(
        holder: ViewHolder, position: Int) {
        // TODO: Set text depending on the given position
        val itemString : String = position.toString()

        // Binding is done within the instance method of this
        // ViewHolder object passed in
        holder.bind(itemString)
    }

    override fun getItemCount(): Int {
        // TODO: Return size of data set instead of 0
        return data.size
    }

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                Toast.makeText(
                    itemView.context,
                    String.format(
                        Locale.GERMAN,
                        "Position: %d; is checked: %s",
                        layoutPosition,
                        itemCheckBox.isChecked
                    ),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        // TODO: Get a reference to the checkbox with
        // itemView.findById(...)
        var itemCheckBox: CheckBox = itemView.findViewById(R.id.checkBox)

        fun bind(item: String) {
            // TODO: Set text of this individual checkbox with given
            // parameter
            itemCheckBox.text = item
        }







        companion object {
            // Factory method to create a single ViewHolder instance
            fun create(parent: ViewGroup): ViewHolder {
                // TODO: Use the LayoutInflater with the parent
                // ViewGroup to inflate the layout for one
                // individual row item
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_lines, parent, false)
                return ViewHolder(view)
            }
        }
    }
}