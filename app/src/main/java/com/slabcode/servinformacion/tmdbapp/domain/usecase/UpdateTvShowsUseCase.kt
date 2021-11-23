package com.slabcode.servinformacion.tmdbapp.domain.usecase

import com.slabcode.servinformacion.tmdbapp.data.model.tv.TvShow
import com.slabcode.servinformacion.tmdbapp.domain.repository.TvShowRepo

class UpdateTvShowsUseCase(private val tvShowRepo: TvShowRepo) {
    suspend fun execute(): List<TvShow>? = tvShowRepo.updateTvShows()
}