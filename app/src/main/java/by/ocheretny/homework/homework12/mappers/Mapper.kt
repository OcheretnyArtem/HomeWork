package by.ocheretny.homework.homework12.mappers

interface Mapper<F, T> {

    fun map(from: F): T
}