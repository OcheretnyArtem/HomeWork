package by.ocheretny.homework.homework2

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import by.ocheretny.homework.R

class HW2ActivityTask2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw2_task2)


        val cats = findViewById<ImageView>(R.id.hw2_cat)

        cats.setImageResource(R.drawable.cat_animation)

        val catAnimation = cats.drawable as AnimationDrawable

        catAnimation.start()
    }

}