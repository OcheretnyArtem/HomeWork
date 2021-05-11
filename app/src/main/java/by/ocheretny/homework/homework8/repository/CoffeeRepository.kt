package by.ocheretny.homework.homework8.repository

import by.ocheretny.homework.homework8.dataBase.CoffeeDataBase
import by.ocheretny.homework.homework8.dataBase.entity.Coffee
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoffeeRepository(
    private val database: CoffeeDataBase
) {
    private val dao = database.coffeeDao()
    private val ioScope = CoroutineScope(Dispatchers.IO)

    fun insert(coffee: Coffee){
        ioScope.launch {
            dao.insert(coffee)
        }
    }

    fun delete(coffee: Coffee){
        ioScope.launch {
            dao.delete(coffee)
        }
    }
    fun update(coffee: Coffee){
        ioScope.launch {
            dao.update(coffee)
        }
    }
}