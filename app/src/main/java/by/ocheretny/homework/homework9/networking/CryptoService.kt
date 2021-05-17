package by.ocheretny.homework.homework9.networking

import by.ocheretny.homework.homework9.data.dto.crypto.CryptoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header


interface CryptoService {

    @GET("v1/cryptocurrency/listings/latest")
    suspend fun loadData(
    @Header("X-CMC_PRO_API_KEY")
    key: String
    ): Response<CryptoResponse>
}