package com.slabcode.servinformacion.tmdbapp.presentation.di.core

import com.slabcode.servinformacion.tmdbapp.data.api.TMDBService
import com.slabcode.servinformacion.tmdbapp.data.repository.artist.datasource.ArtistRemoteDataSource
import com.slabcode.servinformacion.tmdbapp.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.slabcode.servinformacion.tmdbapp.data.repository.movie.datasource.MovieRemoteDataSource
import com.slabcode.servinformacion.tmdbapp.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.slabcode.servinformacion.tmdbapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.slabcode.servinformacion.tmdbapp.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    /**
     * netmodule provides the tmdbservice & can be used here
     */
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }
}