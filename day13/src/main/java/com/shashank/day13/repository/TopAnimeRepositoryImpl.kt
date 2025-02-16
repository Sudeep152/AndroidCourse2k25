package com.shashank.day13.repository

import com.shashank.day13.remote.api.AnimeApi
import com.shashank.day13.remote.data.AnimeResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TopAnimeRepositoryImpl @Inject constructor (private val apiService: AnimeApi) : TopAnimeRepository {
    //    override suspend fun getTopAnime(): AnimeResponse {
//        val response  = apiService.getTopAnime()
//        return response
//    }
    override suspend fun getTopAnime(): Flow<AnimeResponse> {
       val response = apiService.getTopAnime()
        try {
            return flow { emit(response) }
        }catch (e: Exception){
            throw e
        }
    }
}