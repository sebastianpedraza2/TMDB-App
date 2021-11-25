package com.slabcode.servinformacion.tmdbapp.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.slabcode.servinformacion.tmdbapp.data.db.ArtistDao
import com.slabcode.servinformacion.tmdbapp.data.db.MovieDao
import com.slabcode.servinformacion.tmdbapp.data.db.TMDBDatabase
import com.slabcode.servinformacion.tmdbapp.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    /**
     * In the app module theres a function that returns the context so it can we used as a parameter,
     * this fun return the db so it can we used as a parameter for other functions
     */

    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "moviesclient").build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TvShowDao {
        return tmdbDatabase.tvShowsDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao {
        return tmdbDatabase.artistDao()
    }
}