package dev.kirillzhelt.androidacademyapp.dependencies

import dev.kirillzhelt.androidacademyapp.model.Repository
import dev.kirillzhelt.androidacademyapp.model.cache.MoviesCache
import dev.kirillzhelt.androidacademyapp.tmdb.BASE_TMDB_URL
import dev.kirillzhelt.androidacademyapp.tmdb.TMDBService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

object Dependencies {

    val repository: Repository by lazy {
        Repository(createMoviesCache(), createTmdbService())
    }

    private fun createMoviesCache(): MoviesCache {
        throw NotImplementedError()
    }

    private fun createTmdbService(): TMDBService {
        return Retrofit.Builder()
            .baseUrl(BASE_TMDB_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create()
    }

}