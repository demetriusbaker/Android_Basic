package com.example.kotlin_lesson_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class SexondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sexond)
        var tvMessage = findViewById<TextView>(R.id.tvMessage)
        var i = intent

        if (i != null)
            tvMessage.text = i.getCharSequenceExtra("Hi Android!")
    }

    fun dontClick(view: View){
        val intent = Intent(this, ThirdActivity::class.java)
        startActivity(intent)
    }
}