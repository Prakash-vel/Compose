package com.example.compose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddingViewModel:ViewModel() {

    private val _data= MutableLiveData<String>()
    val data: LiveData<String>
        get()=_data
//    init{
//        _data.value="search"
//    }
    fun search(query: String){
        _data.value=query
    }
}