package com.slabcode.servinformacion.tmdbapp.data.model.tv


import com.google.gson.annotations.SerializedName

data class TvShowList(

    @SerializedName("results")
    val tvShows: List<TvShow>,

)