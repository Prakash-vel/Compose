package com.example.compose

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.compose.data.ContactData
import com.example.compose.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class AddingViewModel @Inject constructor(val repository: Repository):ViewModel() {
//    lateinit var repository: Repository
//    private val _data= MutableLiveData<ContactData>()
//    val data: LiveData<ContactData>
//        get()=_data
//    init{
//        _data.value= ContactData()
//    }
    val selectedData: LiveData<ContactData>
        get()=repository.selectedData

    private val _fName = MutableLiveData<String>()
    val fName: LiveData<String>
        get()=_fName
    private val _lName = MutableLiveData<String>()
    val lName: LiveData<String>
        get()=_lName
    private val _cCode = MutableLiveData<String>()
    val cCode: LiveData<String>
        get()=_cCode
    private val _pNum = MutableLiveData<String>()
    val pNum: LiveData<String>
        get()=_pNum
    private val _eMail = MutableLiveData<String>()
    val eMail: LiveData<String>
        get()=_eMail


    fun inputFN(name: String){
        _fName.value=name
//        _data.value!!.contactFirstName=name
    }
    fun inputLN(name: String){
        _lName.value=name
//        _data.value!!.contactLastName=name
    }
    fun inputCC(name: String){
        _cCode.value=name
//        _data.value!!.contactCountryCode=name
    }
    fun inputPN(name: String){
        _pNum.value=name
//        _data.value!!.contactNumber=name.toLong()
    }
    fun inputEM(name: String){
        _eMail.value=name
//        _data.value!!.contactMail=name
    }


    fun initData(id :Long){
        repository.getContactByID(id)
    }

    fun update(id: Long){
        val data=ContactData()
        _fName.value?.let { data.contactFirstName= it}
        _lName.value?.let { data.contactLastName= it}
        _cCode.value?.let { data.contactCountryCode= it}
        _pNum.value?.let { data.contactNumber= it.toLong()}
        _eMail.value?.let { data.contactMail= it}
        if(id==0L){
            repository.addContact(data)
        }else{
            repository.updateContact(data)
        }
    }
}