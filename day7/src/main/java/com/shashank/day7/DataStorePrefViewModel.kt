package com.shashank.day7

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DataStorePrefViewModel(private val dataStoreManager: DataStoreManager) : ViewModel() {

    private val _userName:MutableLiveData<String> = MutableLiveData("")
    val username : LiveData<String> get() = _userName

    init {
        viewModelScope.launch {
            dataStoreManager.username.collect{
                _userName.value = it
            }
        }
    }

    fun saveUsrName(name : String){
        viewModelScope.launch {
            dataStoreManager.saveUserName(name)
        }
    }
}