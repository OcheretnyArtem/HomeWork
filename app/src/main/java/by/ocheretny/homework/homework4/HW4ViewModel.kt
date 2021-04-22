package by.ocheretny.homework.homework4

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HW4ViewModel : ViewModel() {

    val snowdrops = ArrayList<MutableLiveData<Snowdrop>>().apply {
        this.add(
            MutableLiveData<Snowdrop>(
                Snowdrop(
                    "Галантус",
                    "Многолетнее луковичное растение из семейства амариллисовых, высотой до 15-18 см," +
                            " с линейными темно-зелеными листьями и пониклыми белыми цветками. " +
                            "Цветки появляются ранней весной одновременно с листьями, вслед за тающим снегом.",
                    "https://felisov.ru/wp-content/uploads/jfb9c2.jpg"
                )
            )
        )
        this.add(
            MutableLiveData<Snowdrop>(
                Snowdrop(
                    "Офелия",
                    "О них мечтают все цветоводы-любители. Однако в пониклых цветках махровость заметна лишь на близком расстоянии.",
                    "https://italianbotanicaltrips.com/wp-content/uploads/2017/01/Galanthus_nivalis_flore_pleno_1.jpg"
                )
            )
        )
        this.add(
            MutableLiveData<Snowdrop>(
                Snowdrop(
                    "Голубой подснежник",
                    "Цветки колокольчатой или звездчатой формы голубого или синего цвета, реже встречаются розовые, белые и пурпурные, расположенные одиночно или собранные в кисти.",
                    "https://photoclub.by/images/main74/749260_main.jpg"
                )
            )
        )
    }

    fun addSnowdrop(snowdrop: Snowdrop) {
        snowdrops.apply {
            this.add(MutableLiveData<Snowdrop>(snowdrop))
        }
    }
}