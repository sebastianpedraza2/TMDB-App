package com.slabcode.servinformacion.tmdbapp.presentation.di.artist

import com.slabcode.servinformacion.tmdbapp.domain.usecase.GetArtistsUseCase
import com.slabcode.servinformacion.tmdbapp.domain.usecase.UpdateArtistsUseCase
import com.slabcode.servinformacion.tmdbapp.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    /**
     * We have to create a scope instead of using singleton for the viewmodel
     */
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}