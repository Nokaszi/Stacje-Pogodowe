package com.example.ProjectAMSA

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{

        val API_ADRESS="http://api.gios.gov.pl/pjp-api/rest/"

    }

    fun getService():RestAPI{

        val retrofit=Retrofit.Builder()
            .baseUrl(API_ADRESS)
            //.addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(RestAPI::class.java)
    }


}