package com.example.platzistore

import android.app.Activity
import android.content.Intent
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_landing.view.*

class AdapterLanding(val data:List<ItemLanding?>?) : RecyclerView.Adapter<AdapterLanding.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): Holder = Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_landing, parent, false ))

    override fun onBindViewHolder(p0: Holder, p1: Int) {
        data?.let {
            p0.bindView(data[p1])
        }
    }

    override fun getItemCount(): Int = data?.size?: 0

    class Holder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bindView(itemLanding:ItemLanding?){
            itemLanding?.let {
                with(it){
                    itemView.tituloItem.text = title
                    itemView.detailItem.text = desc
                    itemView.priceItem.text = "$ ${String.format("%.2f", price)}"
                    Glide.with(itemView.context).load(url).into(itemView.cabezeraImagen)
                    itemView.setOnClickListener{
                        val intent = Intent(itemView.context, detalleproducto::class.java)
                        intent.putExtra("titulo", title)
                        intent.putExtra("desc", desc)
                        intent.putExtra("price", price)
                        val pairuno: Pair<View, String> = Pair.create(itemView.cabezeraImagen,  "transiciondeImagen")
                        val pairdos: Pair<View, String> = Pair.create(itemView.tituloItem,  "transiciondeltitulo")
                        val pairtes: Pair<View, String> = Pair.create(itemView.detailItem,  "transiciondeldesc")
                        val paircuatro: Pair<View, String> = Pair.create(itemView.priceItem,  "transiciondeprecio")
                        val options : ActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(itemView.context as Activity, pairuno, pairdos, pairtes, paircuatro)
                        itemView.context.startActivity(intent, options.toBundle())
                    }
                }
            }
        }

    }

}