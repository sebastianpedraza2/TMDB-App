package com.slabcode.servinformacion.tmdbapp.presentation.di.core

import com.slabcode.servinformacion.tmdbapp.data.repository.artist.ArtistRepoImpl
import com.slabcode.servinformacion.tmdbapp.data.repository.artist.datasource.ArtistCacheDataSource
import com.slabcode.servinformacion.tmdbapp.data.repository.artist.datasource.ArtistLocalDataSource
import com.slabcode.servinformacion.tmdbapp.data.repository.artist.datasource.ArtistRemoteDataSource
import com.slabcode.servinformacion.tmdbapp.data.repository.movie.MovieRepoImpl
import com.slabcode.servinformacion.tmdbapp.data.repository.movie.datasource.MovieCacheDataSource
import com.slabcode.servinformacion.tmdbapp.data.repository.movie.datasource.MovieLocalDataSource
import com.slabcode.servinformacion.tmdbapp.data.repository.movie.datasource.MovieRemoteDataSource
import com.slabcode.servinformacion.tmdbapp.data.repository.tvshow.TvShowRepoImpl
import com.slabcode.servinformacion.tmdbapp.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.slabcode.servinformacion.tmdbapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.slabcode.servinformacion.tmdbapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.slabcode.servinformacion.tmdbapp.domain.repository.ArtistRepo
import com.slabcode.servinformacion.tmdbapp.domain.repository.MovieRepo
import com.slabcode.servinformacion.tmdbapp.domain.repository.TvShowRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    /**
     * all the data sources are provided in the other modules
     */
    @Singleton
    @Provides
    fun provideMovieRepo(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepo {
        return MovieRepoImpl(movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideTvShowRepo(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepo {
        return TvShowRepoImpl(tvShowLocalDataSource, tvShowRemoteDataSource, tvShowCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideArtistRepo(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepo {
        return ArtistRepoImpl(artistCacheDataSource, artistLocalDataSource, artistRemoteDataSource)
    }
}