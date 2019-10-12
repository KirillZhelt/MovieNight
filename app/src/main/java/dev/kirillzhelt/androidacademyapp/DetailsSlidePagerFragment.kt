package dev.kirillzhelt.androidacademyapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import dev.kirillzhelt.androidacademyapp.adapters.DetailsSlidePagerAdapter

class DetailsSlidePagerFragment : Fragment() {

    private lateinit var pager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_details_slide_pager, container, false)

        pager = view.findViewById(R.id.fragment_details_slide_pager_pgr)
        pager.adapter = DetailsSlidePagerAdapter(fragmentManager!!)

        return view
    }
}