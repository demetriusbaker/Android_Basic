package com.example.processingbuttonandview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var tvText: TextView? = null
    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvText = findViewById(R.id.textView)
    }

    fun clickToastButton(view: View) =
            Toast.makeText(this, "Pop-up message", Toast.LENGTH_SHORT).show()

    fun clickCountButton(view: View){
        tvText?.text = (++number).toString()
    }

    fun clickRandomButton(view: View){
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(SecondActivity.TOTAL_COUNT, number)
        startActivity(intent)
    }
}