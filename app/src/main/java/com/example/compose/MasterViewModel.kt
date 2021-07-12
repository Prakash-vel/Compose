package com.example.compose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.compose.data.ContactData
import com.example.compose.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MasterViewModel @Inject constructor(val repository: Repository): ViewModel() {

//    lateinit var repository: Repository
    val data: MutableLiveData<List<ContactData>>
       get()=repository.resultData

    fun search(query: String){
        _query.value=query
        repository.getContact(query)
    }

    private val _query=MutableLiveData<String>()
    val query:LiveData<String>
        get()=_query



    private val _searchState=MutableLiveData<Boolean>()
    val searchState:LiveData<Boolean>
        get()=_searchState

    fun searchEnable(state: Boolean){
        _searchState.value=state
    }
}