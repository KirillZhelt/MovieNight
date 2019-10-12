package dev.kirillzhelt.androidacademyapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class DetailsFragment : Fragment() {

//    companion object {
//
//        fun newInstance() {
//            val instance = DetailsFragment()
//
//            val bundle = Bundle().apply {
//                putParcelableArrayList()
//            }
//
//        }
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }



}