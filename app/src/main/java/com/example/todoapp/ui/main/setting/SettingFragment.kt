package com.example.todoapp.ui.main.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.R
import com.example.todoapp.database.ToDoDatabase
import com.example.todoapp.databinding.SettingFragmentBinding
import com.example.todoapp.ui.main.main.MainFragment
import com.example.todoapp.ui.main.util.navigateTo
import com.example.todoapp.ui.main.util.observeEvent


class SettingFragment: Fragment(R.layout.setting_fragment)  {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var settingViewModel: SettingViewModel
    private var _binding: SettingFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val application = requireNotNull(this.activity).application
        val dataSource = ToDoDatabase.getInstance(application).userDao
        val viewModelFactory = SettingViewModelFactory(dataSource)

        settingViewModel = ViewModelProvider(this,viewModelFactory).get(SettingViewModel::class.java)
        _binding = SettingFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        observeLiveData()
    }

    private fun initRecyclerView(){
  //      val adapter = GroupieAdapter()
//        GroupieAdapter()
//        val groupAdapter = GroupAdapter<GroupieViewHolder<*>>()
//        binding.settingMenuRecyclerview.adapter = groupAdapter
//        val items = listOf(
//            HeaderItem("Header1"),
//            TextItem("test1"),
//            TextItem("test2"),
//            TextItem("test3"),
//            HeaderItem("Header2"),
//            TextItem("test4"),
//            TextItem("test5")
//        )
//        groupAdapter.update(items)
    }

    private fun observeLiveData() {
        settingViewModel.destination.observeEvent(viewLifecycleOwner) {
            navigateTo(it)
        }
    }

}