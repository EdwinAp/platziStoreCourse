package com.example.platzistore

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class AdaptadorCarrito (val data :List<ItemListPogo>) : RecyclerView.Adapter<AdaptadorCarrito.Holder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder = Holder(ItemList().createView(AnkoContext.Companion.create(p0.context,this, false)))

    override fun onBindViewHolder(p0: Holder, p1: Int) {
        p0.bindView(data[p1])
    }

    override fun getItemCount(): Int = data.size

    class Holder(view:View):RecyclerView.ViewHolder(view){
        val textViewTitle by lazy {
            itemView.find<TextView>(R.id.textoDeTitulo)
        }
        val textViewDesc by lazy {
            itemView.find<TextView>(R.id.textoDeDescrip)
        }
        val textViewPrecio by lazy {
            itemView.find<TextView>(R.id.textoDePrecio)
        }
        fun bindView(itemListPogo: ItemListPogo){
            with(itemListPogo){
                textViewTitle.text = titulo
                textViewDesc.text = desc
                textViewPrecio.text = "$ ${String.format("%.2f", precio)}"
            }
        }

    }
}