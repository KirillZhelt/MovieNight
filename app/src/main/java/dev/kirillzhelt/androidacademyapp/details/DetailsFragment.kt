package dev.kirillzhelt.androidacademyapp.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import dev.kirillzhelt.androidacademyapp.R
import dev.kirillzhelt.androidacademyapp.model.Movie

class DetailsFragment : Fragment() {

    private lateinit var movie: Movie

    companion object {
        private const val ARG_MOVIE = "ARG_MOVIE"

        fun newInstance(movie: Movie): DetailsFragment {
            val instance = DetailsFragment()

            val bundle = Bundle().apply {
                putParcelable(ARG_MOVIE, movie)
            }

            instance.arguments = bundle

            return instance
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movie = arguments!!.getParcelable(ARG_MOVIE)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.details_movie_title_tv).text = movie.movieTitle
        view.findViewById<TextView>(R.id.details_movie_description_tv).text = movie.movieDescription
        view.findViewById<TextView>(R.id.details_movie_release_date_tv).text = movie.movieReleaseDate

        view.findViewById<Button>(R.id.details_btn_movie_trailer).setOnClickListener {
            openMovieTrailer()
        }

        Glide.with(this).load(movie.moviePosterURL).placeholder(R.drawable.movie_poster_placeholder).into(view.findViewById(
            R.id.details_movie_poster_iv
        ))
        Glide.with(this).load(movie.movieBackgroundURL).placeholder(R.drawable.movie_background_placeholder).into(view.findViewById(
            R.id.details_movie_background_iv
        ))
    }

    private fun openMovieTrailer() {
        val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(movie.movieTrailerURL))

        if (webIntent.resolveActivity(activity!!.packageManager) != null)
            startActivity(webIntent)
    }
}