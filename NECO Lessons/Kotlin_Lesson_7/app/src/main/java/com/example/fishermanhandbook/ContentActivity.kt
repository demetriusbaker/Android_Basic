package com.example.fishermanhandbook

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)

        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        val textViewContent = findViewById<TextView>(R.id.textViewContent)
        val imageFish = findViewById<ImageView>(R.id.imageFish)

        textViewTitle.text = intent.getStringExtra("title")
        textViewContent.text = intent.getStringExtra("content")
        imageFish.setImageResource(intent.getIntExtra("image", R.drawable.crusian_carp))
    }
}