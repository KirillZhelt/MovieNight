package dev.kirillzhelt.androidacademyapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import dev.kirillzhelt.androidacademyapp.adapters.MoviesAdapter
import dev.kirillzhelt.androidacademyapp.model.Movie
import dev.kirillzhelt.androidacademyapp.model.Repository

/**
 * A simple [Fragment] subclass.
 */
class MoviesFragment : Fragment() {

    private lateinit var movies: ArrayList<Movie>

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
            Toast.makeText(activity, movies[position].movieTitle, Toast.LENGTH_SHORT).show()

            val detailsSlidePagerFragment = DetailsSlidePagerFragment.newInstance(movies, position)

            fragmentManager?.beginTransaction()
                ?.addToBackStack(null)
                ?.replace(R.id.activity_movies_frm_lt, detailsSlidePagerFragment)
                ?.commit()
        }

        return view
    }

    interface OnMovieClicked {
        fun onMovieClicked(position: Int)
    }

}
