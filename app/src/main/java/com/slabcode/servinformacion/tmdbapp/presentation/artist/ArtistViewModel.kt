package com.slabcode.servinformacion.tmdbapp.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.slabcode.servinformacion.tmdbapp.domain.usecase.GetArtistsUseCase
import com.slabcode.servinformacion.tmdbapp.domain.usecase.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModel() {

    fun getArtist() = liveData {
        val artists = getArtistsUseCase.execute()
        emit(artists)
    }

    fun updateArtist() = liveData {
        val artists = updateArtistsUseCase.execute()
        emit(artists)
    }

}