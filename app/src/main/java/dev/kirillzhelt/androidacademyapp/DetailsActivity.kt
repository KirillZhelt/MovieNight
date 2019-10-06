package dev.kirillzhelt.androidacademyapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import dev.kirillzhelt.androidacademyapp.model.Movie
import java.lang.IllegalArgumentException

class DetailsActivity : AppCompatActivity() {

    private lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        movie = intent?.getParcelableExtra(ARGS_MOVIE) ?: throw IllegalArgumentException("Missing movie argument")

        findViewById<TextView>(R.id.details_movie_title_tv).text = movie.movieTitle
        findViewById<TextView>(R.id.details_movie_description_tv).text = movie.movieDescription
        findViewById<TextView>(R.id.details_movie_release_date_tv).text = movie.movieReleaseDate

        findViewById<Button>(R.id.details_btn_movie_trailer).setOnClickListener {
            openMovieTrailer()
        }

        Picasso.get().load(movie.moviePosterURL).placeholder(R.drawable.movie_poster_placeholder).into(findViewById<ImageView>(R.id.details_movie_poster_iv))
        Picasso.get().load(movie.movieBackgroundURL).placeholder(R.drawable.movie_poster_placeholder).into(findViewById<ImageView>(R.id.details_movie_background_iv))
    }

    private fun openMovieTrailer() {
        val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(movie.movieTrailerURL))

        if (webIntent.resolveActivity(packageManager) != null)
            startActivity(webIntent)
    }

    companion object {
        const val ARGS_MOVIE = "ARGS_MOVIE"

        fun createIntent(context: Context, movie: Movie) : Intent {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(ARGS_MOVIE, movie)

            return intent
        }
    }
}
