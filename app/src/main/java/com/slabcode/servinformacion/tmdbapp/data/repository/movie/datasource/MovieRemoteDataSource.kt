package com.slabcode.servinformacion.tmdbapp.data.repository.movie.datasource

import com.slabcode.servinformacion.tmdbapp.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies() : Response<MovieList>
}