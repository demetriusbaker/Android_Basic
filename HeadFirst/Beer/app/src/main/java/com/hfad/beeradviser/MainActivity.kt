package com.hfad.beeradviser

import android.os.Bundle
import android.view.View
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var beerExpert = BeerExpert()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickFindBeer(view: View) {
        // get references from TextView and Spinner
        val brands = findViewById<TextView>(R.id.brands)
        val color = findViewById<Spinner>(R.id.color)
        // get text from Spinner
        val beerType: String = color.selectedItem as String

        // Output List:
        // brands.text = beerExpert.getBrands(beerType).toString()

        // Creation and initialisation of List and output string
        var brandList = beerExpert.getBrands(beerType)

        var brandsFormatted = StringBuilder()
        for (bl in brandList)
            brandsFormatted.append(bl).append('\n')

        // Output result on TextView
        brands.text = brandsFormatted
    }
}