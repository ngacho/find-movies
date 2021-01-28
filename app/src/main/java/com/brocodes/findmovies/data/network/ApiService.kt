package com.brocodes.findmovies.data.network

import com.brocodes.findmovies.models.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query



interface ApiService {

    /*
    * Remember to remove the forward slash at the beginning of the string in the GET parameters.
    * I spent so many hours fixing this smh!!!
    *  */
    @GET("trending/{media_type}/{time_window}")
    suspend fun getTrendingMovies(
        @Path("media_type") mediaType: String = "all",
        @Path("time_window") duration: String = "day"
    ): Response<MovieResponse>
}