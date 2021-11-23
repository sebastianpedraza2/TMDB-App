package com.slabcode.servinformacion.tmdbapp.data.repository.tvshow.datasource

import com.slabcode.servinformacion.tmdbapp.data.model.tv.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache(): List<TvShow>
    suspend fun saveTvShowsToCache(tvShowList: List<TvShow>)
}