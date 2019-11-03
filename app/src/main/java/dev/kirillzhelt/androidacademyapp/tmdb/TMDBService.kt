package dev.kirillzhelt.androidacademyapp.tmdb

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    fun getMovies(@Query("api_key") apiKey: String): Call<List<MovieTMDB>>

}