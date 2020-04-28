package com.example.ProjectAMSA

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalis.*

class detalisActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalis)

        val stadionName:String=intent.getStringExtra("SatationName")
        val cityname:String=intent.getStringExtra("CityName")
        val communeName:String=intent.getStringExtra("CommuneName")
        val districtName:String=intent.getStringExtra("DistrictName")
        val provinceName:String=intent.getStringExtra("ProvinceName")
        val addressStreet:String=intent.getStringExtra("AddressStreet")
        val lon:String=intent.getStringExtra("gegrLon")
        val lat:String=intent.getStringExtra("gegrLat")

        station_name.text= "Stacja: $stadionName"
        city_name.text="Miasto: $cityname"
        comune_name.text="Gmina $communeName"
        district_name.text="Powiat: $districtName"
        province_name.text="Województwo: $provinceName"
        address_street.text="Adres: $addressStreet "
        text_Lat.text="Szerokość: $lat"
        text_Lon.text="Długość: $lon"

        cancle.setOnClickListener {
            finish()
        }
    }
}
