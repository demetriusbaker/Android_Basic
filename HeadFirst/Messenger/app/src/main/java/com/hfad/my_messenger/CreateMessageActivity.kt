package com.hfad.my_messenger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class CreateMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_message)
    }

    fun onSendMessage(view: View){
        var messageView: EditText = findViewById(R.id.message)
        var messageText: String = messageView.text.toString()
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, messageText)
        // startActivity(intent)
        val chooserTitle = getString(R.string.chooser)
        val chosenIntent = Intent.createChooser(intent, chooserTitle)
        startActivity(chosenIntent)
        /*
        В startActivity я кидаю не просто интент, а интент внутри
        специального метода, с помощью которого, при каждом его вызове,
        пользователю необходимо выбирать приложение (нет приложения по умолчанию)
         */
    }
}