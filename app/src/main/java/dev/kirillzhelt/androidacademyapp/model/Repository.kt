package dev.kirillzhelt.androidacademyapp.model

import android.util.Log
import dev.kirillzhelt.androidacademyapp.model.cache.MoviesCache
import dev.kirillzhelt.androidacademyapp.tmdb.*
import retrofit2.*
import retrofit2.converter.moshi.MoshiConverterFactory

class Repository(private val moviesCache: MoviesCache, private val tmdbService: TMDBService) {

    suspend fun getPopularMovies(): List<Movie> {
        if (moviesCache.isCached()) {
            return moviesCache.getMovies()
        }

        val popularMovies = tmdbService.getMovies(API_KEY).results

        Log.i("Repository", popularMovies.toString())

        val moviesVideo = popularMovies.map { tmdbService.getVideo(it.movieId, API_KEY).results[0].key }

        Log.i("Repository", moviesVideo.toString())

        val result = arrayListOf<Movie>()
        for ((index, movie) in popularMovies.withIndex()) {
            result.add(Movie(
                movie.movieId,
                IMAGES_BASE_URL + movie.moviePosterURL,
                IMAGES_BASE_URL + movie.movieBackgroundURL,
                movie.movieTitle,
                movie.movieDescription,
                VIDEOS_BASE_URL + moviesVideo[index],
                movie.movieReleaseDate,
                movie.popularity
            ))
        }

        return result
    }

}