package dev.kirillzhelt.androidacademyapp.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import dev.kirillzhelt.androidacademyapp.R
import dev.kirillzhelt.androidacademyapp.model.Movie
import dev.kirillzhelt.androidacademyapp.movies.MoviesViewModel

class DetailsSlidePagerFragment : Fragment() {

    private lateinit var pager: ViewPager

    private lateinit var moviesViewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_details_slide_pager, container, false)

        moviesViewModel = activity?.run {
            ViewModelProviders.of(this).get(MoviesViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        val adapter = DetailsSlidePagerAdapter(fragmentManager ?: throw Exception("Invalid FragmentManager"))

        pager = view.findViewById(R.id.fragment_details_slide_pager_pgr)
        pager.adapter = adapter

        moviesViewModel.movies.observe(this, Observer { movies ->
            adapter.movies = movies
        })

        moviesViewModel.currentMoviePosition.observe(this, Observer { currentItem ->
            pager.currentItem = currentItem
        })

        return view
    }
}