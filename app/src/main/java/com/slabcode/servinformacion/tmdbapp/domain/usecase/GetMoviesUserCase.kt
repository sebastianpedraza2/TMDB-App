package com.slabcode.servinformacion.tmdbapp.domain.usecase

import com.slabcode.servinformacion.tmdbapp.data.model.movie.Movie
import com.slabcode.servinformacion.tmdbapp.domain.repository.MovieRepo

class GetMoviesUserCase(private val movieRepo: MovieRepo) {

    suspend fun execute(): List<Movie>? = movieRepo.getMovies()
}