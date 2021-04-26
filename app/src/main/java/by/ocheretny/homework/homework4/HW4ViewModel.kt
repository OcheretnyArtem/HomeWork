package by.ocheretny.homework.homework4

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData as LiveData

class HW4ViewModel : ViewModel() {

    private val _snowdrops = MutableLiveData<ArrayList<Snowdrop>>(
        arrayListOf(
            Snowdrop(
                "Галантус",
                "Многолетнее луковичное растение из семейства амариллисовых, высотой до 15-18 см," +
                        " с линейными темно-зелеными листьями и пониклыми белыми цветками. " +
                        "Цветки появляются ранней весной одновременно с листьями, вслед за тающим снегом.",
                "https://felisov.ru/wp-content/uploads/jfb9c2.jpg"
            ),
            Snowdrop(
                "Офелия",
                "О них мечтают все цветоводы-любители. Однако в пониклых цветках махровость заметна лишь на близком расстоянии.",
                "https://italianbotanicaltrips.com/wp-content/uploads/2017/01/Galanthus_nivalis_flore_pleno_1.jpg"
            ),
            Snowdrop(
                "Голубой подснежник",
                "Цветки колокольчатой или звездчатой формы голубого или синего цвета, реже встречаются розовые, белые и пурпурные, расположенные одиночно или собранные в кисти.",
                "https://photoclub.by/images/main74/749260_main.jpg"
            )
        )
    )

    val snowdrops : LiveData<ArrayList<Snowdrop>>
        get() = _snowdrops

    fun addSnowdrop(snowdrop: Snowdrop) {
        _snowdrops.apply {
            value?.add(snowdrop)
        }
    }
}