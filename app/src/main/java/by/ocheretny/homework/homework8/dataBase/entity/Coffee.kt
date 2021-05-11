package by.ocheretny.homework.homework8.dataBase.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coffee_table")
data class Coffee(
    @ColumnInfo(name = "coffee_name")
    val name: String,
    @ColumnInfo(name = "coffee_imj")
    val imjURL: String,
    @ColumnInfo(name = "coffee_price")
    val price: Int,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

}