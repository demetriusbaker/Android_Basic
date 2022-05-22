package com.hfad.my_messenger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ReceiveMessageActivity : AppCompatActivity() {
    companion object{
        val EXTRA_MESSAGE: String = "message"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receive_message)

        val intent: Intent = intent
        val messageText: String = intent.getStringExtra(EXTRA_MESSAGE).toString()
        val messageView: TextView = findViewById(R.id.gotMessage)
        messageView.text = messageText
    }
}