package com.shashank.day13.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shashank.day13.remote.data.AnimeResponse
import com.shashank.day13.repository.TopAnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(private val topAnimeRepository: TopAnimeRepository) :
    ViewModel() {

    private val _animeList = MutableStateFlow<AnimeResponse>(AnimeResponse())
    val animeList: StateFlow<AnimeResponse> = _animeList


    init {
        getTopAnime()
    }

    private fun getTopAnime() {
        viewModelScope.launch {
            try {
                topAnimeRepository.getTopAnime().collect { response -> _animeList.value = response }
            } catch (e: Exception) {
                Log.e("AnimeViewModel", "Error fetching top anime", e)

            }
        }
    }
}