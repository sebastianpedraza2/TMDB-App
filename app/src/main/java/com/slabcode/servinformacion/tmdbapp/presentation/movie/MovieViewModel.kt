package com.slabcode.servinformacion.tmdbapp.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.slabcode.servinformacion.tmdbapp.domain.usecase.GetMoviesUserCase
import com.slabcode.servinformacion.tmdbapp.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUserCase: GetMoviesUserCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {
    /**
     * This class calls the execute method of the use cases,
     * running this code on the main thread (default) is the best practice because in the datasource we are running the functions on IO
     */

    fun getMovies() = liveData {
        val movies = getMoviesUserCase.execute()
        emit(movies)
    }

    fun updateMovies() = liveData {
        val movies = updateMoviesUseCase.execute()
        emit(movies)
    }


}