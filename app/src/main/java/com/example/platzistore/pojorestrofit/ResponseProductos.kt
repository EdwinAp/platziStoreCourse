package com.example.platzistore.pojorestrofit

//import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

//@Generated("com.robohorse.robopojogenerator")
data class ResponseProductos(

	@field:SerializedName("statuscode")
	val statuscode: Int? = null,

	@field:SerializedName("payload")
	val payload: List<PayloadItem?>? = null
)