package by.ocheretny.homework.homework8.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.ocheretny.homework.R
import by.ocheretny.homework.homework8.dataBase.entity.Coffee
import com.squareup.picasso.Picasso

class CoffeeAdapter(val coffees: List<Coffee>) :
    RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder>() {

    inner class CoffeeViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setData(itemView: View, position: Int) {

            val coffee = coffees[position]

            Picasso.get().load(coffee.imjURL).into(itemView.findViewById<ImageView>(R.id.hw8_coffee_image))
            itemView.findViewById<TextView>(R.id.hw8_coffee_name).text = coffee.name
            itemView.findViewById<TextView>(R.id.hw8_coffee_price).text = "${view.context.getString(R.string.price)} - ${coffee.price}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_coffee,parent,false)
        return CoffeeViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoffeeViewHolder, position: Int) {
        holder.setData(holder.itemView,position)
    }

    override fun getItemCount(): Int {
        return coffees.size
    }
}