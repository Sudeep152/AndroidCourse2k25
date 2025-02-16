package com.shashank.day13.repository

import com.shashank.day13.remote.data.AnimeResponse
import kotlinx.coroutines.flow.Flow

interface TopAnimeRepository {
    suspend fun getTopAnime(): Flow<AnimeResponse>
}