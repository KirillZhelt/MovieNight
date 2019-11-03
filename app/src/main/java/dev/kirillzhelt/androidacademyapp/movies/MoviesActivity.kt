package dev.kirillzhelt.androidacademyapp.movies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import dev.kirillzhelt.androidacademyapp.R
import dev.kirillzhelt.androidacademyapp.details.DetailsSlidePagerFragment
import dev.kirillzhelt.androidacademyapp.model.Movie
import dev.kirillzhelt.androidacademyapp.model.Repository
import dev.kirillzhelt.androidacademyapp.tasks.TaskActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MoviesActivity : AppCompatActivity(),
    MoviesFragment.OnMovieClickedListener {

    private lateinit var repository: Repository

    private lateinit var movies: ArrayList<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        repository = Repository()

        GlobalScope.launch(Dispatchers.Default) {
            movies = repository.loadMoviesFromNetwork()

            val moviesFragment =
                MoviesFragment.newInstance(movies)

            supportFragmentManager.beginTransaction()
                .add(R.id.activity_movies_frm_lt, moviesFragment)
                .commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_tasks, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_tasks_coroutines_activity_itm -> {
                val intent = Intent(this, TaskActivity::class.java)
                intent.putExtra(TaskActivity.ARGS_TASK_TYPE, TaskActivity.ARGS_TASK_TYPE_COROUTINES)

                startActivity(intent)

                true
            }

            R.id.menu_tasks_thread_handler_activity_itm -> {
                val intent = Intent(this, TaskActivity::class.java)
                intent.putExtra(TaskActivity.ARGS_TASK_TYPE, TaskActivity.ARGS_TASK_TYPE_THREAD_HANDLER)

                startActivity(intent)

                true
            }

            else -> super.onOptionsItemSelected(item)
        }
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
