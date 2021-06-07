package by.ocheretny.homework.homework12.mappers

import by.ocheretny.homework.homework12.data.dto.CountryResponse
import by.ocheretny.homework.homework12.data.dto.HolidayResponse
import by.ocheretny.homework.homework12.data.entity.Holiday

class HolidayResponseMapper : Mapper<HolidayResponse.Holiday, Holiday> {
    override fun map(from: HolidayResponse.Holiday): Holiday {
        return Holiday(
            date = from.date.orEmpty(),
            name = from.name.orEmpty()
        )
    }

}