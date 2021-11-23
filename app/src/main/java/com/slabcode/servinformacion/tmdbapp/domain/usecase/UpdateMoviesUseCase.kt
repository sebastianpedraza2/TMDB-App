package com.slabcode.servinformacion.tmdbapp.domain.usecase

import com.slabcode.servinformacion.tmdbapp.data.model.movie.Movie
import com.slabcode.servinformacion.tmdbapp.domain.repository.MovieRepo

class UpdateMoviesUseCase(private val movieRepo: MovieRepo) {
    suspend fun execute(): List<Movie>? = movieRepo.updateMovies()
}