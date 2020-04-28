package com.example.ProjectAMSA

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class StationsViewModel: ViewModel() {

    private var _allStations=Repository.getAllPlace()

    fun updateStations(){
        _allStations=Repository.getAllPlace()
    }

    val allStations: LiveData<List<Place>>
    get() {

           return _allStations
    }
}