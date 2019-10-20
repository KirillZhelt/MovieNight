package dev.kirillzhelt.androidacademyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.kirillzhelt.androidacademyapp.model.Movie
import dev.kirillzhelt.androidacademyapp.model.Repository

class MoviesActivity : AppCompatActivity(), MoviesFragment.OnMovieClickedListener {

    private lateinit var repository: Repository

    private lateinit var movies: ArrayList<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        repository = Repository()

        movies = repository.loadMovies()

        val moviesFragment = MoviesFragment.newInstance(movies)

        supportFragmentManager.beginTransaction()
            .add(R.id.activity_movies_frm_lt, moviesFragment)
            .commit()
    }

    override fun onMovieClicked(position: Int) {
        Toast.makeText(this, movies[position].movieTitle, Toast.LENGTH_SHORT).show()

        val detailsSlidePagerFragment = DetailsSlidePagerFragment.newInstance(movies, position)

        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.activity_movies_frm_lt, detailsSlidePagerFragment)
            .commit()
    }
}
