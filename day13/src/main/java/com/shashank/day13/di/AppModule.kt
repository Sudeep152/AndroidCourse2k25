package com.shashank.day13.di

import com.shashank.day13.remote.api.AnimeApi
import com.shashank.day13.repository.TopAnimeRepository
import com.shashank.day13.repository.TopAnimeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideRepository(api: AnimeApi): TopAnimeRepository {
        return TopAnimeRepositoryImpl(api)
    }
}