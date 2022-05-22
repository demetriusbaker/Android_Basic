package com.example.kotlin_lesson_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productList = ArrayList<String>()
        productList.add("Beer")
        productList.add("Eggs")
        productList.add("Milk")
        productList.add("Cookies")
        productList.add("Bananas")
        productList.add("Bread")
        productList.add("Butter")
        productList.add("Water")
        productList.add("Meat")
        productList.add("Dog")
        productList.add("Chocolate")
        productList.add("Kiwi")
        productList.add("Juice")
        productList.add("Melon")
        productList.add("Candy")
        productList.add("Grapes")
        productList.add("Salt")
        productList.add("Protein")
        productList.add("Nuts")
        productList.add("Ice-cream")
        productList.removeAt(9)

        val listView = findViewById<ListView>(R.id.listView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, productList)
        listView.adapter = adapter
        listView.setOnItemClickListener{ _, _, position, _ ->
            Toast.makeText(this, "Pressed F item position and value:\n" +
                    "${position + 1} - ${productList[position]}", Toast.LENGTH_SHORT).show()
        }
    }
}