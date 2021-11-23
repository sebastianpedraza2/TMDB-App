package com.slabcode.servinformacion.tmdbapp.data.repository.tvshow.datasource

import com.slabcode.servinformacion.tmdbapp.data.model.tv.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}