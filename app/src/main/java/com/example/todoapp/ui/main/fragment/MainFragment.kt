package com.example.todoapp.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.NavHostFragment
import com.example.todoapp.R
import com.example.todoapp.databinding.MainFragmentBinding
import com.example.todoapp.ui.main.viewmodel.MainViewModel


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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainBtnStart.setOnClickListener { onClickStart() }
        binding.mainBtnSignIn.setOnClickListener { onClickSignIn() }

    }
    private fun onClickStart(){
        //TODO("Not yet implemented")

        val action = MainFragmentDirections.actionMainFragmentToHomeFragment()

        val navHostFragment =requireActivity().supportFragmentManager
                .findFragmentById(R.id.mainFragment) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(action)
    }

    private fun onClickSignIn() {
        //TODO("Not yet implemented")
    }

}