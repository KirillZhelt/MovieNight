package dev.kirillzhelt.androidacademyapp.details

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import dev.kirillzhelt.androidacademyapp.details.DetailsFragment
import dev.kirillzhelt.androidacademyapp.model.Movie

class DetailsSlidePagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    var movies: List<Movie> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItem(position: Int): Fragment {
        return DetailsFragment.newInstance(movies[position])
    }

    override fun getCount(): Int {
        return movies.size
    }
}