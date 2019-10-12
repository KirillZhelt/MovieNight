package dev.kirillzhelt.androidacademyapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import dev.kirillzhelt.androidacademyapp.DetailsFragment

class DetailsSlidePagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return DetailsFragment()
    }

    override fun getCount(): Int {
        return 5
    }
}