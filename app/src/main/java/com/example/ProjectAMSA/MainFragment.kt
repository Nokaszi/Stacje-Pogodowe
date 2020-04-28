package com.example.ProjectAMSA

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment:Fragment() {
    lateinit var stations:List<Place>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        stations= mutableListOf<Place>()
        stationsViewModel= ViewModelProviders.of(this).get(StationsViewModel::class.java)

    }

    companion object{

        fun newInstance():MainFragment = MainFragment()

    }
   lateinit var  stationsViewModel:StationsViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        return inflater.inflate(R.layout.main_fragment,container,false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)
        list_of_station.layoutManager= LinearLayoutManager(activity, RecyclerView.VERTICAL,false)
        stationsViewModel.allStations.observe(this, Observer {
            stations=it
            list_of_station.adapter=stationsAdapter(it,requireContext())
        })
    }
}