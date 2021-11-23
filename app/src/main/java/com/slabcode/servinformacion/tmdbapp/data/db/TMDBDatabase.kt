package com.slabcode.servinformacion.tmdbapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.slabcode.servinformacion.tmdbapp.data.model.artist.Artist
import com.slabcode.servinformacion.tmdbapp.data.model.movie.Movie
import com.slabcode.servinformacion.tmdbapp.data.model.tv.TvShow


@Database(
    entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun tvShowsDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}