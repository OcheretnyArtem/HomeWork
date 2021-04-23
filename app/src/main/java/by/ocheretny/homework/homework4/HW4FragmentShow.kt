package by.ocheretny.homework.homework4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import by.ocheretny.homework.R
import com.squareup.picasso.Picasso
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
        viewModel = ViewModelProvider(requireActivity()).get(HW4ViewModel::class.java)

        val snowdropsNames = getNameOfSnowdrop(viewModel.snowdrops)

        val arrayAdapter = ArrayAdapter(
            requireContext(),
            R.layout.support_simple_spinner_dropdown_item,
            snowdropsNames
        )

        spinner_snowdrop.adapter = arrayAdapter

        spinner_snowdrop.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                viewModel.snowdrops.observe(requireActivity()) {
                    days_description_snowdrop.text = it[position].description
                    Picasso.get().load(it[position].ImageURL).into(image_of_snowdrop)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }
}

private fun getNameOfSnowdrop(list: LiveData<ArrayList<Snowdrop>>): Array<String> {
    return list.value?.map { it.name }?.toTypedArray() ?: arrayOf("")
}
