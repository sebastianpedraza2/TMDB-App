package com.slabcode.servinformacion.tmdbapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.slabcode.servinformacion.tmdbapp.data.model.artist.Artist


@Dao
interface ArtistDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(artists: List<Artist>)


    @Query("DELETE FROM popular_artists")
    suspend fun deleteArtists()


    @Query("SELECT * FROM popular_artists")
    suspend fun getAllArtists(): List<Artist>
}