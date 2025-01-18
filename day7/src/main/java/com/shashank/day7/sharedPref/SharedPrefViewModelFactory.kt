package com.shashank.day7.sharedPref

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SharedPrefViewModelFactory(private val sharedPreferences: SharedPreferences) :ViewModelProvider.Factory{
     override fun <T: ViewModel> create(modelClass: Class<T>):T {
         return SharedPrefViewModel(sharedPreferences) as T
     }
}