package by.ocheretny.homework.homework12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import by.ocheretny.homework.R
import by.ocheretny.homework.homework12.data.entity.CountryWithHoliday
import by.ocheretny.homework.homework12.mappers.CountryResponseMapper
import by.ocheretny.homework.homework12.networking.HolidaysApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

private const val API_KEY = "a199291d-e42b-4002-9aa5-6c3d78d5916c"

class HW12Activity : AppCompatActivity() {

    private lateinit var disposables: CompositeDisposable
    private val time = Calendar.getInstance().timeInMillis


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw12)

        val month = SimpleDateFormat("MM")
        val day = SimpleDateFormat("dd")

        val myMonth = month.format(Date(time)).toString().toInt()
        val myDay = day.format(Date(time)).toString().toInt()

        val adapter = HolidayAdapter()

        val recycler = findViewById<RecyclerView>(R.id.hw12_recycler)

        recycler.adapter = adapter

        disposables = CompositeDisposable()

        HolidaysApi.provideRetrofit().getCountries(API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap { countryResponse ->
                val list = countryResponse.countries?.map {
                    CountryResponseMapper().map(it)
                }

                findViewById<ProgressBar>(R.id.hw12_country_progress_bar).visibility = View.GONE

                val listCountryWithHoliday = list?.map { country ->
                    CountryWithHoliday(
                        code = country.code,
                        flag = country.flag,
                        countryName = country.name
                    )
                }

                adapter.init(listCountryWithHoliday as ArrayList<CountryWithHoliday>)

                Observable.fromIterable(listCountryWithHoliday).subscribeOn(Schedulers.io())
            }
            .subscribe({ countryWithHoliday ->
                HolidaysApi.provideRetrofit().getHolidays(
                    API_KEY,
                    countryCode = countryWithHoliday.code.orEmpty(),
                    month = myMonth,
                    day = myDay,
                ).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        val oldList = adapter.getHolidaysList()
                        val oldCountryWithHoliday = oldList.find {
                            it.code == countryWithHoliday.code
                        }

                        oldCountryWithHoliday?.date = it.holidays?.get(0)?.date
                        oldCountryWithHoliday?.holidayName = it.holidays?.get(0)?.name.orEmpty()
                        adapter.updateItem(oldCountryWithHoliday)
                    }, {})

            }, {})
    }
    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }
}