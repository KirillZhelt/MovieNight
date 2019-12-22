package dev.kirillzhelt.androidacademyapp.tmdb

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TMDBMovie(
    @Json(name = "id")
    val movieId: Int,

    @Json(name = "poster_path")
    val moviePosterURL: String?,

    @Json(name = "backdrop_path")
    val movieBackgroundURL: String?,

    @Json(name = "title")
    val movieTitle: String,

    @Json(name = "overview")
    val movieDescription: String,

    @Json(name = "release_date")
    val movieReleaseDate: String,

    @Json(name = "popularity")
    val popularity: Double
)