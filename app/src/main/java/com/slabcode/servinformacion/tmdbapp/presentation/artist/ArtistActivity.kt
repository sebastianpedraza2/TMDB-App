package com.slabcode.servinformacion.tmdbapp.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.slabcode.servinformacion.tmdbapp.R
import com.slabcode.servinformacion.tmdbapp.databinding.ActivityArtistBinding

class ArtistActivity : AppCompatActivity() {

    lateinit var binding: ActivityArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
    }
}