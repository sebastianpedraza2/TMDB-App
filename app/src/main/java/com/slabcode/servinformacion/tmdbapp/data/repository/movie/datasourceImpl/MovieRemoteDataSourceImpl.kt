package com.slabcode.servinformacion.tmdbapp.data.repository.movie.datasourceImpl

import com.slabcode.servinformacion.tmdbapp.data.api.TMDBService
import com.slabcode.servinformacion.tmdbapp.data.model.movie.MovieList
import com.slabcode.servinformacion.tmdbapp.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response


/**
 * This class gets as a parameter an instance of the retrofit api service
 */
class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}