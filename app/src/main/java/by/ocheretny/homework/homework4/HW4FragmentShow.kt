package by.ocheretny.homework.homework4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.ocheretny.homework.R
import kotlinx.android.synthetic.main.fragment_hw4_show.*

class HW4FragmentShow : Fragment() {

    lateinit var viewModel: HW4ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hw4_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = SnowdropsAdapter(requireContext())

        viewModel = ViewModelProvider(requireActivity()).get(HW4ViewModel::class.java)

        snowdrop_recyclerView.layoutManager = LinearLayoutManager(requireContext())
        snowdrop_recyclerView.adapter = adapter

        viewModel.snowdrops.observe(requireActivity()){

            if (!it.isNullOrEmpty()){
                adapter.setItems(it)
            }

        }
    }
}
