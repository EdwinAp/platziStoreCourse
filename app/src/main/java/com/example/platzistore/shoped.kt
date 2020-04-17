package com.example.platzistore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.platzistore.sqlite.DBOpenHelper
import kotlinx.android.synthetic.main.activity_shoped.*
import org.jetbrains.anko.db.select

class shoped : AppCompatActivity() {

    private var items = arrayListOf<ItemListPogo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoped)

        rclViewLandingSecond.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    /*
        (1..4).map {
            items.add(ItemListPogo("Titulo ${it}", "Descripcion $it", (it*12.1)))
        }*/


    }

    override fun onResume() {
        super.onResume()
        val db = DBOpenHelper.getInstance(this)
        db?.use {
            select("productos").exec {

                this.moveToFirst()
                do {
                    items.add(ItemListPogo("${this.getString(1)}", "${this.getString(2)}", this.getString(3).toDouble()))
                } while (this.moveToNext())
            }
        }
        rclViewLandingSecond.adapter = AdaptadorCarrito(items)
    }
}
