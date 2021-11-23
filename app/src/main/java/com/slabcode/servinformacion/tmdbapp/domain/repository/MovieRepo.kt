package com.slabcode.servinformacion.tmdbapp.domain.repository

import com.slabcode.servinformacion.tmdbapp.data.model.movie.Movie

interface MovieRepo {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}