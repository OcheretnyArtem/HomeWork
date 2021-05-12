package by.ocheretny.homework.homework8.dataBase.dao

import androidx.room.*
import by.ocheretny.homework.homework8.dataBase.entity.Coffee

@Dao
interface CoffeeDao {

    @Insert
    suspend fun insert(coffee: Coffee)

    @Delete
    suspend fun delete(coffee: Coffee)

    @Query("UPDATE coffee_table SET coffee_name = :name, coffee_price = :prise, coffee_image = :url WHERE id = :id")
    suspend fun update(id: Int, name: String, prise: Int, url: String)

    @Query("SELECT * FROM coffee_table")
    suspend fun getAll(): List<Coffee>

    @Query("SELECT coffee_name FROM coffee_table")
    suspend fun getNames(): List<String>
}