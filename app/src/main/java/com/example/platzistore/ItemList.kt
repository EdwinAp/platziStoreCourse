package com.example.platzistore

import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class ItemList : AnkoComponent<AdaptadorCarrito>{
    override fun createView(ui: AnkoContext<AdaptadorCarrito>): View = with(ui){
        verticalLayout {
            lparams(width = matchParent, height = wrapContent)
            cardView {
                linearLayout {
                    padding = dip(10)
                    orientation = LinearLayout.HORIZONTAL
                    imageView(R.drawable.apache){
                        id = R.id.imageItem
                        scaleType  = ImageView.ScaleType.CENTER_CROP
                    }.lparams(width = dip(0), height = dip(100), weight = 1f)
                    linearLayout{
                        padding = dip(5)
                        orientation = LinearLayout.VERTICAL
                        textView("Titulo"){
                            id = R.id.textoDeTitulo
                            setTextAppearance(ctx, android.R.style.TextAppearance_Material_Large)
                        }
                        textView("Descripcion"){
                            id = R.id.textoDeDescrip
                            setTextAppearance(ctx, android.R.style.TextAppearance_Material_Small)
                        }
                        textView("Precio"){
                            id = R.id.textoDePrecio
                            setTextAppearance(ctx, android.R.style.TextAppearance_Material_Medium)

                        }.lparams{
                            topMargin = dip(5)
                            gravity = Gravity.END
                        }
                    }.lparams(width = dip(0), height = wrapContent, weight = 2f)
                }.lparams(){
                    topMargin = dip(10)
                }
            }
        }
    }

}