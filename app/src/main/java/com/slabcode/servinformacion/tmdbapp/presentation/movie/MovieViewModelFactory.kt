package com.slabcode.servinformacion.tmdbapp.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.slabcode.servinformacion.tmdbapp.domain.usecase.GetMoviesUserCase
import com.slabcode.servinformacion.tmdbapp.domain.usecase.UpdateMoviesUseCase

class MovieViewModelFactory(
    private val getMoviesUserCase: GetMoviesUserCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMoviesUserCase, updateMoviesUseCase) as T
    }
}