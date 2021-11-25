package com.slabcode.servinformacion.tmdbapp.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.slabcode.servinformacion.tmdbapp.R
import com.slabcode.servinformacion.tmdbapp.databinding.ActivityMovieBinding
import com.slabcode.servinformacion.tmdbapp.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    /**
     * Se injecta el view model factory, abajo con el factory se crea la instancia de view model
     */
    @Inject
    lateinit var viewModelFactory: MovieViewModelFactory
    private lateinit var viewModel: MovieViewModel
    lateinit var binding: ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)

        /**
         * Injecting
         */
        (application as Injector).injectMovieSubcomponent().inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MovieViewModel::class.java)

        val liveDataResponse = viewModel.getMovies()
        liveDataResponse.observe(this, Observer {
            Log.d("MoviesResult", it.toString())
        })
    }
}