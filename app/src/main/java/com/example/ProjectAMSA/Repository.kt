package com.example.ProjectAMSA

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Response

class Repository {

    companion object{

        fun getAllPlace(): LiveData<List<Place>> {
            val stations= MutableLiveData<List<Place>>()
            val client=RetrofitClient()
            val station = client.getService().getStation()



            station.enqueue(object: retrofit2.Callback<List<Place>> {
                override fun onFailure(call: Call<List<Place>>, t: Throwable) {
                    //Toast.makeText(contex,"Nie dziala ${t.message}", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<List<Place>>, response: Response<List<Place>>) {
                    // Toast.makeText(baseContext, "Dziala", Toast.LENGTH_SHORT).show()


                    if(response.isSuccessful) {
                        stations.value =response.body()!!

                    }
                }
            }
            )
            return stations
        }

    }

}