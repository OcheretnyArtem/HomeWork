package by.ocheretny.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDz1 = findViewById<Button>(R.id.button_dz1)
        val buttonDz2 = findViewById<Button>(R.id.button_dz2)
        val buttonDz3 = findViewById<Button>(R.id.button_dz3)


        buttonDz1.setOnClickListener {
        }

        buttonDz2.setOnClickListener {
        }

        buttonDz3.setOnClickListener {
        }
    }
}