package com.slabcode.servinformacion.tmdbapp.presentation.di.core

import com.slabcode.servinformacion.tmdbapp.domain.repository.ArtistRepo
import com.slabcode.servinformacion.tmdbapp.domain.repository.MovieRepo
import com.slabcode.servinformacion.tmdbapp.domain.repository.TvShowRepo
import com.slabcode.servinformacion.tmdbapp.domain.usecase.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetMoviesUseCase(movieRepo: MovieRepo): GetMoviesUserCase {
        return GetMoviesUserCase(movieRepo)
    }

    @Singleton
    @Provides
    fun provideUpdateMoviesUseCase(movieRepo: MovieRepo): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepo)
    }

    @Singleton
    @Provides
    fun provideGetTvShowUseCase(tvShowRepo: TvShowRepo): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowRepo)
    }

    @Singleton
    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepo: TvShowRepo): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowRepo)
    }

    @Singleton
    @Provides
    fun provideGetArtistUseCase(artistRepo: ArtistRepo): GetArtistsUseCase {
        return GetArtistsUseCase(artistRepo)
    }

    @Singleton
    @Provides
    fun provideUpdateArtistUseCase(artistRepo: ArtistRepo): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistRepo)
    }
}