package com.example.uurloon

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.uurloon.userData.User

val DATABASENAME = "accounts"
val TABLENAME = "Users"
val COL_NAME = "name"
val COL_EMAIL = "email"
val COL_PASSWORD = "password"
class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASENAME, null,
    1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLENAME + " (" + COL_EMAIL + " VARCHAR(256)," + COL_NAME + " VARCHAR(256)," + COL_PASSWORD + " TEXT)"
        db?.execSQL(createTable)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //onCreate(db);
    }
    fun insertData(user: User) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_NAME, user.name)
        contentValues.put(COL_EMAIL, user.email)
        contentValues.put(COL_PASSWORD, user.password)
        val result = database.insert(TABLENAME, null, contentValues)
        if (result == (0).toLong()) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        }
    }
    @SuppressLint("Recycle")
    fun readData(): MutableList<User> {
        val list: MutableList<User> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLENAME"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                val user = User(name = String(), email = String(), password = String())
                user.name = result.getString(result.getColumnIndex(COL_NAME)).toString()
                user.email = result.getString(result.getColumnIndex(COL_EMAIL)).toString()
                user.password = result.getString(result.getColumnIndex(COL_PASSWORD)).toString()
                list.add(user)
            }
            while (result.moveToNext())
        }
        return list
    }
}
