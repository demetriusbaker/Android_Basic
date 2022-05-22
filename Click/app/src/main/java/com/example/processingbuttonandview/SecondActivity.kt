package com.example.processingbuttonandview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.Random

class SecondActivity : AppCompatActivity() {
    private var tvRandom: TextView? = null
    private var tvLabel: TextView? = null

    companion object{
        const val TOTAL_COUNT = "Total count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        tvRandom = findViewById(R.id.textViewRandom)
        tvLabel = findViewById(R.id.textViewLabel)
        showRandomNumber()
    }

    private fun showRandomNumber(){
        val number = intent.getIntExtra(TOTAL_COUNT, 0)

        val random = Random()
        var result = 0

        if (number > 0)
            result = random.nextInt(number) + 1

        tvRandom?.text = result.toString()
        tvLabel?.text = getString(R.string.random_heading, number)
    }
}