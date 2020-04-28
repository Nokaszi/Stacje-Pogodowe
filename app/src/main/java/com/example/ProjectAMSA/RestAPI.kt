package com.example.ProjectAMSA

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RestAPI  {
    @GET("station/findAll")
    fun getStation(): Call<List<Place>>
}