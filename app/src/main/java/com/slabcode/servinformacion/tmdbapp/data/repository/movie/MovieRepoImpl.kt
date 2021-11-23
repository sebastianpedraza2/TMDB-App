package com.slabcode.servinformacion.tmdbapp.data.repository.movie

import android.util.Log
import com.slabcode.servinformacion.tmdbapp.data.model.movie.Movie
import com.slabcode.servinformacion.tmdbapp.data.repository.movie.datasource.MovieCacheDataSource
import com.slabcode.servinformacion.tmdbapp.data.repository.movie.datasource.MovieLocalDataSource
import com.slabcode.servinformacion.tmdbapp.data.repository.movie.datasource.MovieRemoteDataSource
import com.slabcode.servinformacion.tmdbapp.domain.repository.MovieRepo
import java.lang.Exception

class MovieRepoImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepo {

    /**
     * First it will get the movies from cache, if not available it will take them from db, if not available it will call the api
     */
    override suspend fun getMovies(): List<Movie>? = getMoviesFromCache()

    /**
     * To update just call the api and save the new list to the db and cache
     */
    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMovieToDB(newListOfMovies)
        movieCacheDataSource.saveMovieToCache(newListOfMovies)
        return newListOfMovies
    }


    suspend fun getMoviesFromApi(): List<Movie> {
        lateinit var movieList: List<Movie>
        /**
         * Desencapsulando la response
         */
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }

        } catch (error: Exception) {
            Log.i("getMoviesFromApi", error.message.toString())
        }
        return movieList

    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieLocalDataSource.getMoviesFromDB()

        } catch (error: Exception) {
            Log.i("getMoviesFromApi", error.message.toString())
        }
        /**
         * Si la lista en db no esta vacia entonces return it, else haga un llamado al api, guardela en la db y return
         */
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMovieToDB(movieList)
        }
        return movieList

    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieCacheDataSource.getMoviesFromCache()

        } catch (error: Exception) {
            Log.i("getMoviesFromApi", error.message.toString())
        }
        /**
         * Si la lista en cache no esta vacia entonces return it, else traiga la de la db, guardela y return
         */
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMovieToCache(movieList)
        }
        return movieList

    }
}