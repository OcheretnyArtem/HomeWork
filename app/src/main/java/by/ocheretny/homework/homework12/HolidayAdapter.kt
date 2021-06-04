package by.ocheretny.homework.homework12

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.ocheretny.homework.R
import by.ocheretny.homework.homework12.data.entity.CountryWithHoliday
import com.squareup.picasso.Picasso

class HolidayAdapter : RecyclerView.Adapter<HolidayAdapter.HolidayViewHolder>() {

    private var list = ArrayList<CountryWithHoliday>()

    fun init(newList: ArrayList<CountryWithHoliday>) {
        list = newList
        notifyDataSetChanged()
    }

    fun updateItem(item: CountryWithHoliday) {

        val oldItem = list.find {
            it.code == item.code
        }

        val oldItemIndex = list.indexOf(oldItem)

        list[oldItemIndex] = item

        notifyDataSetChanged()
    }

    fun getHolidaysList() = list

    inner class HolidayViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item: CountryWithHoliday) {

            view.findViewById<TextView>(R.id.holiday_country_name).text = item.countryName

            Picasso.get()
                .load(item.flag)
                .into(view.findViewById<ImageView>(R.id.holiday_flag_image))

            if (item.date != null && item.holidayName != null){
                view.findViewById<ProgressBar>(R.id.hw12_item_progress_bar).visibility = View.GONE
                view.findViewById<TextView>(R.id.holiday_date).text = item.date
                view.findViewById<TextView>(R.id.holiday_name).text = item.holidayName
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolidayViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_holiday, parent, false)
        return HolidayViewHolder(view)
    }

    override fun onBindViewHolder(holder: HolidayViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}