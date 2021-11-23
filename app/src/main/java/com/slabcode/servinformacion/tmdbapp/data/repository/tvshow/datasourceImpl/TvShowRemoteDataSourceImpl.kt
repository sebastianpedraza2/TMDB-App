package com.slabcode.servinformacion.tmdbapp.data.repository.tvshow.datasourceImpl

import com.slabcode.servinformacion.tmdbapp.data.api.TMDBService
import com.slabcode.servinformacion.tmdbapp.data.model.tv.TvShowList
import com.slabcode.servinformacion.tmdbapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)
}