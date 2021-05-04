package by.ocheretny.homework.homework5

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import by.ocheretny.homework.R

class WelcomeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw5_welcome)

        val userName = findViewById<TextView>(R.id.hw5_user_name)

        userName.text ="${getString(R.string.welcome)} ${intent.getStringExtra(NAME)}"
    }
}