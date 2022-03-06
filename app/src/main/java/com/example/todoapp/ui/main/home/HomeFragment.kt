package com.example.todoapp.ui.main.home

import android.os.Bundle
import android.view.*
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.database.ToDoDatabase
import com.example.todoapp.databinding.HomeFragmentBinding
import com.example.todoapp.ui.main.util.navigateTo
import com.example.todoapp.ui.main.util.observeEvent

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var homeViewModel: HomeViewModel

    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val application = requireNotNull(this.activity).application
        val dataSource = ToDoDatabase.getInstance(application).userDao
        val viewModelFactory = HomeViewModelFactory(dataSource)

        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        homeViewModel = ViewModelProvider(this,viewModelFactory).get(HomeViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeToolbar.menuIcon.setOnClickListener { onClickMenu() }
        binding.homeNav.settingBtn.setOnClickListener { onClickSetting() }

        observeLiveData()

    }

    private fun observeLiveData() {
        homeViewModel.destination.observeEvent(viewLifecycleOwner) {
            navigateTo(it)
        }
    }

    private fun onClickMenu() {
        binding.home.openDrawer(GravityCompat.END)
    }

    private fun onClickSetting() {
        homeViewModel.goSetting()
    }
}