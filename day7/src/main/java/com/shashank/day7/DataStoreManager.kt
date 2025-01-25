package com.shashank.day7

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.pref by preferencesDataStore("user_pref")

class DataStoreManager(private val context: Context) {
    companion object{
        val USERNAME = stringPreferencesKey("username")
    }

    suspend fun saveUserName(name : String){
        context.pref.edit {
            it[USERNAME] = name
        }
    }
    val username : Flow<String> = context.pref.data.map {
        it[USERNAME] ?: ""
    }
}