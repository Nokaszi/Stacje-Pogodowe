package com.example.ProjectAMSA

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class stationsAdapter(var stationList : List<Place>, val context:Context) : RecyclerView.Adapter<stationsAdapter.StationViewHolder>() {
    override fun getItemCount(): Int {
        stationList = stationList.sortedWith(compareBy({it.city?.name}))
        return stationList.size
    }

    override fun onBindViewHolder(holder: StationViewHolder, position: Int) {
        holder.textId.text=stationList[position].id.toString()
        holder.textStation.text=stationList[position].stationName

        holder.textStation.setOnClickListener {
            val intent=Intent(context, detalisActivity::class.java ).apply {
                putExtra("SatationName",stationList[position].stationName)
                putExtra("CityName",stationList[position].city?.name)
                putExtra("CommuneName",stationList[position].city?.commune?.communeName)
                putExtra("DistrictName",stationList[position].city?.commune?.districtName)
                putExtra("ProvinceName",stationList[position].city?.commune?.provinceName)
                putExtra("AddressStreet",stationList[position].addressStreet)
                putExtra("gegrLon",stationList[position].gegrLon)
                putExtra("gegrLat",stationList[position].gegrLat)
            }
            context.startActivity(intent)
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.station_layout,parent,false)
        return StationViewHolder(view)
    }
    class StationViewHolder(view: View) :RecyclerView.ViewHolder(view){
        val textId = view.findViewById<TextView>(R.id.textViewId)
        val textStation=view.findViewById<TextView>(R.id.textViewStation)
    }
}