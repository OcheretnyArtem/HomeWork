package by.ocheretny.homework.homework12.networking


import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object HolidaysApi {

    fun provideRetrofit(): HolidaysService {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://holidayapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

        return retrofit.create()
    }
}