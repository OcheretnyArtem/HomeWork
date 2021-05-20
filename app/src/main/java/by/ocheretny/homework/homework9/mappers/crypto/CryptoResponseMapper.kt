package by.ocheretny.homework.homework9.mappers.crypto

import by.ocheretny.homework.homework9.data.dto.crypto.CryptoResponse
import by.ocheretny.homework.homework9.data.entities.crypto.Crypto
import by.ocheretny.homework.homework9.mappers.Mapper

class CryptoResponseMapper : Mapper<CryptoResponse.Data, Crypto> {

    override fun map(from: CryptoResponse.Data?): Crypto {
        return Crypto(
            name = from?.name.orEmpty(),
            symbol = from?.symbol.orEmpty(),
            percentChange1h = from?.quote?.uSD?.percentChange1h ?: 0.0,
            price = from?.quote?.uSD?.price ?: 0.0
        )
    }
}