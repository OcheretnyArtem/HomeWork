package by.ocheretny.homework.homework8

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.ocheretny.homework.R
import by.ocheretny.homework.homework5.NAME
import by.ocheretny.homework.homework5.WelcomeActivity
import by.ocheretny.homework.homework8.dataBase.entity.Coffee
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout

class HW8UpdateFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(HW8ViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hw8_update, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coffee = viewModel.selectedCoffee.value

        val ff = coffee?.id

        val fieldName = view.findViewById<TextInputLayout>(R.id.hw8_update_name_field)
        val fieldURL = view.findViewById<TextInputLayout>(R.id.hw8_update_URL_field)
        val fieldPrice = view.findViewById<TextInputLayout>(R.id.hw8_update_price_field)
        val updateButton = view.findViewById<Button>(R.id.hw8_update_button)
        val deleteButton = view.findViewById<Button>(R.id.hw8_delete_button)

        fieldName.editText?.setText(coffee?.name)
        fieldPrice.editText?.setText(coffee?.price.toString())
        fieldURL.editText?.setText(coffee?.imageURL)

        updateButton.setOnClickListener {
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
            coffee?.id?.let { id ->
                viewModel.update(
                    id,
                    fieldName.editText?.text.toString(),
                    fieldPrice.editText?.text.toString().toInt(),
                    fieldURL.editText?.text.toString()
                )
            }
            findNavController().popBackStack()
        }

        deleteButton.setOnClickListener {
            if (coffee != null) {
                MaterialAlertDialogBuilder(requireContext())
                    .setTitle("${getString(R.string.remove_coffee)} ${coffee.name}")
                    .setNegativeButton(getString(R.string.no)) { dialog, _ ->
                        dialog.dismiss()
                    }.setPositiveButton(getString(R.string.yes)) { _, _ ->
                        viewModel.delete(coffee)
                        findNavController().popBackStack()
                    }.show()
            }

        }
    }
}