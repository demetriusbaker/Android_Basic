package com.hfad.starbuzz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView

class TopLevelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_level)

        val itemClickListener = AdapterView.OnItemClickListener {
            adapterView: AdapterView<*>, itemView: View, position: Int, id: Long ->
            if (position == 0) {
                val intent = Intent(this, DrinkCategoryActivity::class.java)
                startActivity(intent)
            }
        }

        val listView = findViewById<ListView>(R.id.list_options)
        listView.onItemClickListener = itemClickListener
    }
}