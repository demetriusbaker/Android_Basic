package com.hfad.clickerapplication

import android.content.pm.ActivityInfo
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView

class VideoPlayerWonClickerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player_won_clicker)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        val videoPlayer = findViewById<VideoView>(R.id.videoView)
        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.epicwin)
        videoPlayer.setVideoURI(videoUri)
        videoPlayer.start()
    }
}