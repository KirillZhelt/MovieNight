package dev.kirillzhelt.androidacademyapp.tmdb

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_TMDB_URL = "https://api.themoviedb.org/3/"

const val API_KEY = "52c0b5c41f32efe962c8b9a153819975"

const val IMAGES_BASE_URL = "https://image.tmdb.org/t/p/w500"

const val VIDEOS_BASE_URL = "https://www.youtube.com/watch?v="

interface TMDBService {

    @GET("movie/popular")
    suspend fun getMovies(@Query("api_key") apiKey: String): TMDBPopularMovies

    @GET("movie/{movie_id}/videos")
    suspend fun getVideo(@Path("movie_id") movieId: String, @Query("api_key") apiKey: String): TMDBMoviesVideo

}