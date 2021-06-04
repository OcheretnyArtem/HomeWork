package by.ocheretny.homework.homework12.data.dto


import com.google.gson.annotations.SerializedName

data class CountryResponse(
    @SerializedName("countries")
    val countries: List<Country?>?,
) {
    data class Country(
        @SerializedName("code")
        val code: String?,
        @SerializedName("flag")
        val flag: String?,
        @SerializedName("name")
        val name: String?,
    )
}