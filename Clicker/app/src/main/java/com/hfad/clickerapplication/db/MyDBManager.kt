package com.hfad.clickerapplication.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class MyDBManager(context: Context) {
    private val myDBHelper = MyDBHelper(context)
    private var db: SQLiteDatabase? = null

    fun openDB(){
        db = myDBHelper.writableDatabase
    }

    fun insertToDB(number: Int){
        val values = ContentValues().apply {
            put(MyDBNameClass.COLUMN_NUMBER, number)
        }
        db?.insert(MyDBNameClass.TABLE_NAME, null, values)
    }

    fun readDBData(): ArrayList<Int>{
        val dataList = ArrayList<Int>()

        val cursor = db?.query(MyDBNameClass.TABLE_NAME, null,
                null, null, null, null, null)
        with(cursor){
            while (this?.moveToNext()!!){
                val dataText = cursor?.getInt(cursor.
                getColumnIndex(MyDBNameClass.COLUMN_NUMBER))
                dataList.add(dataText!!)
            }
        }
        cursor?.close()

        return dataList
    }

    fun closeDB() {
        myDBHelper.close()
    }
}