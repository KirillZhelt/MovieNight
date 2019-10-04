package dev.kirillzhelt.androidacademyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import dev.kirillzhelt.androidacademyapp.model.Repository

class MoviesActivity : AppCompatActivity() {

    private lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        repository = Repository()

        val movies = repository.loadMovies()

        val moviesRecyclerView: RecyclerView = findViewById(R.id.movies_rv)
        moviesRecyclerView.adapter = MoviesAdapter(this, repository.loadMovies()) { position ->
            Toast.makeText(this, movies[position].movieTitle, Toast.LENGTH_SHORT).show()

            val intent = Intent(this, DetailsActivity::class.java)
            startActivity(intent)
        }
    }
}
