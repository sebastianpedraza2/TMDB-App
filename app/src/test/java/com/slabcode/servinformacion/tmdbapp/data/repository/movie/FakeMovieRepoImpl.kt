package com.slabcode.servinformacion.tmdbapp.data.repository.movie

import com.slabcode.servinformacion.tmdbapp.data.model.movie.Movie
import com.slabcode.servinformacion.tmdbapp.domain.repository.MovieRepo

class FakeMovieRepoImpl : MovieRepo {
    private var movies = mutableListOf<Movie>()

    init {
        movies.addAll(
            listOf(
                Movie(1, "overview1", "path1", "releaseDate1", "title1"),
                Movie(2, "overview2", "path2", "releaseDate2", "title2"),
                Movie(3, "overview2", "path2", "releaseDate2", "title2")
            )

        )
    }


    override suspend fun getMovies(): List<Movie>? {
        return movies
    }

    override suspend fun updateMovies(): List<Movie>? {
        movies.clear()
        movies.addAll(
            listOf(
                Movie(1, "overview4", "path4", "releaseDate4", "title4"),
                Movie(2, "overview5", "path5", "releaseDate5", "title5"),
                Movie(3, "overview6", "path6", "releaseDate6", "title6")
            )
        )
        return movies

    }
}