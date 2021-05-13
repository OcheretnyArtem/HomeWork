package by.ocheretny.homework.homework8.repository

import by.ocheretny.homework.homework8.dataBase.CoffeeDataBase
import by.ocheretny.homework.homework8.dataBase.entity.Coffee
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class CoffeeRepository(
    private val database: CoffeeDataBase
) {
    private val dao = database.coffeeDao()
    private val ioScope = CoroutineScope(Dispatchers.IO)

    fun insert(coffee: Coffee) {
        ioScope.launch {
            dao.insert(coffee)
        }
    }

    fun delete(coffee: Coffee) {
        ioScope.launch {
            dao.delete(coffee)
        }
    }

    fun update(id: Int, name: String, prise: Int, url: String) {
        ioScope.launch {
            dao.update(id, name, prise, url)
        }
    }

    suspend fun getAll(): List<Coffee> {
        return ioScope.async { dao.getAll() }.await()
    }

    suspend fun find(name: String):List<Coffee>{
        return ioScope.async { dao.find(name) }.await()
    }
}