package by.ocheretny.homework.homework8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.ocheretny.homework.R
import by.ocheretny.homework.homework8.dataBase.entity.Coffee
import com.google.android.material.textfield.TextInputLayout

class HW8AddFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(HW8ViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hw8_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val fieldName = view.findViewById<TextInputLayout>(R.id.hw8_add_name_field)
        val fieldURL = view.findViewById<TextInputLayout>(R.id.hw8_add_URL_field)
        val fieldPrice = view.findViewById<TextInputLayout>(R.id.hw8_add_price_field)
        val saveButton = view.findViewById<Button>(R.id.hw8_save_button)

        saveButton.setOnClickListener {

            if (fieldName.editText?.text.isNullOrEmpty()) {
                fieldName.error = getString(R.string.field_is_empty)
                return@setOnClickListener
            } else {
                fieldName.error = null
            }
            if (fieldURL.editText?.text.isNullOrEmpty()) {
                fieldURL.error = getString(R.string.field_is_empty)
                return@setOnClickListener
            } else {
                fieldURL.error = null
            }
            if (fieldPrice.editText?.text.isNullOrEmpty()) {
                fieldPrice.error = getString(R.string.field_is_empty)
                return@setOnClickListener
            } else {
                fieldPrice.error = null
            }

            viewModel.insert(
                Coffee(
                    fieldName.editText?.text.toString(),
                    fieldURL.editText?.text.toString(),
                    fieldPrice.editText?.text.toString().toInt()
                )
            )
            activity?.supportFragmentManager?.popBackStack()
        }
    }
}