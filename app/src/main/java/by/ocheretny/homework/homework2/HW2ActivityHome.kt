package by.ocheretny.homework.homework2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import by.ocheretny.homework.R

class HW2ActivityHome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw2_home)

        val task1Button = findViewById<Button>(R.id.button_hw2_task1)
        val task2Button = findViewById<Button>(R.id.button_hw2_task2)

        task1Button.setOnClickListener {
            val intent = Intent(this, HW2ActivityTask1::class.java)
            startActivity(intent)
        }

        task2Button.setOnClickListener {
            val intent = Intent(this, HW2ActivityTask2::class.java)
            startActivity(intent)
        }
    }
}