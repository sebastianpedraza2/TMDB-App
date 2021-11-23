package com.slabcode.servinformacion.tmdbapp.data.repository.movie.datasource

import com.slabcode.servinformacion.tmdbapp.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMovieToCache(movies: List<Movie>)
}