package com.example.todoapp.ui.main.setting

import SettingGroupieItem
import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.R
import com.example.todoapp.database.ToDoDatabase
import com.example.todoapp.databinding.SettingFragmentBinding
import com.example.todoapp.ui.main.AuthAppRepository
import com.example.todoapp.ui.main.data.SettingItem
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.Section


class SettingFragment: Fragment(R.layout.setting_fragment)  {

    companion object {
        fun newInstance() = SettingFragment()
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
        initRecyclerView()
        initBackButton()
    }

    private fun initRecyclerView(){
        val settingGroupAdapter = GroupieAdapter()

        val menuSection = Section()
        settingViewModel.settingItemList.forEach {
            menuSection.add(SettingGroupieItem(item = it,
                onClickListener= { _ -> setDirection(it) }))
        }
        settingGroupAdapter.add(menuSection)

        val menuInfoSection = Section()

        settingViewModel.settingInfoItemList.forEach {
            menuInfoSection.add(SettingGroupieItem(item = it,
                onClickListener= { _ -> setDirection(it) }))
        }
        settingGroupAdapter.add(menuInfoSection)

        val layoutManager = LinearLayoutManager(activity)
        val divider =
            DividerItemDecoration(binding.settingMenuRecyclerview.context, layoutManager.orientation)
        divider.drawable?.alpha = 120

        binding.settingMenuRecyclerview.adapter = settingGroupAdapter
        binding.settingMenuRecyclerview.addItemDecoration(divider)
    }

    private fun setDirection(item:SettingItem){
        settingViewModel.goDirection(item)
    }


    private fun observeLiveData() {
        settingViewModel.destination.observe(viewLifecycleOwner) {
            findNavController().navigate(it)
        }

        settingViewModel.callDialogFlg.observe(viewLifecycleOwner) {
            if(it) {
                callLogoutDialog()
            }
        }
    }

    private fun initBackButton() {
        binding.homeBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun callLogoutDialog() {
        val application = requireNotNull(this.activity).application

        var alertBuilder : AlertDialog.Builder = AlertDialog.Builder(this.activity)
        alertBuilder.setMessage(R.string.LOGOUT_MESSAGE)
        alertBuilder.setPositiveButton(R.string.LOGOUT_CONFIRM, DialogInterface.OnClickListener {
                dialogInterface, id ->
            val authAppRepository = AuthAppRepository(application)
            authAppRepository.logOut()
            findNavController().navigate(SettingDestination.homePage)
            return@OnClickListener
        })
        alertBuilder.setNeutralButton(R.string.LOGOUT_CANCEL, DialogInterface.OnClickListener {
                dialogInterface, id ->
            return@OnClickListener
        })
        alertBuilder.create().show()

        settingViewModel.setCallFlg(callDialogFlg=false)
    }
}