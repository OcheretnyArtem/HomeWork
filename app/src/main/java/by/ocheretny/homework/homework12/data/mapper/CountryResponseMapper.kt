package by.ocheretny.homework.homework12.data.mapper

import by.ocheretny.homework.homework12.data.dto.CountryResponse
import by.ocheretny.homework.homework12.data.entity.Country

class CountryResponseMapper : Mapper<CountryResponse.Country, Country> {
    override fun map(from: CountryResponse.Country): Country {
        return Country(
            code = from.code.orEmpty(),
            flag = from.flag.orEmpty(),
            name = from.name.orEmpty()
        )
    }
}