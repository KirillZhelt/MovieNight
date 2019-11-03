package dev.kirillzhelt.androidacademyapp.tmdb

import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_TMDB_URL = "https://api.themoviedb.org/3/"
const val API_KEY = "52c0b5c41f32efe962c8b9a153819975"

interface TMDBService {

    @GET("movie/popular")
    suspend fun getMovies(@Query("api_key") apiKey: String): PopularMoviesTMDB

}