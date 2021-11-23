package com.slabcode.servinformacion.tmdbapp.data.repository.artist.datasourceImpl

import com.slabcode.servinformacion.tmdbapp.data.model.artist.Artist
import com.slabcode.servinformacion.tmdbapp.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {

    private var cachedArtists = ArrayList<Artist>()
    override suspend fun getArtistsFromCache(): List<Artist> = cachedArtists

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        cachedArtists.clear()
        cachedArtists = ArrayList(artists)
    }
}