package by.ocheretny.homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import by.ocheretny.homework.homework1.HW1Activity
import by.ocheretny.homework.homework2.HW2ActivityHome
import by.ocheretny.homework.homework3.HW3Activity
import by.ocheretny.homework.homework4.HW4Activity
import by.ocheretny.homework.homework7.HW7Activity
import by.ocheretny.homework.homework5.HW5Activity
import by.ocheretny.homework.homework8.HW8Activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDz1 = findViewById<Button>(R.id.button_dz1)
        val buttonDz2 = findViewById<Button>(R.id.button_dz2)
        val buttonDz3 = findViewById<Button>(R.id.button_dz3)
        val buttonDz4 = findViewById<Button>(R.id.button_dz4)
        val buttonDz5 = findViewById<Button>(R.id.button_dz5)
        val buttonDz7 = findViewById<Button>(R.id.button_dz7)
        val buttonDz8 = findViewById<Button>(R.id.button_dz8)

        buttonDz1.setOnClickListener {
            val intent = Intent(this, HW1Activity::class.java)
            startActivity(intent)
        }

        buttonDz2.setOnClickListener {
            val intent = Intent(this, HW2ActivityHome::class.java)
            startActivity(intent)
        }

        buttonDz3.setOnClickListener {
            val intent = Intent(this, HW3Activity::class.java)
            startActivity(intent)
        }
        buttonDz4.setOnClickListener {
            val intent = Intent(this, HW4Activity::class.java)
            startActivity(intent)
        }
        buttonDz5.setOnClickListener {
            val intent = Intent(this, HW5Activity::class.java)
            startActivity(intent)
        }

        buttonDz7.setOnClickListener {
            val intent = Intent(this, HW7Activity::class.java)
            startActivity(intent)
        }
        buttonDz8.setOnClickListener {
            val intent = Intent(this,HW8Activity::class.java)
            startActivity(intent)
        }
    }
}