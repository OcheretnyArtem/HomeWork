package by.ocheretny.homework.homework4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.ocheretny.homework.R
import kotlinx.android.synthetic.main.activity_hw4.*
import kotlinx.android.synthetic.main.fragment_hw4_add.*

class HW4FragmentAdd : Fragment() {

    lateinit var viewModel: HW4ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hw4_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(HW4ViewModel::class.java)

        button_hw4_save.setOnClickListener {
            if (!hw4_input_name.text.isNullOrEmpty() && !hw4_input_description.text.isNullOrEmpty() && !hw4_input_URL.text.isNullOrEmpty()) {
                viewModel.addSnowdrop(
                    Snowdrop(
                        hw4_input_name.text.toString(),
                        hw4_input_description.text.toString(),
                        hw4_input_URL.text.toString()
                    )
                )
                Toast.makeText(requireContext(), "Snowdrop added", Toast.LENGTH_SHORT).show()

                hw4_input_name.text.clear()
                hw4_input_description.text.clear()
                hw4_input_URL.text.clear()
            } else Toast.makeText(requireContext(), "Fill in all the fields", Toast.LENGTH_SHORT)
                .show()
        }
    }
}