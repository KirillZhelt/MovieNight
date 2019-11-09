package dev.kirillzhelt.androidacademyapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Movie(
    @PrimaryKey
    val id: Int,
    val moviePosterURL: String,
    val movieBackgroundURL: String,
    val movieTitle: String,
    val movieDescription: String,
    val movieTrailerURL: String,
    val movieReleaseDate: String,
    val popularity: Double
): Parcelable