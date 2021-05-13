package by.ocheretny.homework.homework7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import by.ocheretny.homework.R

class HW7SecondFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hw7_second,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val image9May = view.findViewById<ImageView>(R.id.may_9_image_main)
        val text9May = view.findViewById<TextView>(R.id.may_9_text_main)

        val extraImage = FragmentNavigatorExtras(
            Pair(image9May,"image")
        )
        val extraText = FragmentNavigatorExtras(
            Pair(text9May,"text")
        )


        image9May.setOnClickListener{
           findNavController().navigate(R.id.show_HW7ImageFragment,null,null,extraImage)

        }

        text9May.setOnClickListener{
            findNavController().navigate(R.id.show_HW7TextFragment,null,null,extraText)
        }
    }
}