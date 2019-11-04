package dev.kirillzhelt.androidacademyapp.tmdb

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TMDBMovieVideo(
    @Json(name = "key")
    val key: String
)