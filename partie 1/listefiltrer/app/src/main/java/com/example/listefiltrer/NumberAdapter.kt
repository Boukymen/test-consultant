import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NumberAdapter (private var numberList: List<Int>) : RecyclerView.Adapter<NumberAdapter.NumberViewHolder>() {

    class NumberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val numberTextView: TextView = itemView.findViewById(android.R.id.text1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)
        return NumberViewHolder(view)
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.numberTextView.text = numberList[position].toString()
    }

    override fun getItemCount(): Int {
        return numberList.size
    }

    fun updateList(filteredList: List<Int>) {
        this.numberList = filteredList
        notifyDataSetChanged()
    }
}
