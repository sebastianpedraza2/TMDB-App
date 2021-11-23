package com.slabcode.servinformacion.tmdbapp.data.api

import com.slabcode.servinformacion.tmdbapp.data.model.artist.ArtistsList
import com.slabcode.servinformacion.tmdbapp.data.model.movie.MovieList
import com.slabcode.servinformacion.tmdbapp.data.model.tv.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("/movie/popular")
    suspend fun getPopularMovies(@Query("api_key") api_key: String): Response<MovieList>

    @GET("/tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") api_key: String): Response<TvShowList>

    @GET("/person/popular")
    suspend fun getPopularArtists(@Query("api_key") api_key: String): Response<ArtistsList>
}