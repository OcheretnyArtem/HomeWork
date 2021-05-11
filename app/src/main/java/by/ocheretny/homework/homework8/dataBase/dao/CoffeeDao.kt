package by.ocheretny.homework.homework8.dataBase.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import by.ocheretny.homework.homework8.dataBase.entity.Coffee

@Dao
interface CoffeeDao {

    @Insert
    suspend fun insert(coffee: Coffee)

    @Delete
    suspend fun delete(coffee: Coffee)

    @Update
    suspend fun update(coffee: Coffee)
}