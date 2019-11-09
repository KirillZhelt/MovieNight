package dev.kirillzhelt.androidacademyapp.model.cache

import dev.kirillzhelt.androidacademyapp.model.Movie
import dev.kirillzhelt.androidacademyapp.model.SharedPreferenceApi
import dev.kirillzhelt.androidacademyapp.model.db.MovieDao
import java.util.concurrent.TimeUnit
import kotlin.math.abs

class MoviesCache(private val movieDao: MovieDao,
                  private val sharedPreferenceApi: SharedPreferenceApi) {

    fun isCached(): Boolean {
        val time = System.currentTimeMillis()
        val lastCacheTime = sharedPreferenceApi.lastCacheTime

        val diffInMillies = abs(time - lastCacheTime)
        val diffInMinutes = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS)

        return diffInMinutes < 10
    }

    fun getMovies(): List<Movie> {
        return movieDao.getAll()
    }
}