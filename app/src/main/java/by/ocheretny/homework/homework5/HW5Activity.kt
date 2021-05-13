package by.ocheretny.homework.homework5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import by.ocheretny.homework.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout

const val NAME = "STRING NAME"


class HW5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw5)

        val name = findViewById<TextInputLayout>(R.id.text_input_layout_name)
        val password = findViewById<TextInputLayout>(R.id.text_input_layout_password)
        val registration = findViewById<Button>(R.id.button_hw5_registration)

        registration.setOnClickListener {
            if (name.editText?.text.isNullOrEmpty()) {
                name.helperText = getString(R.string.field_is_empty)
                return@setOnClickListener
            } else {
                name.helperText = null
            }
            if (password.editText?.text.isNullOrEmpty()) {
                password.helperText = getString(R.string.field_is_empty)
                return@setOnClickListener
            } else {
                password.helperText = null
            }
            if (password.editText?.text.toString().length < 8) {
                password.helperText = getString(R.string.password_less_then_8)
                return@setOnClickListener
            } else {
                password.helperText = null
            }
            MaterialAlertDialogBuilder(this)
                .setTitle(getString(R.string.registration_complete))
                .setIcon(R.drawable.ic_baseline_done_outline_24)
                .setNegativeButton(getString(R.string.ok)) { dialog, _ ->
                    dialog.dismiss()
                }.setPositiveButton(getString(R.string.sing_in)) { _, _ ->
                    val intent = Intent(this, WelcomeActivity::class.java)
                    intent.putExtra(NAME, name.editText?.text.toString())
                    startActivity(intent)
                }.show()
        }
    }
}