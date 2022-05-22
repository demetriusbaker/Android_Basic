package com.bignerdranch.android.demoprogressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var progressCircle = 0
    private var pbHorizontal: ProgressBar? = null
    private var tvProgressHorizontal: TextView? = null
    private var tvProgressCircle: TextView? = null
    private var buttonStart: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pbHorizontal = findViewById(R.id.pb_horizontal)
        tvProgressHorizontal = findViewById(R.id.tv_progress_horizontal)
        tvProgressCircle = findViewById(R.id.tv_progress_circle)
        buttonStart = findViewById(R.id.btn_start)

        buttonStart?.setOnClickListener {
            progressCircle = if (progressCircle == 100) 0 else progressCircle + 10
            postProgress(progressCircle)
        }
    }

    private fun postProgress(progress: Int){
        pbHorizontal?.progress = progress
        pbHorizontal?.secondaryProgress = if (progress == 0) 0 else progress + 5
        val strProgress = "$progress %"
        tvProgressHorizontal?.text = strProgress
        tvProgressCircle?.text = strProgress
    }
}