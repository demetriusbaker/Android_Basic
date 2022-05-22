package com.example.semafor

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import java.util.Timer
import java.util.TimerTask

class MainActivity : Activity() {
    var semafor: ImageView? = null
    var counter = 0
    private var timer: Timer? = null
    private var isRun = false
    var imageArray: IntArray = intArrayOf(R.drawable.red,
            R.drawable.yellow, R.drawable.green)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        semafor = findViewById(R.id.IVSemafor)
    }

    fun onClickStartStop(view: View){
        view as ImageButton // casting
        if (!isRun){
            startStop()

            view.setImageResource(R.drawable.stop)
            isRun = true
            counter = 0
        } else {
            semafor?.setImageResource(R.drawable.black)
            view.setImageResource(R.drawable.start)
            timer?.cancel()
            isRun = false
        }
    }

    private fun startStop() {
        timer = Timer()

        timer?.schedule(object: TimerTask(){
            override fun run() {
                runOnUiThread{
                    semafor?.setImageResource(imageArray[counter])

                    counter++
                    if (counter == 3)
                        counter = 0
                }
            }
        }, 0, 1000)
    }
}