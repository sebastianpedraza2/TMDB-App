package com.slabcode.servinformacion.tmdbapp.presentation.di.movie

import com.slabcode.servinformacion.tmdbapp.presentation.artist.ArtistActivity
import com.slabcode.servinformacion.tmdbapp.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    /**
     * Esta clase se usa para injectar las dependencias al movie activity
     */

    fun inject(movieActivity: MovieActivity)

    /**
     * Se crea un subcomponent factory para que el appComponent general sepa como crear instancias del artistsubcomponent, como un viewmodel factory
     */
    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }


}