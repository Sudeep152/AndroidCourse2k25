package com.shashank.day7.sharedPref

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedPrefViewModel(private val sharedPref : SharedPreferences)  : ViewModel(){

    private val _userName:MutableLiveData<String> = MutableLiveData("")
    val username : LiveData<String> get() = _userName

    fun saveUserName(name : String){
        sharedPref.edit().putString("name",name).apply()
    }

    fun getUserName() : String?{
       // _userName.value = sharedPref.getString("name",null)
        return sharedPref.getString("name",null)
    }
}