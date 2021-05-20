package by.ocheretny.homework.homework9.mappers

import by.ocheretny.homework.homework9.data.dto.crypto.CryptoResponse

interface Mapper<F, T> {
    fun map(from: CryptoResponse.Data?): T
}