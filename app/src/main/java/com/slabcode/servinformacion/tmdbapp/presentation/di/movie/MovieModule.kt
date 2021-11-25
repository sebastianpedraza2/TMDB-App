package com.slabcode.servinformacion.tmdbapp.presentation.di.movie

import com.slabcode.servinformacion.tmdbapp.domain.usecase.GetArtistsUseCase
import com.slabcode.servinformacion.tmdbapp.domain.usecase.GetMoviesUserCase
import com.slabcode.servinformacion.tmdbapp.domain.usecase.UpdateArtistsUseCase
import com.slabcode.servinformacion.tmdbapp.domain.usecase.UpdateMoviesUseCase
import com.slabcode.servinformacion.tmdbapp.presentation.artist.ArtistViewModelFactory
import com.slabcode.servinformacion.tmdbapp.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    /**
     * We have to create a scope instead of using singleton for the viewmodel
     */
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUserCase: GetMoviesUserCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUserCase, updateMoviesUseCase)
    }
}