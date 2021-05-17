package by.ocheretny.homework.homework9.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.ocheretny.homework.homework9.data.entities.crypto.Crypto
import by.ocheretny.homework.homework9.repository.crypto.CryptoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class HW9ViewModel : ViewModel() {

    private val cryptoRepository = CryptoRepository()
    private val ioScope = CoroutineScope(Dispatchers.IO)

    private val _coins = MutableLiveData<List<Crypto>>()
    val coins: LiveData<List<Crypto>> = _coins

    private val _errorBus = MutableLiveData<String>()
    val errorBus: LiveData<String> = _errorBus

    fun loadData(key: String){
        ioScope.launch {
            try {
                _coins.postValue(cryptoRepository.loadData(key))
            }catch (e:Exception){
                _errorBus.postValue(e.message)
            }
        }
    }
}