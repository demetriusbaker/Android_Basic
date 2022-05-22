package com.hfad.clickerapplication.db

import android.provider.BaseColumns

object MyDBNameClass {
    const val TABLE_NAME = "my_table"
    const val COLUMN_NUMBER = "number"

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "MyLessonDB.db"

    const val CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
                    "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                    "$COLUMN_NUMBER TEXT)"

    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}






















