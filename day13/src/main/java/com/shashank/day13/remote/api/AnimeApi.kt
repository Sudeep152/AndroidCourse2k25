package com.shashank.day13.remote.api

import com.shashank.day13.remote.data.AnimeResponse
import retrofit2.http.GET

interface AnimeApi {
    @GET("top/anime")
    suspend fun getTopAnime(): AnimeResponse

}