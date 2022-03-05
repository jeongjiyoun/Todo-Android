package com.example.todoapp.ui.main.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.todoapp.R
import com.example.todoapp.databinding.MainFragmentBinding
import com.example.todoapp.ui.main.util.observeEvent
import com.example.todoapp.ui.main.util.navigateTo

class MainFragment : Fragment(R.layout.main_fragment) {

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
        mainViewModel = MainViewModel()
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainBtnStart.setOnClickListener { onClickStart() }
        binding.mainBtnSignIn.setOnClickListener { onClickSignIn() }
        observeLiveData()
    }

    private fun observeLiveData() {
        mainViewModel.destination.observeEvent(viewLifecycleOwner) {
            this.findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToHomeFragment())
//            navigateTo(it)
        }
    }

    private fun onClickStart(){
        mainViewModel.goHome()
    }

    private fun onClickSignIn() {
        //TODO("Not yet implemented")
    }

}