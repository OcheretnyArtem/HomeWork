package by.ocheretny.homework

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import by.ocheretny.homework.homework8.dataBase.CoffeeDataBase
import by.ocheretny.homework.homework8.dataBase.dao.CoffeeDao
import by.ocheretny.homework.homework8.dataBase.entity.Coffee
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class DataBaseTest {
    private lateinit var coffeeDao: CoffeeDao

    @Before
    fun init() {

        val context = ApplicationProvider.getApplicationContext<Context>()

        val db = Room.inMemoryDatabaseBuilder(context, CoffeeDataBase::class.java)
            .allowMainThreadQueries()
            .build()

        coffeeDao = db.coffeeDao()

    }

    @Test
    fun insertCoffee_returnTrue() {

        val coffee = Coffee(
            name = "Latte",
            imageURL = "image",
            price = 5,
        )
        coffee.id = 1

        runBlocking {
            coffeeDao.insert(coffee)

            Truth.assertThat(coffeeDao.getAll().contains(coffee)).isTrue()
        }

    }

    @Test
    fun deleteCoffee_returnFalse() {

        val coffee = Coffee(
            name = "Latte",
            imageURL = "image",
            price = 5,
        )
        coffee.id = 1

        runBlocking {
            coffeeDao.insert(coffee)
            coffeeDao.delete(coffee)

            Truth.assertThat(coffeeDao.getAll().contains(coffee)).isFalse()
        }

    }

    @Test
    fun updateCoffee_returnTrue() {

        val coffee = Coffee(
            name = "Latte",
            imageURL = "image",
            price = 5,
        )
        coffee.id = 1
        val newName = "Cappuccino"
        val newImage = "new image"
        val newPrice = 4

        val newCoffee = Coffee(
            name = newName,
            imageURL = newImage,
            price = newPrice,
        )
        newCoffee.id = 1

        runBlocking {
            coffeeDao.insert(coffee)

            coffeeDao.update(1, newName, newPrice, newImage)


            Truth.assertThat(coffeeDao.getAll().contains(newCoffee)).isTrue()
        }

    }

    @Test
    fun getAllCoffee_returnTrue() {

        val coffee1 = Coffee(
            name = "Latte",
            imageURL = "image",
            price = 5,
        )
        coffee1.id = 1

        val coffee2 = Coffee(
            name = "Cappuccino",
            imageURL = "image",
            price = 4,
        )
        coffee2.id = 2
        val coffee3 = Coffee(
            name = "Americano",
            imageURL = "image",
            price = 3,
        )
        coffee2.id = 3

        runBlocking {
            coffeeDao.insert(coffee1)
            coffeeDao.insert(coffee2)
            coffeeDao.insert(coffee3)

            val coffees = listOf(coffee1, coffee2, coffee3)

            Truth.assertThat(coffeeDao.getAll().contains(coffees[0])
                    && coffeeDao.getAll().contains(coffees[1])
                    && coffeeDao.getAll().contains(coffees[2])
                    && coffeeDao.getAll().size == coffees.size).isTrue()
        }

    }

    @Test
    fun findCoffee_returnTrue() {

        val string = "La"
        val coffee = Coffee(
            name = "Latte",
            imageURL = "image",
            price = 5,
        )
        coffee.id = 1

        runBlocking {
            coffeeDao.insert(coffee)

           val strings =  coffeeDao.find(string)

            Truth.assertThat(strings.contains(coffee)).isTrue()
        }
    }

    @Test
    fun findCoffee_returnFalse() {

        val string = "Lfffa"
        val coffee = Coffee(
            name = "Latte",
            imageURL = "image",
            price = 5,
        )
        coffee.id = 1

        runBlocking {
            coffeeDao.insert(coffee)

            val strings =  coffeeDao.find(string)

            Truth.assertThat(strings.contains(coffee)).isFalse()
        }
    }

}



