package com.slabcode.servinformacion.tmdbapp.presentation

import android.app.Application
import com.slabcode.servinformacion.tmdbapp.BuildConfig
import com.slabcode.servinformacion.tmdbapp.presentation.di.Injector
import com.slabcode.servinformacion.tmdbapp.presentation.di.artist.ArtistSubComponent
import com.slabcode.servinformacion.tmdbapp.presentation.di.core.*
import com.slabcode.servinformacion.tmdbapp.presentation.di.movie.MovieSubComponent
import com.slabcode.servinformacion.tmdbapp.presentation.di.tv.TvShowSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        /**
         * Creating the COMPONENT, Only need to add modules with constructor parameters
         */

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun injectMovieSubcomponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun injectTvShowSubcomponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun injectArtistSubcomponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}