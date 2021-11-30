package com.slabcode.servinformacion.tmdbapp.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
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

    /**
     * To show the menu action
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    /**
     * To update the movies list, it will call the api again and delete and save to the db
     */
    private fun updateMovies() {
        val response = viewModel.updateMovies()
        response.observe(this, Observer {
            Log.d("MoviesResult", it.toString())
        })

    }
}