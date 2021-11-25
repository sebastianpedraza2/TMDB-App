package com.slabcode.servinformacion.tmdbapp.presentation.di.tv

import com.slabcode.servinformacion.tmdbapp.domain.usecase.*
import com.slabcode.servinformacion.tmdbapp.presentation.artist.ArtistViewModelFactory
import com.slabcode.servinformacion.tmdbapp.presentation.movie.MovieViewModelFactory
import com.slabcode.servinformacion.tmdbapp.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    /**
     * We have to create a scope instead of using singleton for the viewmodel
     */
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}