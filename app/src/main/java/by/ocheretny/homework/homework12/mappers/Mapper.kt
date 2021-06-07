package by.ocheretny.homework.homework12.mappers

import by.ocheretny.homework.homework12.data.dto.CountryResponse

interface Mapper<F, T> {

    fun map(from: F): T
}