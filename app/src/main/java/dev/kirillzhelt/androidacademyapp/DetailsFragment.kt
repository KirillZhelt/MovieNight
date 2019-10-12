package dev.kirillzhelt.androidacademyapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.kirillzhelt.androidacademyapp.model.Movie

class DetailsFragment : Fragment() {

    companion object {
        private const val ARG_MOVIE = "ARG_MOVIE"

        fun newInstance(movie: Movie): DetailsFragment {
            val instance = DetailsFragment()

            val bundle = Bundle().apply {
                putParcelable(ARG_MOVIE, movie)
            }

            instance.arguments = bundle

            return instance
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }



}