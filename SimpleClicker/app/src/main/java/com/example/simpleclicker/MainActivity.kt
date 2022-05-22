package com.example.simpleclicker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var countText: TextView? = null
    private var number: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        countText = findViewById(R.id.textView)
        number = savedInstanceState?.getInt("num") ?: (countText?.text as String).toInt()

        showValue()

        if (number == 0)
            goOverInOtherActivity()
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putInt("num", number)
    }

    fun reduceValue(view: View){
        number--
        showValue()
    }

    private fun showValue(){
        if (number % 100 == 0)
            Toast.makeText(this, "Left $number", Toast.LENGTH_SHORT).show()

        countText?.text = number.toString()
    }

    private fun goOverInOtherActivity(){
        val intent = Intent(this, WinActivity::class.java).apply {
            // putExtra()
        }
        startActivity(intent)
    }
}