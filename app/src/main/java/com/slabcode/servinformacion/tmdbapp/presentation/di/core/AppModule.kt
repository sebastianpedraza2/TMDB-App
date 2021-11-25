package com.slabcode.servinformacion.tmdbapp.presentation.di.core

import android.content.Context
import com.slabcode.servinformacion.tmdbapp.presentation.di.artist.ArtistSubComponent
import com.slabcode.servinformacion.tmdbapp.presentation.di.movie.MovieSubComponent
import com.slabcode.servinformacion.tmdbapp.presentation.di.tv.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Se listan todos los sub componentes definidos, desde el app component usamos el subcomponent factory para crear las instancias
 */
@Module(subcomponents = [MovieSubComponent::class, ArtistSubComponent::class, TvShowSubComponent::class])
class AppModule(private val context: Context) {

    /**
     * Provides the application context
     */

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}