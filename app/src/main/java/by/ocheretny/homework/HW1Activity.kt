package by.ocheretny.homework

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class HW1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wh1)

        val button = findViewById<Button>(R.id.trigger_button)
        val textUrl = findViewById<TextView>(R.id.input_text)
        val image = findViewById<ImageView>(R.id.incoming_picture)

        button.setOnClickListener {
            if (textUrl.text.isNullOrEmpty()) {
                Toast.makeText(this, "you did not enter a URL", Toast.LENGTH_SHORT).show()
            } else {
                Picasso.get().load(textUrl.text.toString()).into(image)
            }

        }
    }
}