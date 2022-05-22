package com.bignerdranch.android.temperatureconverter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.bignerdranch.android.temperatureconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val etc = binding.editTextNumberSignedC
        val etf = binding.editTextNumberSignedF

        etc.addTextChangedListener {
            binding.textViewF.text =
                "${String.format("%.2f", convertCelsiusToFahrenheits(etc.text.toString()))} °F"
        }
        
        etf.addTextChangedListener {
            binding.textViewC.text =
                "${String.format("%.2f", convertFahrenheitsToCelsius(etf.text.toString()))} °C"
        }
    }
    
    private fun convertFahrenheitsToCelsius(number: String): Double =
        try {
                (number.toDouble() - 32.0) * 5.0 / 9.0
        } catch (e: NumberFormatException) { 0.0 }

    private fun convertCelsiusToFahrenheits(number: String): Double =
        try {
            number.toDouble() * 9.0 / 5.0 + 32
        } catch (e: NumberFormatException) { 0.0 }
}