package com.brocodes.findmovies.data.network

import com.brocodes.findmovies.models.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/trending/{media_type}/{time_window}")
    suspend fun getTrendingMovies(
        @Path("media_type") mediaType: String = "all",
        @Path("time_window") duration: String = "day",
        @Query("api") apiKey: String
    ): Response<MovieResponse>
}