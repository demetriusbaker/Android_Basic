package com.example.fishermanhandbook

import android.content.res.TypedArray
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private var adapter: MyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val menu = findViewById<NavigationView>(R.id.navigation_view)
        menu.setNavigationItemSelectedListener (this)

        var list = ArrayList<ListItem>()
        list.addAll(fillArrays((resources.getStringArray(R.array.fish)),
                resources.getStringArray(R.array.fish_content),
                getImageId(R.array.fish_image_array)))

        val rcView = findViewById<RecyclerView>(R.id.rcView)
        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(list, this)
        rcView.adapter = adapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.id_fish -> {
                Toast.makeText(this, "fish", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArrays((resources.getStringArray(R.array.fish)),
                        resources.getStringArray(R.array.fish_content),
                        getImageId(R.array.fish_image_array)))
            }
            R.id.id_na -> {
                Toast.makeText(this, "na", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArrays((resources.getStringArray(R.array.na)),
                        resources.getStringArray(R.array.na_content),
                        getImageId(R.array.na_image_array)))
            }
            R.id.id_sna -> Toast.makeText(this, "sna", Toast.LENGTH_SHORT).show()
            R.id.id_story -> Toast.makeText(this, "story", Toast.LENGTH_SHORT).show()
        }
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }

    private fun fillArrays(title: Array<String>, content: Array<String>, image: IntArray): List<ListItem>{
        var listItemArray = ArrayList<ListItem>()

        for (i in title.indices)
            listItemArray.add(ListItem(image[i], title[i], content[i]))

        return listItemArray
    }

    private fun getImageId(imageArrayId: Int): IntArray {
        var tArray: TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)

        for (i in ids.indices)
            ids[i] = tArray.getResourceId(i, 0)

        tArray.recycle()

        return ids
    }
}