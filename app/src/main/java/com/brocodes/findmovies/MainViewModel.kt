package com.brocodes.findmovies

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brocodes.findmovies.data.Resource
import com.brocodes.findmovies.data.network.ApiService
import com.brocodes.findmovies.models.MovieResponse
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val apiService: ApiService
) : ViewModel() {

    private val _moviesList = MutableLiveData<Resource<MovieResponse?>>()

    val movieList: LiveData<Resource<MovieResponse?>>
        get() = _moviesList

    init {
        //TODO: change here. This is for testing
        getTrendingMovies()
    }


    private fun getTrendingMovies() = viewModelScope.launch {
        _moviesList.postValue(Resource.loading(null))
        apiService.getTrendingMovies(apiKey = BuildConfig.API_KEY).let {
            if (it.isSuccessful && it.body() != null) {
                _moviesList.postValue(Resource.success(it.body()))
                it.body().let { movieResponse ->
                    movieResponse?.movies?.forEach { movie ->
                        Log.i("MainViewModel", "getTrendingMovies: ${movie.name}")
                    }
                }

            } else {
                Log.e("MainViewModel", "getTrendingMovies: ${it.errorBody().toString()}")
                _moviesList.postValue(Resource.error(it.errorBody().toString(), null))
            }
        }

    }

}