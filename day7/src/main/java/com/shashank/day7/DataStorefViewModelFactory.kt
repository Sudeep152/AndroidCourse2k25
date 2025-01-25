package com.shashank.day7

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DataStorefViewModelFactory(private val dataStoreManager: DataStoreManager) :ViewModelProvider.Factory{
     override fun <T: ViewModel> create(modelClass: Class<T>):T {
         return DataStorePrefViewModel(dataStoreManager) as T
     }
}