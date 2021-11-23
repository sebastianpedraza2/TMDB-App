package com.slabcode.servinformacion.tmdbapp.data.repository.tvshow.datasourceImpl

import com.slabcode.servinformacion.tmdbapp.data.model.artist.Artist
import com.slabcode.servinformacion.tmdbapp.data.model.tv.TvShow
import com.slabcode.servinformacion.tmdbapp.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {

    private var cachedTvShows = ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> = cachedTvShows

    override suspend fun saveTvShowsToCache(tvShowList: List<TvShow>) {
        cachedTvShows.clear()
        cachedTvShows = ArrayList(tvShowList)
    }
}