package by.ocheretny.homework.homework8

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import by.ocheretny.homework.homework8.dataBase.CoffeeDataBase
import by.ocheretny.homework.homework8.dataBase.entity.Coffee
import by.ocheretny.homework.homework8.repository.CoffeeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HW8ViewModel(application: Application) : AndroidViewModel(application) {

     val selectedCoffee = MutableLiveData<Coffee>()

    private val _listOfCoffee = MutableLiveData<List<Coffee>>()
    val listOfCoffee: LiveData<List<Coffee>> = _listOfCoffee

    private val coffeeRepository = CoffeeRepository(CoffeeDataBase.getCoffeeDataBase(application))
    private val ioScope = CoroutineScope(Dispatchers.IO)

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading


    fun insert(coffee: Coffee) {
        coffeeRepository.insert(coffee)
    }

    fun delete(coffee: Coffee) {
        coffeeRepository.delete(coffee)
    }


    fun update( id: Int, name: String, prise: Int, url: String) {
        coffeeRepository.update(id,name,prise,url)
    }

    fun getAll(){
        _isLoading.value = true
        ioScope.launch {
            val coffeeList = coffeeRepository.getAll()
            _listOfCoffee.postValue(coffeeList)
            _isLoading.postValue(false)
        }
    }

    fun find(name: String){
        ioScope.launch {
            val coffeeList = coffeeRepository.find(name)
            _listOfCoffee.postValue(coffeeList)
        }
    }

}