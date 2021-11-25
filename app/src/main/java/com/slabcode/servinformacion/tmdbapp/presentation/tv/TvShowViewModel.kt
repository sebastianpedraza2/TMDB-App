package com.slabcode.servinformacion.tmdbapp.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.slabcode.servinformacion.tmdbapp.domain.usecase.GetTvShowsUseCase
import com.slabcode.servinformacion.tmdbapp.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {

    fun getTvShows() = liveData {
        val tvShows = getTvShowsUseCase.execute()
        emit(tvShows)
    }

    fun updateTvShows() = liveData {
        val tvShows = updateTvShowsUseCase.execute()
        emit(tvShows)
    }
}