package com.slabcode.servinformacion.tmdbapp.domain.repository

import com.slabcode.servinformacion.tmdbapp.data.model.movie.Movie
import com.slabcode.servinformacion.tmdbapp.data.model.tv.TvShow

interface TvShowRepo {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?

}