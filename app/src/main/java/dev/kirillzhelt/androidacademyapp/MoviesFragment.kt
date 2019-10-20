package dev.kirillzhelt.androidacademyapp


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.kirillzhelt.androidacademyapp.adapters.MoviesAdapter
import dev.kirillzhelt.androidacademyapp.model.Movie

/**
 * A simple [Fragment] subclass.
 */
class MoviesFragment : Fragment() {

    private lateinit var movies: ArrayList<Movie>

    private lateinit var listener: OnMovieClickedListener

    companion object {
        private const val ARG_MOVIES = "ARG_MOVIES"

        fun newInstance(movies: ArrayList<Movie>): MoviesFragment {
            val instance = MoviesFragment()

            val bundle = Bundle().apply {
                putParcelableArrayList(ARG_MOVIES, movies)
            }

            instance.arguments = bundle

            return instance
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_movies, container, false)

        movies = arguments!!.getParcelableArrayList<Movie>(ARG_MOVIES)!!

        val moviesRecyclerView: RecyclerView = view.findViewById(R.id.fragment_movies_movies_rv)
        moviesRecyclerView.adapter = MoviesAdapter(
            activity!!,
            movies
        ) { position ->
            listener.onMovieClicked(position)
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is MoviesActivity) {
            listener = context
        }
    }

    interface OnMovieClickedListener {
        fun onMovieClicked(position: Int)
    }

}
