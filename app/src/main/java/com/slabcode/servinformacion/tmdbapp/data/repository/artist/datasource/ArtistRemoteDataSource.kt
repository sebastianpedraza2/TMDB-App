package com.slabcode.servinformacion.tmdbapp.data.repository.artist.datasource

import com.slabcode.servinformacion.tmdbapp.data.model.artist.Artist
import com.slabcode.servinformacion.tmdbapp.data.model.artist.ArtistsList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtistsFromApi(): Response<ArtistsList>
}