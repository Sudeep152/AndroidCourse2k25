package com.shashank.day7

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private var _counter : MutableLiveData<Int> = MutableLiveData(0)
    val counter : LiveData<Int> get() = _counter

    fun incrementCounter(){
        _counter.value = _counter.value?.plus(1)
    }
}