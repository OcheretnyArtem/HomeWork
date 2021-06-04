package by.ocheretny.homework.homework12.data.mapper

interface Mapper<F, T> {

    fun map(from: F): T
}