package by.ocheretny.homework.homework3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import java.util.*

class HW3ViewModel : ViewModel() {

    private val random = Random()

    val winner = MutableLiveData<Int>(null)
    val minsk = MutableLiveData<Region>(Region("minsk", 0))
    val brest = MutableLiveData<Region>(Region("brest", 1))
    val gomel = MutableLiveData<Region>(Region("gomel", 2))

    private val countToWin = 1000

    fun loadingData() {

        viewModelScope.launch {

            while (winner.value == null) {

                delay(random.nextInt(3000).toLong())

                minsk.value = minsk.value.also {

                    it?.countRye = it?.countRye?.plus(random.nextInt(100)) ?: 0
                    it?.countBarley = it?.countBarley?.plus(random.nextInt(100)) ?: 0
                    it?.countCorn = it?.countCorn?.plus(random.nextInt(100)) ?: 0

                    if (it?.countRye ?: 0 >= countToWin &&
                        it?.countBarley ?: 0 >= countToWin &&
                        it?.countCorn ?: 0 >= countToWin
                    ) {
                        winner.value = minsk.value?.id
                    }
                }
            }
        }

        viewModelScope.launch {

            while (winner.value == null) {

                delay(random.nextInt(3000).toLong())

                brest.value = brest.value.also {

                    it?.countRye = it?.countRye?.plus(random.nextInt(100)) ?: 0
                    it?.countBarley = it?.countBarley?.plus(random.nextInt(100)) ?: 0
                    it?.countCorn = it?.countCorn?.plus(random.nextInt(100)) ?: 0

                    if (it?.countRye ?: 0 >= countToWin &&
                        it?.countBarley ?: 0 >= countToWin &&
                        it?.countCorn ?: 0 >= countToWin
                    ) {
                        winner.value = brest.value?.id
                    }
                }
            }
        }

        viewModelScope.launch {

            while (winner.value == null) {

                delay(random.nextInt(3000).toLong())

                gomel.value = gomel.value.also {

                    it?.countRye = it?.countRye?.plus(random.nextInt(100)) ?: 0
                    it?.countBarley = it?.countBarley?.plus(random.nextInt(100)) ?: 0
                    it?.countCorn = it?.countCorn?.plus(random.nextInt(100)) ?: 0

                    if (it?.countRye ?: 0 >= countToWin &&
                        it?.countBarley ?: 0 >= countToWin &&
                        it?.countCorn ?: 0 >= countToWin
                    ) {
                        winner.value = gomel.value?.id
                    }
                }
            }
        }
    }

}
