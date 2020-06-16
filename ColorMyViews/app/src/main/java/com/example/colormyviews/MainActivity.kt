package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun makeColored(view: View) {
        when (view) {
            box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            box_two_text -> view.setBackgroundColor(Color.GRAY)
            box_three_text -> view.setBackgroundColor(Color.BLUE)
            box_four_text -> view.setBackgroundColor(Color.MAGENTA)
            box_five_text -> view.setBackgroundColor(Color.BLUE)
            red_button -> box_three_text.setBackgroundResource(R.color.my_red)
            yellow_button -> box_four_text.setBackgroundResource(R.color.my_yellow)
            green_button -> box_five_text.setBackgroundResource(R.color.my_green)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun setListeners() {
        val clickableView: List<View> =
            listOf(
                box_one_text, box_two_text, box_three_text,
                box_four_text, box_five_text, constraint_layout,
                red_button, yellow_button, green_button
            )

        for (item in clickableView) {
            item.setOnClickListener { makeColored(it) }
        }
    }
}
