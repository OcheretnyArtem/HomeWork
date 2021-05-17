package by.ocheretny.homework.homework9.repository.crypto

import by.ocheretny.homework.homework9.data.entities.crypto.Crypto
import by.ocheretny.homework.homework9.mappers.crypto.CryptoResponseMapper
import by.ocheretny.homework.homework9.networking.crypto.CryptoApi

class CryptoRepository {

    private val api = CryptoApi.provideRetrofit()
    private val cryptoResponseMapper = CryptoResponseMapper()

    suspend fun loadData(key: String):List<Crypto>{
        val response = api.loadData(key)
        return if (response.isSuccessful){
            response.body()?.data?.map {
                cryptoResponseMapper.map(it)
            }.orEmpty()
        }else{
            throw Throwable(response.errorBody().toString())
        }
    }
}