package com.slabcode.servinformacion.tmdbapp.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.slabcode.servinformacion.tmdbapp.R
import com.slabcode.servinformacion.tmdbapp.databinding.ActivityHomeBinding
import com.slabcode.servinformacion.tmdbapp.presentation.artist.ArtistActivity
import com.slabcode.servinformacion.tmdbapp.presentation.movie.MovieActivity
import com.slabcode.servinformacion.tmdbapp.presentation.tv.TvShowActivity

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.movieButton.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.tvButton.setOnClickListener {
            val intent = Intent(this, TvShowActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.artistsButton.setOnClickListener {
            val intent = Intent(this, ArtistActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}