package dev.kirillzhelt.androidacademyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import dev.kirillzhelt.androidacademyapp.model.Repository

class MoviesActivity : AppCompatActivity() {

    private lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        repository = Repository()

        val moviesRecyclerView: RecyclerView = findViewById(R.id.movies_rv)
        moviesRecyclerView.adapter = MoviesAdapter(this, repository.loadMovies())
    }
}
