package com.slabcode.servinformacion.tmdbapp.data.model.artist


import com.google.gson.annotations.SerializedName

data class ArtistsList(

    @SerializedName("results")
    val artists: List<Artist>,

)