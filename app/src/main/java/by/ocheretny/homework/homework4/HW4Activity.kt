package by.ocheretny.homework.homework4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import by.ocheretny.homework.R
import by.ocheretny.homework.homework3.HW3ViewModel
import kotlinx.android.synthetic.main.activity_hw4.*

class HW4Activity : AppCompatActivity() {

    lateinit var viewModel: HW4ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw4)
        viewModel = ViewModelProvider(this).get(HW4ViewModel::class.java)

        val fragmentAdd = HW4FragmentAdd()
        val fragmentShow = HW4FragmentShow()

        button_hw4_add.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container_hw4, fragmentAdd)
                .commit()
        }
        button_hw4_show.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container_hw4, fragmentShow)
                .commit()
        }
    }
}