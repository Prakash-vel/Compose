package com.example.compose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MasterViewModel: ViewModel() {

    private val _data=MutableLiveData<String>()
    val data:LiveData<String>
       get()=_data
    init{
        _data.value="search"
    }
    fun search(query: String){
        _data.value=query
    }

    private val _searchState=MutableLiveData<Boolean>()
    val searchState:LiveData<Boolean>
        get()=_searchState

    fun searchEnable(state: Boolean){
        _searchState.value=state
    }
}