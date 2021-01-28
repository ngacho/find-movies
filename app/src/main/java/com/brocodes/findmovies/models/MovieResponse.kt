package com.brocodes.findmovies.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class MovieResponse(
    @Json(name="page") val page: Int,
    @Json(name="results") val movies: List<MovieResponseResultsItem>,
    @Json(name="total_pages") val totalPages: Int,
    @Json(name="total_results") val totalResults: Int
)