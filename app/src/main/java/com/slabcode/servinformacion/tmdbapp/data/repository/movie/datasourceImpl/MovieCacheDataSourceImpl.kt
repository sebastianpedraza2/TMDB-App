package com.slabcode.servinformacion.tmdbapp.data.repository.movie.datasourceImpl

import com.slabcode.servinformacion.tmdbapp.data.model.movie.Movie
import com.slabcode.servinformacion.tmdbapp.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {
    /**
     * basic cache, creating an instance of an array list of movies and save it the first time we consume the service
     */

    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> = movieList

    override suspend fun saveMovieToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}