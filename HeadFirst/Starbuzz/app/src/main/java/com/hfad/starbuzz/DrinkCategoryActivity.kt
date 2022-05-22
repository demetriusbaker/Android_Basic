package com.hfad.starbuzz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class DrinkCategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_category)

        val arrayAdapter: ArrayAdapter<Drink> = ArrayAdapter(this,
                R.layout.support_simple_spinner_dropdown_item, Drink.drinks)
        val listDrinks = findViewById<ListView>(R.id.list_drinks)
        listDrinks.adapter = arrayAdapter

        val itemClickListener = AdapterView.OnItemClickListener {
            listDrinks: AdapterView<*>, itemView: View, position: Int, id: Long ->
            val intent = Intent(this, DrinkActivity::class.java)
            intent.putExtra(DrinkActivity.EXTRA_DRINKID, id.toInt())
            startActivity(intent)
        }

        listDrinks.onItemClickListener = itemClickListener
    }
}