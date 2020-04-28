package com.example.ProjectAMSA

import com.google.gson.annotations.SerializedName

class Place (
    @SerializedName("stationName")
    val stationName: String = "",
    @SerializedName("city")
    val city:City?=null,
    @SerializedName("id")
    val id: Int =-1,
    @SerializedName("addressStreet")
    val addressStreet:String="",
    @SerializedName("gegrLat")
    val gegrLat:String,
    @SerializedName("gegrLon")
    val gegrLon:String
)
class City(
    @SerializedName("id")
    val id:Int=-1,
    @SerializedName("name")
    val name: String="",
    @SerializedName("commune")
    val commune: Commune?=null
)
{
}
class Commune(
    @SerializedName("communeName")
    val communeName:String="",
    @SerializedName("districtName")
    val districtName:String="",
    @SerializedName("provinceName")
    val provinceName:String=""
)