package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import java.util.*

class StopwatchActivity : AppCompatActivity() {
    private var allSeconds = 0
    private var isRun = false
    private var wasRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null){
            allSeconds = savedInstanceState.getInt("sec")
            isRun = savedInstanceState.getBoolean("run")
            wasRunning = savedInstanceState.getBoolean("wasRun")
        }

        runTimer()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("sec", allSeconds)
        outState.putBoolean("run", isRun)
        outState.putBoolean("wasRun", wasRunning)
    }

    override fun onPause() {
        super.onPause()
        wasRunning = isRun
        isRun = false
    }

    override fun onResume() {
        super.onResume()
        if (wasRunning)
            isRun = true
    }

    fun onClickStart(view: View){
        isRun = true
    }

    fun onClickStop(view: View){
        isRun = false
    }

    fun onClickReset(view: View){
        isRun = false
        allSeconds = 0
    }

    private fun runTimer(){
        val timeView: TextView = findViewById(R.id.time_view)
        val handler = Handler()
        handler.run {
            post(object : Runnable {
                override fun run() {
                    var hours = allSeconds / 3600
                    var minutes = (allSeconds % 3600) / 60
                    var seconds = allSeconds % 60

                    timeView.text = String.format(Locale.getDefault(),
                            "%d:%02d:%02d", hours, minutes, seconds)

                    if (isRun)
                        allSeconds++
                    handler.postDelayed(this, 1000)
                }
            })
        }
    }
}
