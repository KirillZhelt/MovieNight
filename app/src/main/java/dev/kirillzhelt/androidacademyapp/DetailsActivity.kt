package dev.kirillzhelt.androidacademyapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import dev.kirillzhelt.androidacademyapp.model.Movie

class DetailsActivity : AppCompatActivity() {

    private lateinit var movieTrailerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        movieTrailerButton = findViewById(R.id.btn_movie_trailer)

        movieTrailerButton.setOnClickListener { openMovieTrailer() }
    }

    private fun openMovieTrailer() {
        val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + TRAILER_YOUTUBE_ID))
        val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + TRAILER_YOUTUBE_ID))

        if (appIntent.resolveActivity(packageManager) != null) {
            startActivity(appIntent)
        } else {
            startActivity(webIntent)
        }

    }

    companion object {
        const val TRAILER_YOUTUBE_ID = "6ZfuNTqbHE8"
        const val ARGS_MOVIE = "ARGS_MOVIE"

        fun createIntent(context: Context, movie: Movie) : Intent {
            val intent = Intent(context, this::class.java)
            intent.putExtra(ARGS_MOVIE, movie)

            return intent
        }
    }
}
