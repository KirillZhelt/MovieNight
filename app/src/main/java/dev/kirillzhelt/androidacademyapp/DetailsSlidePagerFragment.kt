package dev.kirillzhelt.androidacademyapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import dev.kirillzhelt.androidacademyapp.adapters.DetailsSlidePagerAdapter
import dev.kirillzhelt.androidacademyapp.model.Movie

class DetailsSlidePagerFragment : Fragment() {

    companion object {
        private const val ARG_MOVIES = "ARG_MOVIES"
        private const val ARG_CURRENT_MOVIE_POSITION = "ARG_CURRENT_MOVIE_POSITION"

        fun newInstance(movies: ArrayList<Movie>, currentMoviePosition: Int): DetailsSlidePagerFragment {
            val instance = DetailsSlidePagerFragment()

            val bundle = Bundle().apply {
                putParcelableArrayList(ARG_MOVIES, movies)
                putInt(ARG_CURRENT_MOVIE_POSITION, currentMoviePosition)
            }

            instance.arguments = bundle

            return instance
        }
    }

    private lateinit var pager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_details_slide_pager, container, false)

        val movies: ArrayList<Movie> = arguments!!.getParcelableArrayList(ARG_MOVIES)!!

        pager = view.findViewById(R.id.fragment_details_slide_pager_pgr)
        pager.adapter = DetailsSlidePagerAdapter(fragmentManager!!, movies)

        pager.currentItem = arguments!!.getInt(ARG_CURRENT_MOVIE_POSITION)

        return view
    }
}