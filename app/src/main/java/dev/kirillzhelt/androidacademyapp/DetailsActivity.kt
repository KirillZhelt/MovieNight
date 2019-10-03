package dev.kirillzhelt.androidacademyapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {

    private lateinit var movieTrailerButton: Button

    companion object {
        const val TRAILER_YOUTUBE_ID = "6ZfuNTqbHE8"
    }

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
}
