package com.slabcode.servinformacion.tmdbapp.data.repository.artist.datasourceImpl

import com.slabcode.servinformacion.tmdbapp.data.api.TMDBService
import com.slabcode.servinformacion.tmdbapp.data.model.artist.ArtistsList
import com.slabcode.servinformacion.tmdbapp.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    ArtistRemoteDataSource {
    override suspend fun getArtistsFromApi(): Response<ArtistsList> =
        tmdbService.getPopularArtists(apiKey)
}