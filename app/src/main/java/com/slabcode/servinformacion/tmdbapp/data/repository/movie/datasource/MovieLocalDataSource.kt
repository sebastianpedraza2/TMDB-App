package com.slabcode.servinformacion.tmdbapp.data.repository.movie.datasource

import com.slabcode.servinformacion.tmdbapp.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMovieToDB(movies: List<Movie>)
    suspend fun clearAll()
}