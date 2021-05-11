package by.ocheretny.homework.homework8.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import by.ocheretny.homework.homework8.dataBase.dao.CoffeeDao
import by.ocheretny.homework.homework8.dataBase.entity.Coffee

@Database(entities = [Coffee::class], version = 1)
abstract class CoffeeDataBase : RoomDatabase() {

    abstract fun coffeeDao(): CoffeeDao

    companion object {
        var INSTANCE: CoffeeDataBase? = null

        fun getCoffeeDataBase(context: Context): CoffeeDataBase {
            return if (INSTANCE == null) {
                INSTANCE =
                    Room.databaseBuilder(context, CoffeeDataBase::class.java, "database").build()
                INSTANCE as CoffeeDataBase
            } else INSTANCE as CoffeeDataBase
        }
    }
}