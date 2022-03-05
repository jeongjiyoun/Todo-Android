package com.example.todoapp.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todoapp.database.ToDoDatabase
import com.example.todoapp.databinding.MainFragmentBinding
import com.example.todoapp.factory.MainViewModelFactory

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var mainViewModel: MainViewModel
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)

        val application = requireNotNull(this.activity).application

        // Create an instance of the ViewModel Factory.
        val dataSource = ToDoDatabase.getInstance(application).userDao
        val viewModelFactory = MainViewModelFactory(dataSource)

        mainViewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainBtnStart.setOnClickListener { mainViewModel.onClickStartbtn() }
        binding.mainBtnSignIn.setOnClickListener { mainViewModel.onClickSignInbtn() }
    }
}