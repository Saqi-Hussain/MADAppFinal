package com.example.madapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf

class dbHelp(context: Context) :
    SQLiteOpenHelper(context,DATABASE_NAME , null, 1) {
        companion object {
            private const val DATABASE_NAME = "LoginCredentialDatabase"
            private const val user = "LoginTable"
            private const val KEY_ID = "id"
            private const val KEY_NAME = "name"
            private const val KEY_EMAIL = "email"
            private const val KEY_DOB = "dateOfBirth"
            private const val KEY_PASSWORD = "password"
            private const val KEY_ADDRESS = "address"
        }

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE " + user + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_DOB + " TEXT," + KEY_PASSWORD + " TEXT," + KEY_ADDRESS + " TEXT,"
                + KEY_EMAIL + " TEXT" + ")")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("DROP TABLE IF EXISTS $user")
        onCreate(p0)
    }
    public fun insertValues(Name:String,
                            Email:String ,
                            DOB:String,
                            Password:String,
                            Address:String):Long{
        val p0 = this.writableDatabase
        val values = ContentValues()

        values.put("name" , Name)
        values.put("email" , Email)
        values.put("dateOfBirth" , DOB)
        values.put("password" , Password)
        values.put("address" , Address)

        val result = p0.insert(user,null, values)
        p0.close()
        return result
    }

    fun checkEmail(Email:String): Int {

        val p0 = this.writableDatabase
        var cursor: Cursor? = null
        cursor = p0.rawQuery("SELECT  * FROM $user where Email = ? " ,arrayOf(Email))
        print(cursor.count)
        return cursor.count
    }
    fun checkPass(Password: String): Int {

        val p0 = this.writableDatabase
        var cursor: Cursor? = null
        cursor = p0.rawQuery("SELECT  * FROM $user where password = ? " ,arrayOf(Password))
        print(cursor.count)
        return cursor.count
    }



}