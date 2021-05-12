package by.ocheretny.homework.homework8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.ocheretny.homework.R
import by.ocheretny.homework.homework8.dataBase.entity.Coffee
import by.ocheretny.homework.homework8.recycler.CoffeeAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_hw8_show.*

//    private val viewModel by lazy {
//        ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
//            .create(HW8ViewModel::class.java)
//    }

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

        viewModel.getAll()

        viewModel.isLoading.observe(requireActivity()){
            if (it) progressBar.visibility = View.VISIBLE
            else progressBar.visibility = View.GONE
        }

        viewModel.listOfCoffee.observe(requireActivity()){
            recycler.adapter = CoffeeAdapter(it,viewModel)
        }

        addButton.setOnClickListener {
            findNavController().navigate(R.id.HW8AddFragment)
        }
    }

}