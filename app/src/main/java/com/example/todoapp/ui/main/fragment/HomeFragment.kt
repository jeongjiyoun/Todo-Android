package com.example.todoapp.ui.main.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.todoapp.R
import com.example.todoapp.ui.main.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }


    fun onClickMenu() {
        //navigation_view

    }


}