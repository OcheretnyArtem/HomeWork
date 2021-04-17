package by.ocheretny.homework.homework3

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import by.ocheretny.homework.R
import kotlinx.android.synthetic.main.activity_hw3.*
import kotlinx.coroutines.cancel

class HW3Activity : AppCompatActivity() {

    lateinit var viewModel: HW3ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw3)
        viewModel = ViewModelProvider(this).get(HW3ViewModel::class.java)

        viewModel.winner.observe(this) {

            if (it != null) viewModel.viewModelScope.cancel()

            when (it) {
                0 -> {
                    minsk_layout.setBackgroundColor(getColor(R.color.winner))
                    Toast.makeText(this, "Congratulations to Minsk!", Toast.LENGTH_LONG).show()
                }
                1 -> {
                    brest_layout.setBackgroundColor(getColor(R.color.winner))
                    Toast.makeText(this, "Congratulations to Brest!", Toast.LENGTH_LONG).show()

                }
                2 -> {
                    gomel_layout.setBackgroundColor(getColor(R.color.winner))
                    Toast.makeText(this, "Congratulations to Gomel!", Toast.LENGTH_LONG).show()

                }
            }
        }

        viewModel.minsk.observe(this) {
            minsk_rye_count.text = it.countRye.toString()
            minsk_barley_count.text = it.countBarley.toString()
            minsk_corn_count.text = it.countCorn.toString()

        }
        viewModel.brest.observe(this) {
            brest_rye_count.text = it.countRye.toString()
            brest_barley_count.text = it.countBarley.toString()
            brest_corn_count.text = it.countCorn.toString()
        }
        viewModel.gomel.observe(this) {
            gomel_rye_count.text = it.countRye.toString()
            gomel_barley_count.text = it.countBarley.toString()
            gomel_corn_count.text = it.countCorn.toString()
        }

        viewModel.loadingData()
    }

}