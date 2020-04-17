package com.example.platzistore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewText.text = "Texto desde Kotlin"

        toast("Este es un texto desde Anko")

        viewText.setOnClickListener { view -> newActivity(view) }
    }

    private fun newActivity(view: View){
        startActivity<detailactivity>("TextoA" to "Hola desde intent Anko")
    }
}
