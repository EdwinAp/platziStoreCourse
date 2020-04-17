package com.example.platzistore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.platzistore.sqlite.DBOpenHelper
import kotlinx.android.synthetic.main.activity_detalleproducto.*
import kotlinx.android.synthetic.main.contenido_descrip.*
import kotlinx.android.synthetic.main.item_landing.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.startActivity

class detalleproducto : AppCompatActivity() {

    private var db : DBOpenHelper? = null
    private var nom : String = ""
    private var des : String = ""
    private var pri : Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalleproducto)

        db = DBOpenHelper.getInstance(this)

        intent?.extras?.let {
            nom = it.getString("titulo")
            des = it.getString("desc")
            pri = it.getDouble("price")
            txtViewTitulo.text = it.getString("titulo")
            txtViewDescrip.text = it.getString("desc")
            txtViewPrecio.text = "$ ${String.format("%.2f", it.getDouble("price"))}"
            buyItem.setOnClickListener { view -> onClickBuy(view) }

        }
    }

    private fun onClickBuy(view : View){
        db?.use {
            val nombre = "nombre" to nom
            val descip = "desc" to des
            val price = "precio" to pri
            insert("productos", nombre, descip, price)

        }
        startActivity<shoped>()

    }
}
