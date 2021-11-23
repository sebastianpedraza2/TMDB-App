package com.slabcode.servinformacion.tmdbapp.data.repository.tvshow.datasourceImpl

import com.slabcode.servinformacion.tmdbapp.data.db.TvShowDao
import com.slabcode.servinformacion.tmdbapp.data.model.tv.TvShow
import com.slabcode.servinformacion.tmdbapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao) : TvShowLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TvShow> = tvShowDao.getAllTvShows()

    override suspend fun saveTvShowsToDB(tvShowList: List<TvShow>) {

        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShowList)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteTvShows()
        }
    }
}