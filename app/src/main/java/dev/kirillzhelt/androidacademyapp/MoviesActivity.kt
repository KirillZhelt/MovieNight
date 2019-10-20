package dev.kirillzhelt.androidacademyapp

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

        val moviesFragment = MoviesFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.activity_movies_frm_lt, moviesFragment)
            .commit()
    }
}
