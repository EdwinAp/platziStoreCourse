package com.example.platzistore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.example.platzistore.pojorestrofit.PayloadItem
import com.example.platzistore.pojorestrofit.ResponseProductos
import kotlinx.android.synthetic.main.activity_detailactivity.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class detailactivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailactivity)
/*
        rclViewLanding.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val items = arrayListOf<ItemListPogo>()

        (0..20).map {
            items.add(ItemListPogo("Titulo ${it}", "Descripcion $it", (it*12.1)))
        }

        rclViewLanding.adapter = AdaptadorCarrito(items)*/


        rclViewLanding.layoutManager = GridLayoutManager(this, 2) //as RecyclerView.LayoutManager?

        val retrofit = Retrofit.Builder() .baseUrl("http://10.0.2.2:4000/").addConverterFactory(GsonConverterFactory.create()).build()
                        //

        // 10.0.2.2
        // 10.0.1.2

        val endpoint = retrofit.create(EndPoints::class.java)

        val call = endpoint.getList()

        call.enqueue(object : Callback<ResponseProductos> {
            override fun onFailure(call: Call<ResponseProductos>, t: Throwable) {
                Log.e("Error Android: ", "$t")
            }

            override fun onResponse(call: Call<ResponseProductos>, response: Response<ResponseProductos>) {
                Log.e("Codigo respuesta: ", "${response.code()}")
                Log.e("Respuesta", "${response.body().toString()}")
                if (response?.code() == 200){
                    Log.e("Respuesta", "${response.body().toString()}")
                    fillRecyclerView(response.body()?.payload)

                    //response.body()?.payload?.get()
                } else {
                    Log.e("Repuesta != 200", "No se ha encontrado el recurso")
                }
            }

        })

        /*val itemsshop = (1..20).map {
            ItemLanding("Titulo $it","Descripcion $it", (it*340.234))
        }

        val adapter = AdapterLanding(itemsshop)

        rclViewLanding.adapter = adapter*/


    }

    private fun fillRecyclerView(payload: List<PayloadItem?>?) {
        val productos = payload?.map {
            it?.let { prod ->
                ItemLanding(prod.nombre, prod.desc, prod.price, prod.imgUrl)
            }

        }?.filter {
            it?.price?:0.00 > 100.00
        }

        rclViewLanding.adapter = AdapterLanding(productos)
    }
}
