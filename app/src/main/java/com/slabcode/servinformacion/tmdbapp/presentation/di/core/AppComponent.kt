package com.slabcode.servinformacion.tmdbapp.presentation.di.core

import com.slabcode.servinformacion.tmdbapp.presentation.di.artist.ArtistSubComponent
import com.slabcode.servinformacion.tmdbapp.presentation.di.movie.MovieSubComponent
import com.slabcode.servinformacion.tmdbapp.presentation.di.tv.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DataBaseModule::class,
        UseCaseModule::class,
        RepoModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class
    ]
)
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
}