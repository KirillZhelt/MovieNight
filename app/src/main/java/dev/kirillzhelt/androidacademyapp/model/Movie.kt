package dev.kirillzhelt.androidacademyapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(val moviePosterURL: String,
                 val movieBackgroundURL: String,
                 val movieTitle: String,
                 val movieDescription: String,
                 val movieTrailerURL: String,
                 val movieReleaseDate: String): Parcelable