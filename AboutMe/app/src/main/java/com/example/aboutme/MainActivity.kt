package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        done_button.setOnClickListener {
            addNickname(it)
        }
        nickname_text.setOnClickListener {
            updateNickname(it)
        }
    }

    private fun addNickname(view: View) {
        nickname_text.text = nickname_edit.text
        nickname_edit.visibility = View.GONE
        view.visibility = View.GONE
        nickname_text.visibility = View.VISIBLE
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view: View) {
        nickname_edit.visibility = View.VISIBLE
        done_button.visibility = View.VISIBLE
        view.visibility = View.GONE

        nickname_edit.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(nickname_edit, 0)
    }

}
