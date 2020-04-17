package com.example.platzistore.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class DBOpenHelper (context:Context) : ManagedSQLiteOpenHelper(context, "Platzi", null, 1){

    companion object {
        private var instance : DBOpenHelper? = null
        fun getInstance(context:Context) : DBOpenHelper?  =
            if (instance == null) {
                instance = DBOpenHelper(context)
                instance
            } else instance
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val id = "id" to INTEGER + PRIMARY_KEY
        val nombre = "nombre" to TEXT
        val desc = "desc" to TEXT
        val precio = "precio" to REAL
        db?.createTable("productos", true, id, nombre, desc, precio)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable("productos", true)
    }

    val Context.database:DBOpenHelper? get() = getInstance(applicationContext)

}