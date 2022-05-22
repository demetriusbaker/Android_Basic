package com.hfad.componentsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class ComponentsExample2 : AppCompatActivity() {
    private var count = 0
    private var flag = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_components_example2)
    }

    fun setPhoto(view: View){
        val photo = findViewById<ImageView>(R.id.imageView)
        val image = R.drawable.image
        photo.setImageResource(image)
    }

    fun changeImage(view: View){
        val imageButton = findViewById<ImageButton>(R.id.imageButton)

        if (flag)
            imageButton.setImageResource(R.drawable.image)
        else
            imageButton.setImageResource(R.drawable.ic_launcher_foreground)


        flag = !flag
    }

    fun getNotification(view: View){
        Toast.makeText(this, "This is notification ${++count}!",
            Toast.LENGTH_SHORT).show()
    }
}