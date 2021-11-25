package com.slabcode.servinformacion.tmdbapp.presentation.di

import com.slabcode.servinformacion.tmdbapp.presentation.di.artist.ArtistSubComponent
import com.slabcode.servinformacion.tmdbapp.presentation.di.movie.MovieSubComponent
import com.slabcode.servinformacion.tmdbapp.presentation.di.tv.TvShowSubComponent

/**
 * best practice to create injector interface with abstract functions to intantiate the subcomponents and that will we implemented in the class extending application
 */
interface Injector {

    fun injectMovieSubcomponent(): MovieSubComponent
    fun injectTvShowSubcomponent(): TvShowSubComponent
    fun injectArtistSubcomponent(): ArtistSubComponent
}