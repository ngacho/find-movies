package com.brocodes.findmovies.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BelongsToCollection (

    @Json(name="id") val id : Int,
    @Json(name="name") val name : String,
    @Json(name="poster_path") val poster_path : String,
    @Json(name="backdrop_path") val backdrop_path : String
)

