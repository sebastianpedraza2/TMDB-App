package com.slabcode.servinformacion.tmdbapp.data.repository.artist.datasource

import com.slabcode.servinformacion.tmdbapp.data.model.artist.Artist
import com.slabcode.servinformacion.tmdbapp.data.model.tv.TvShow

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB(): List<Artist>
    suspend fun saveArtistsToDB(artists: List<Artist>)
    suspend fun clearAll()
}