package com.slabcode.servinformacion.tmdbapp.presentation.di.core

import com.slabcode.servinformacion.tmdbapp.data.db.ArtistDao
import com.slabcode.servinformacion.tmdbapp.data.db.MovieDao
import com.slabcode.servinformacion.tmdbapp.data.db.TvShowDao
import com.slabcode.servinformacion.tmdbapp.data.repository.artist.datasource.ArtistLocalDataSource
import com.slabcode.servinformacion.tmdbapp.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.slabcode.servinformacion.tmdbapp.data.repository.movie.datasource.MovieLocalDataSource
import com.slabcode.servinformacion.tmdbapp.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.slabcode.servinformacion.tmdbapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.slabcode.servinformacion.tmdbapp.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}