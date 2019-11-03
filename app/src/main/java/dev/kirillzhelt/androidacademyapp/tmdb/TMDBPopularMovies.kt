package dev.kirillzhelt.androidacademyapp.tmdb

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TMDBPopularMovies(
    val results: List<TMDBMovie>
)