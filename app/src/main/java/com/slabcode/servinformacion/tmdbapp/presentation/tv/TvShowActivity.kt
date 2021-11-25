package com.slabcode.servinformacion.tmdbapp.presentation.tv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.slabcode.servinformacion.tmdbapp.R
import com.slabcode.servinformacion.tmdbapp.databinding.ActivityTvShowBinding

class TvShowActivity : AppCompatActivity() {

    lateinit var binding: ActivityTvShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
    }
}