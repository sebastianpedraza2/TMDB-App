package com.slabcode.servinformacion.tmdbapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.slabcode.servinformacion.tmdbapp.data.model.tv.TvShow


@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShows: List<TvShow>)

    @Query("DELETE FROM popular_shows")
    suspend fun deleteTvShows()

    @Query("SELECT * FROM popular_shows")
    suspend fun getAllTvShows(): List<TvShow>
}