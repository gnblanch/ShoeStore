package com.example.shoestore

import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ShoeDetailViewModel : ViewModel() {


    private val _newName = MutableLiveData<String>()
    val newName: LiveData<String>
        get() = _newName

    private val _newCompany = MutableLiveData<String>()
    val newCompany: LiveData<String>
        get() = _newCompany

    private val _newSize = MutableLiveData<String>()
    val newSize: LiveData<String>
        get() = _newSize

    private val _newDescription = MutableLiveData<String>()
    val newDescription: LiveData<String>
        get() = _newDescription


    fun saveNewShoe(){
        Timber.i("In saveNewShoe fun ")
        val name = _newName.toString()
        val company = _newCompany.toString()
        val size = newSize.toString()
        val newDescription = _newDescription.toString()

    }


}