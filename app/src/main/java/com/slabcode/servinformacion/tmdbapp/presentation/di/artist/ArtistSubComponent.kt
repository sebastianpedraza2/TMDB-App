package com.slabcode.servinformacion.tmdbapp.presentation.di.artist

import com.slabcode.servinformacion.tmdbapp.presentation.artist.ArtistActivity
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    /**
     * Esta clase se usa para injectar las dependencias al artist activity
     */

    fun inject(artistActivity: ArtistActivity)

    /**
     * Se crea un subcomponent factory para que el appComponent general sepa como crear instancias del artistsubcomponent, como un viewmodel factory.
     * Cuando se crean los componentes en la clase: Application, se llama al metodo create del factory para instanciar los subcomponentes
     */
    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistSubComponent
    }


}