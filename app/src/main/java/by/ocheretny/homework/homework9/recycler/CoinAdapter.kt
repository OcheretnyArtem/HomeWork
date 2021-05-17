package by.ocheretny.homework.homework9.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.ocheretny.homework.R
import by.ocheretny.homework.homework9.data.entities.crypto.Crypto

class CoinAdapter(val coins: List<Crypto>) : RecyclerView.Adapter<CoinAdapter.CryptoViewHolder>() {

    inner class CryptoViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun setData(itemView: View, position: Int) {

            val crypto = coins[position]

            itemView.findViewById<TextView>(R.id.hw9_name).text = crypto.name
            itemView.findViewById<TextView>(R.id.hw9_percent).text = crypto.percentChange1h.toString()
            itemView.findViewById<TextView>(R.id.hw9_price).text = crypto.price.toString()
            itemView.findViewById<TextView>(R.id.hw9_symbol).text = crypto.symbol

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_coin, parent, false)
        return CryptoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        holder.setData(holder.itemView, position)
    }

    override fun getItemCount(): Int {
        return coins.size
    }
}