package com.example.stopwatchjava

import android.os.Handler
import java.util.*

class fkldsjkl {
    private fun main() {
        val handler = Handler()
        handler.post(object : Runnable {
            override fun run() {
                var allSeconds = 0
                val hours = allSeconds / 3600
                val minutes = allSeconds % 3600 / 60
                val seconds = allSeconds % 60

                val isRun = true
                if (isRun) allSeconds++
                handler.postDelayed(this, 1000)
            }
        })
    }
}