package com.example.advweek4160421118.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.advweek4160421118.R


/**
 * A simple [Fragment] subclass.
 * Use the [StudentListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StudentListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_list, container, false)
    }

}