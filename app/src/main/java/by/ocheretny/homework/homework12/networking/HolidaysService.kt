package by.ocheretny.homework.homework12.networking

import by.ocheretny.homework.homework12.data.dto.CountryResponse
import by.ocheretny.homework.homework12.data.dto.HolidayResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface HolidaysService {

    @GET("v1/countries")
    fun getCountries(
        @Query("key")
        key: String,
    ): Observable<CountryResponse>

    @GET("v1/holidays")
    fun getHolidays(
        @Query("key")
        key: String,
        @Query("country")
        countryCode: String,
        @Query("year")
        year: Int = 2020,
        @Query("month")
        month: Int,
        @Query("day")
        day: Int,
        @Query("upcoming")
        upcoming: Boolean = true,
    ): Observable<HolidayResponse>


}