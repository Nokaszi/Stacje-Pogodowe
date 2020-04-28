package com.example.ProjectAMSA

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.main_fragment.*
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {

   lateinit var allStation: MutableList<Place>
    fun repaceFragmrnt(fragment: Fragment)
    {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,fragment)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        allStation= mutableListOf<Place>()
        repaceFragmrnt(MainFragment.newInstance())


    }


    fun update()
    {
        list_of_station.layoutManager=LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        list_of_station.adapter=stationsAdapter(allStation,this)
    }

    fun getAllPlace(lista:MutableList<Place>) {

        val client=RetrofitClient()
        val station = client.getService().getStation()



        station.enqueue(object: retrofit2.Callback<List<Place>> {
            override fun onFailure(call: Call<List<Place>>, t: Throwable) {
                //Toast.makeText(baseContext,"Nie dziala ${t.message}",Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<Place>>, response: Response<List<Place>>) {
               // Toast.makeText(baseContext, "Dziala", Toast.LENGTH_SHORT).show()


              if(response.isSuccessful) {
                  response.body()?.forEach { p -> lista.add(p) }

                }
            }
        }
        )

    }
}
