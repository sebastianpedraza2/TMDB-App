package com.slabcode.servinformacion.tmdbapp.presentation.di.tv

import com.slabcode.servinformacion.tmdbapp.presentation.artist.ArtistActivity
import com.slabcode.servinformacion.tmdbapp.presentation.movie.MovieActivity
import com.slabcode.servinformacion.tmdbapp.presentation.tv.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    /**
     * Esta clase se usa para injectar las dependencias al artist activity
     */

    fun inject(tvShowActivity: TvShowActivity)

    /**
     * Se crea un subcomponent factory para que el appComponent general sepa como crear instancias del artistsubcomponent, como un viewmodel factory
     */
    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }


}