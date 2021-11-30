package com.slabcode.servinformacion.tmdbapp.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.slabcode.servinformacion.tmdbapp.data.model.movie.Movie
import com.slabcode.servinformacion.tmdbapp.data.repository.movie.FakeMovieRepoImpl
import com.slabcode.servinformacion.tmdbapp.domain.usecase.GetMoviesUserCase
import com.slabcode.servinformacion.tmdbapp.domain.usecase.UpdateMoviesUseCase
import com.slabcode.servinformacion.tmdbapp.getOrAwaitValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var movieViewModel: MovieViewModel

    @Before
    fun setUp() {
        /**
         * Se crea un fake en vez de un mock para simular la implementacion de la interfaz movie repo que es una dependencia de los use cases
         */
        val fakeMovieRepoImpl = FakeMovieRepoImpl()
        val getMoviesUserCase = GetMoviesUserCase(fakeMovieRepoImpl)
        val updateMoviesUseCase = UpdateMoviesUseCase(fakeMovieRepoImpl)
        movieViewModel = MovieViewModel(getMoviesUserCase, updateMoviesUseCase)
    }

    @Test
    fun getMovies_returnsCurrentMovies() {
        val expectedMovies = listOf(
            Movie(1, "overview1", "path1", "releaseDate1", "title1"),
            Movie(2, "overview2", "path2", "releaseDate2", "title2"),
            Movie(3, "overview2", "path2", "releaseDate2", "title2")
        )

        /**
         * Se usa livedatatestutil para sacar el elemento del livedata
         */
        val currentMovies = movieViewModel.getMovies().getOrAwaitValue()
        assertThat(currentMovies).isEqualTo(expectedMovies)
    }

    @Test
    fun updateMovies_returnsUpdatedMovies() {
        val expectedMovies = listOf(
            Movie(1, "overview4", "path4", "releaseDate4", "title4"),
            Movie(2, "overview5", "path5", "releaseDate5", "title5"),
            Movie(3, "overview6", "path6", "releaseDate6", "title6")
        )

        /**
         * Se usa livedatatestutil para sacar el elemento del livedata
         */
        val currentMovies = movieViewModel.updateMovies().getOrAwaitValue()
        assertThat(currentMovies).isEqualTo(expectedMovies)
    }
}