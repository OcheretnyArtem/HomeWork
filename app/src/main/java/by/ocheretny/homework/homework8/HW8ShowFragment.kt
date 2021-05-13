package by.ocheretny.homework.homework8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import by.ocheretny.homework.R
import by.ocheretny.homework.homework8.recycler.CoffeeAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputLayout


class HW8ShowFragment : Fragment() {

        private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(HW8ViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hw8_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.hw8_recycler)
        val addButton = view.findViewById<FloatingActionButton>(R.id.hw8_add_button)
        val progressBar = view.findViewById<ProgressBar>(R.id.hw8_progress_bar)
        val finder = view.findViewById<TextInputLayout>(R.id.text_finder)

        viewModel.getAll()

        viewModel.isLoading.observe(requireActivity()){
            if (it) progressBar.visibility = View.VISIBLE
            else progressBar.visibility = View.GONE
        }

        viewModel.listOfCoffee.observe(requireActivity()){
            recycler.adapter = CoffeeAdapter(it,viewModel)
        }

        addButton.setOnClickListener {
            findNavController().navigate(R.id.show_HW8AddFragment)
        }
        finder.editText?.addTextChangedListener{
            if (!it.isNullOrEmpty()) viewModel.find(it.toString())
            else viewModel.getAll()
        }
    }

}