package by.ocheretny.homework.homework9

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import by.ocheretny.homework.R
import by.ocheretny.homework.homework8.HW8ViewModel
import by.ocheretny.homework.homework9.data.HW9ViewModel
import by.ocheretny.homework.homework9.recycler.CoinAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import retrofit2.Response.error

class HW9Activity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProvider(this).get(HW9ViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw9)

        val recycler = findViewById<RecyclerView>(R.id.hw9_recycler)
        val progressBar = findViewById<ProgressBar>(R.id.hw9_progress_bar)

        viewModel.loadData("fdb38449-f48e-41bd-97f9-b6860ee8edb5")

        viewModel.coins.observe(this){
            val coinAdapter = CoinAdapter(it)
            recycler.adapter = coinAdapter
        }

        viewModel.isLoading.observe(this){
            if (it) progressBar.visibility = View.VISIBLE
            else progressBar.visibility = View.GONE
        }

        viewModel.errorBus.observe(this) {
            MaterialAlertDialogBuilder(this)
                .setTitle(getString(R.string.error))
                .setMessage(it)
                .show()
        }

    }
}