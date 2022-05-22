package com.example.kotlin_lesson_1

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    private var tvText: TextView? = null
    private var count = 1
    private var isStart = false
    private var Screen: ConstraintLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvText = findViewById(R.id.tvText)
        // tvText?.setText(25.toString())
        Screen = findViewById(R.id.Screen)

        Thread {
            isStart = true
            while (isStart){
                Thread.sleep(1000)
                runOnUiThread {
                    when {
                        count % 3 == 0 -> Screen?.setBackgroundColor(Color.RED)
                        count % 3 == 1 -> Screen?.setBackgroundColor(Color.BLUE)
                        else -> Screen?.setBackgroundColor(Color.GREEN)
                    }
                    tvText?.text = count.toString()
                    count++
                }
            }
        }.start()

        // нельзя изменять элементы экрана из второстепенного потока!
    }
}