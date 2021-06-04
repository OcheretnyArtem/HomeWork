package by.ocheretny.homework.homework12.data.dto


import com.google.gson.annotations.SerializedName

data class HolidayResponse(
    @SerializedName("holidays")
    val holidays: List<Holiday?>?,
) {
    data class Holiday(
        @SerializedName("country")
        val country: String?,
        @SerializedName("date")
        val date: String?,
        @SerializedName("name")
        val name: String?
    )
}