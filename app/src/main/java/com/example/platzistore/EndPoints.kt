package com.example.platzistore

import com.example.platzistore.pojorestrofit.ResponseProductos
import retrofit2.Call
import retrofit2.http.GET

interface EndPoints{

    @GET("list")
    fun getList(): Call<ResponseProductos>
}