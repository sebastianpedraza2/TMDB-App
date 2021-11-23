package com.slabcode.servinformacion.tmdbapp.data.repository.tvshow.datasource

import com.slabcode.servinformacion.tmdbapp.data.model.tv.TvShow
import com.slabcode.servinformacion.tmdbapp.data.model.tv.TvShowList

interface TvShowLocalDataSource {

    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(tvShowList: List<TvShow>)
    suspend fun clearAll()
}