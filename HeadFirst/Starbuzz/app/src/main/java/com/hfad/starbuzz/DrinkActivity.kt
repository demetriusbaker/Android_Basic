package com.hfad.starbuzz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DrinkActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DRINKID = "drinkID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink)

        // получить напиток из данных интента
        val drinkId: Int = intent.extras?.get(EXTRA_DRINKID) as Int
        val drink = Drink.drinks[drinkId]

        // Заполнение названия напитка
        val name = findViewById<TextView>(R.id.name)
        name.text = drink.name

        // Заполнение описания напитка
        val description = findViewById<TextView>(R.id.description)
        description.text = drink.description

        // Заполнение изображения напитка
        val photo = findViewById<ImageView>(R.id.photo)
        photo.setImageResource(drink.imageResourceId)
        photo.contentDescription = drink.name
    }
}