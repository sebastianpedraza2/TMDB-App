package com.slabcode.servinformacion.tmdbapp.domain.usecase

import com.slabcode.servinformacion.tmdbapp.data.model.artist.Artist
import com.slabcode.servinformacion.tmdbapp.domain.repository.ArtistRepo

class GetArtistsUseCase(private val artistRepo: ArtistRepo) {

    suspend fun execute(): List<Artist>? = artistRepo.getArtists()
}