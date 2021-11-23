package com.slabcode.servinformacion.tmdbapp.data.repository.artist

import android.util.Log
import com.slabcode.servinformacion.tmdbapp.data.model.artist.Artist
import com.slabcode.servinformacion.tmdbapp.data.repository.artist.datasource.ArtistCacheDataSource
import com.slabcode.servinformacion.tmdbapp.data.repository.artist.datasource.ArtistLocalDataSource
import com.slabcode.servinformacion.tmdbapp.data.repository.artist.datasource.ArtistRemoteDataSource
import com.slabcode.servinformacion.tmdbapp.domain.repository.ArtistRepo
import java.lang.Exception

class ArtistRepoImpl(
    private val artistCacheDataSource: ArtistCacheDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistRemoteDataSource: ArtistRemoteDataSource
) : ArtistRepo {
    override suspend fun getArtists(): List<Artist>? = getArtistFromCache()

    override suspend fun updateArtists(): List<Artist>? {
        val artistsList = getArtistFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(artistsList)
        artistCacheDataSource.saveArtistsToCache(artistsList)
        return artistsList
    }

    suspend fun getArtistFromApi(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDataSource.getArtistsFromApi()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }

        } catch (error: Exception) {
            Log.i("getArtistFromApi", error.message.toString())
        }
        return artistList

    }

    suspend fun getArtistFromDb(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistsFromDB()

        } catch (error: Exception) {
            Log.i("getArtistFromApi", error.message.toString())
        }
        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistFromApi()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }
        return artistList

    }

    suspend fun getArtistFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistsFromCache()

        } catch (error: Exception) {
            Log.i("getArtistFromApi", error.message.toString())
        }
        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistFromDb()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList

    }
}