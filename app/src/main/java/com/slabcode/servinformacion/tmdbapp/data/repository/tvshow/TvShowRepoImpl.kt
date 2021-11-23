package com.slabcode.servinformacion.tmdbapp.data.repository.tvshow

import android.util.Log
import com.slabcode.servinformacion.tmdbapp.data.model.artist.Artist
import com.slabcode.servinformacion.tmdbapp.data.model.tv.TvShow
import com.slabcode.servinformacion.tmdbapp.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.slabcode.servinformacion.tmdbapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.slabcode.servinformacion.tmdbapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.slabcode.servinformacion.tmdbapp.domain.repository.TvShowRepo
import java.lang.Exception

class TvShowRepoImpl(
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepo {
    override suspend fun getTvShows(): List<TvShow>? = getTvShowsFromCache()

    override suspend fun updateTvShows(): List<TvShow>? {
        val tvShowList = getTvShowsFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        return tvShowList
    }


    suspend fun getTvShowsFromApi(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if (body != null) {
                tvShowList = body.tvShows
            }

        } catch (error: Exception) {
            Log.i("getArtistFromApi", error.message.toString())
        }
        return tvShowList

    }

    suspend fun getTvShowsFromDb(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()

        } catch (error: Exception) {
            Log.i("getArtistFromApi", error.message.toString())
        }
        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromApi()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }
        return tvShowList

    }

    suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()

        } catch (error: Exception) {
            Log.i("getArtistFromApi", error.message.toString())
        }
        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromDb()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }
        return tvShowList

    }
}