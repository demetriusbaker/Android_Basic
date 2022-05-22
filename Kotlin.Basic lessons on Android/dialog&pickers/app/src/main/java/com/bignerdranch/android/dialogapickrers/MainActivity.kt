package com.bignerdranch.android.dialogapickrers

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var buttonDate: Button
    private lateinit var buttonTime: Button
    private lateinit var editTextDate: EditText
    private lateinit var editTextTime: EditText
    private var myYear = 0
    private var myMonth = 0
    private var myDay = 0
    private var myHour = 0
    private var myMinute = 0

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val dialog = Dialog(this)
            dialog.setTitle("Title of dialog")
            dialog.setContentView(R.layout.dialog_view)

            val text = dialog.findViewById<TextView>(R.id.textView)
            text.text = "This is text!"

            dialog.show()
        }

        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            val media = MediaPlayer.create(this, R.raw.music)
            media.start()

            val alertBuilder = AlertDialog.Builder(this)
            alertBuilder.setTitle("Error!")
            alertBuilder.setIcon(R.drawable.ic_error)
            alertBuilder.setMessage("This error window was appeared!")
            alertBuilder.setCancelable(false)
            alertBuilder.setPositiveButton("Close"){ dialog, which ->
                dialog.cancel()
                media.stop()
            }
            alertBuilder.show()
        }

        buttonDate = findViewById(R.id.btn_date)
        buttonTime = findViewById(R.id.btn_time)
        editTextDate = findViewById(R.id.picked_date)
        editTextTime = findViewById(R.id.picked_time)

        buttonDate.setOnClickListener {
            val cal: Calendar = Calendar.getInstance()
            myYear = cal.get(Calendar.YEAR)
            myMonth = cal.get(Calendar.MONTH)
            myDay = cal.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this,
                { view, year, monthOfYear, dayOfMonth ->
                    val editTextDateParam =
                        dayOfMonth.toString() + "." + (monthOfYear + 1) + "." + year
                    editTextDate.setText(editTextDateParam)
                }, myYear, myMonth, myDay
            )
            datePickerDialog.show()
        }

        buttonTime.setOnClickListener {
            val cal: Calendar = Calendar.getInstance()
            myHour = cal.get(Calendar.HOUR_OF_DAY)
            myMinute = cal.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(this,
                { view, hourOfDay, minute ->
                    editTextTime.setText("$hourOfDay : $minute")
                }, myHour, myMinute, false
            )
            timePickerDialog.show()
        }
    }
}