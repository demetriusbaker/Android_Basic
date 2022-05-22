package com.hfad.componentsexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private var text: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById(R.id.textView)
    }

    fun printText(view: View){
        val showText = findViewById<EditText>(R.id.editTextAutoCorrectAndCapSentence)
        text?.text = showText.text
    }

    fun printPhone(view: View) {
        val showText = findViewById<TextView>(R.id.editTextPhone)
        text?.text = if ((view as ToggleButton).isChecked) showText.text else ""
    }

    fun printPassword(view: View){
        val showText = findViewById<TextView>(R.id.editTextPassword)
        text?.text = if ((view as Switch).isChecked) showText.text else ""
    }

    fun showSimpleLogicalAlgebra(view: View){
        val checkBox: Array<CheckBox> = arrayOf(
                findViewById(R.id.checkBox),
                findViewById(R.id.checkBox2),
                findViewById(R.id.checkBox3)
        )
        val a = checkBox[0].isChecked
        val b = checkBox[1].isChecked
        val isAnd = checkBox[2].isChecked

        text?.text = if (isAnd) (a && b).toString() else (a || b).toString()
    }

    fun getRadioInstanceOnText(view: View){
        val radioGroup = findViewById<RadioGroup>(R.id.radio_group)
        val id = radioGroup.checkedRadioButtonId

        when(id){
            R.id.radioButton1 -> text?.text = "Motorcycle"
            R.id.radioButton2 -> text?.text = "Island"
        }
    }

    fun getMoreSpace(view: View){
        val intent = Intent(this, ComponentsExample2::class.java)
        startActivity(intent)
    }
}