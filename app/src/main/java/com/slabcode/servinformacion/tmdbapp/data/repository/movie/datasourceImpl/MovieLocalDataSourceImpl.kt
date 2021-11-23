package com.slabcode.servinformacion.tmdbapp.data.repository.movie.datasourceImpl

import com.slabcode.servinformacion.tmdbapp.data.db.MovieDao
import com.slabcode.servinformacion.tmdbapp.data.model.movie.Movie
import com.slabcode.servinformacion.tmdbapp.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao) : MovieLocalDataSource {

    /**
     * Dao uses a background threat to insert so we don't need to explicitly do it
     */
    override suspend fun getMoviesFromDB(): List<Movie> = movieDao.getMovies()

    /**
     * with other operations we have to use coroutines
     */

    override suspend fun saveMovieToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}