package by.ocheretny.homework.homework4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.ocheretny.homework.R
import com.squareup.picasso.Picasso


class SnowdropsAdapter(context: Context) : RecyclerView.Adapter<SnowdropsAdapter.SnowdropViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)
    private val list = ArrayList<Snowdrop>()

    class SnowdropViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val snowdropName: TextView = itemView.findViewById(R.id.name_snowdrop)
        val snowdropDescription: TextView = itemView.findViewById(R.id.description_snowdrop)
        val snowdropImage: ImageView = itemView.findViewById(R.id.image_of_snowdrop)
    }

    fun setItems(newList: ArrayList<Snowdrop>){
        list.clear()
        list.addAll(newList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SnowdropViewHolder {
        val view = layoutInflater.inflate(R.layout.item_of_snowdrop, parent, false)
        return SnowdropViewHolder(view)
    }

    override fun onBindViewHolder(holder: SnowdropViewHolder, position: Int) {
        val snowdrop = list[position]
        holder.snowdropName.text = snowdrop.name
        holder.snowdropDescription.text = snowdrop.description
        Picasso.get().load(snowdrop.ImageURL).into(holder.snowdropImage)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}