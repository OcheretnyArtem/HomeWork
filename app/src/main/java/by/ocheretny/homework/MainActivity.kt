package by.ocheretny.homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import by.ocheretny.homework.homework1.HW1Activity
import by.ocheretny.homework.homework2.HW2ActivityHome

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDz1 = findViewById<Button>(R.id.button_dz1)
        val buttonDz2 = findViewById<Button>(R.id.button_dz2)
        val buttonDz3 = findViewById<Button>(R.id.button_dz3)

        val intentHW1 = Intent(this, HW1Activity::class.java)
        val intentHW2 = Intent(this, HW2ActivityHome::class.java)

        buttonDz1.setOnClickListener {
            startActivity(intentHW1)
        }

        buttonDz2.setOnClickListener {
            startActivity(intentHW2)
        }

        buttonDz3.setOnClickListener {
        }
    }
}