package by.ocheretny.homework.homework8

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.ocheretny.homework.homework8.dataBase.CoffeeDataBase
import by.ocheretny.homework.homework8.dataBase.entity.Coffee
import by.ocheretny.homework.homework8.repository.CoffeeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class HW8ViewModel(application: Application):AndroidViewModel(application) {

    private val coffeeRepository = CoffeeRepository(CoffeeDataBase.getCoffeeDataBase(application))
    private val ioScope = CoroutineScope(Dispatchers.IO)

    private val _isLoading = MutableLiveData<Boolean>()
    val  isLoading: LiveData<Boolean> = _isLoading

    fun insert (coffee: Coffee){
        coffeeRepository.insert(coffee)
    }

    fun delete (coffee: Coffee){
        coffeeRepository.delete(coffee)
    }

    fun update(coffee: Coffee){
        coffeeRepository.update(coffee)
    }
}