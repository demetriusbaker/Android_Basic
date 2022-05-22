package com.hfad.liquidbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.gospelware.liquidbutton.LiquidButton

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var liquidButton: LiquidButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        liquidButton = findViewById(R.id.button)
        textView = findViewById(R.id.textView)

        liquidButton.setOnClickListener {
            val btn: LiquidButton = it as LiquidButton
            btn.startPour()
        }
        liquidButton.isFillAfter = true
        liquidButton.isAutoPlay = true

        liquidButton.run {
            setPourFinishListener(object : LiquidButton.PourFinishListener{
                override fun onPourFinish() {
                    Toast.makeText(this@MainActivity, "Finish download!!!",
                        Toast.LENGTH_SHORT).show()
                }

                override fun onProgressUpdate(progress: Float) {
                    textView.text = "${String.format("%.2f", progress * 100)}%"
                }
            })
        }
    }
}