package com.example.kotlin_lesson_23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var textOnScreen: TextView? = null
    private var textOnScreen2: TextView? = null
    private var text = "В этом тексте есть слова: <рак>, <пиво> и <щука>!"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textOnScreen = findViewById(R.id.textOnScreen)
        textOnScreen2 = findViewById(R.id.textOnScreen2)

        var word1 = text.substringAfter("<").substringBefore(">")
        var word2 = text.substringAfter(">").substringAfter("<").
        substringBefore(">")

        textOnScreen?.text = word1
        textOnScreen2?.text = word2

        getExample1()
        getExample2()
    }

    private fun getExample1(){
        for (i in 1 until text.length) Log.d("Beer", "Beer$i")

        var count = 0
        for (i in 1 until text.length)
            if (text.get(i) == '<') count++

        Log.d("Show", "$count")
    }

    private fun getExample2(){
        var startPositionCounter = 0
        var endPositionCounter = 0
        var count = 0

        for (i in text.indices)
            if (text[i] == '<')
                count++

        var startPosition = IntArray(count)
        var endPosition = IntArray(count)

        for (i in text.indices){
            if (text[i] == '<')
                startPosition[startPositionCounter++] = i
            if (text[i] == '>')
                endPosition[endPositionCounter++] = i
        }

        var textFoundArray = Array(count){""}
        for (i in 0 until count){
            textFoundArray[i] = text.substring(startPosition[i] + 1, endPosition[i])
            Log.d("TextFoundArray", "Founded words: ${textFoundArray[i]}")
        }
    }
}