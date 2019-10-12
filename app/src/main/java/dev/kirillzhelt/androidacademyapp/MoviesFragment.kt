package dev.kirillzhelt.androidacademyapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import dev.kirillzhelt.androidacademyapp.model.Movie
import dev.kirillzhelt.androidacademyapp.model.Repository

/**
 * A simple [Fragment] subclass.
 */
class MoviesFragment : Fragment() {

    private lateinit var repository: Repository

    private lateinit var movies: List<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        repository = Repository()

        movies = repository.loadMovies()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_movies, container, false)

        val moviesRecyclerView: RecyclerView = view.findViewById(R.id.fragment_movies_movies_rv)
        moviesRecyclerView.adapter = MoviesAdapter(activity!!, repository.loadMovies()) { position ->
            Toast.makeText(activity, movies[position].movieTitle, Toast.LENGTH_SHORT).show()

            val intent = DetailsActivity.createIntent(activity!!, movies[position])
            startActivity(intent)
        }

        return view
    }


}
