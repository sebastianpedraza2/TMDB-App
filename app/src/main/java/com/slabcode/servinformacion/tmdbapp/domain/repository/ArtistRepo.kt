package com.slabcode.servinformacion.tmdbapp.domain.repository

import com.slabcode.servinformacion.tmdbapp.data.model.artist.Artist

interface ArtistRepo {

    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}