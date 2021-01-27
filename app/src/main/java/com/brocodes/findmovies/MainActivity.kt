package com.brocodes.findmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.brocodes.findmovies.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityBinding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        val mainActivityView = mainActivityBinding.root
        setContentView(mainActivityView)

        mainViewModel.movieList.observe(this, {
            Log.i("MainActivity", "onCreate: ${it.status}")
            Log.i("MainActivity", "onCreate: ${it.message}")

        })
    }
}