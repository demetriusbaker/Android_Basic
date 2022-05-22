package com.hfad.clickerapplication

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.hfad.clickerapplication.db.MyDBManager

class MainActivity : AppCompatActivity() {
    private var count = 1000
    private val myDBManager: MyDBManager = MyDBManager(this)
    private var infoScore: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        infoScore = findViewById(R.id.infoScore)

        myDBManager.openDB()
        val numberList: ArrayList<Int> = myDBManager.readDBData()
        if (numberList.isNotEmpty())
            count = numberList[numberList.size - 1]

        infoScore?.text = count.toString()

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    fun decreaseScore(view: View){
        infoScore?.text = "${--count}"
        if (count < 1){
            startActivity(Intent(this, VideoPlayerWonClickerActivity::class.java))
            count = 1
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        myDBManager.insertToDB(count)
        myDBManager.readDBData().add(count)
        myDBManager.closeDB()
    }
}