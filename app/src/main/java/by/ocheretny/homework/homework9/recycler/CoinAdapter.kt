package by.ocheretny.homework.homework9.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.ocheretny.homework.R
import by.ocheretny.homework.homework9.data.entities.crypto.Crypto

class CoinAdapter(val coins: List<Crypto>) : RecyclerView.Adapter<CoinAdapter.CryptoViewHolder>() {

    inner class CryptoViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun setData(itemView: View, position: Int) {

            val crypto = coins[position]
            val image = itemView.findViewById<ImageView>(R.id.hw9_trending)

            when {
                crypto.percentChange1h ?: 0.0 > 0.0 -> {
                    image.setImageResource(R.drawable.trending_up)
                }
                crypto.percentChange1h ?: 0.0 < 0.0 -> {
                    image.setImageResource(R.drawable.trending_down)
                }
                crypto.percentChange1h ?: 0.0 == 0.0 -> {
                    image.setImageResource(R.drawable.trending_flat)
                }
            }

            itemView.findViewById<TextView>(R.id.hw9_name).text = crypto.name
            itemView.findViewById<TextView>(R.id.hw9_percent).text =
                "${crypto.percentChange1h.toString()}${view.context.getString(R.string.percent)}"
            itemView.findViewById<TextView>(R.id.hw9_price).text =
                "${String.format("%.2f", crypto.price)} ${view.context.getString(R.string.dollar)}"
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