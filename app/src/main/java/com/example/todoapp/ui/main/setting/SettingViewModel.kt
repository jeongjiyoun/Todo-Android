package com.example.todoapp.ui.main.setting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.dao.UserDao
import com.example.todoapp.ui.main.util.Destination
import com.example.todoapp.ui.main.util.Event

class SettingViewModel(val userDao: UserDao) : ViewModel() {

    private val _destination = MutableLiveData<Event<Destination>>()
    val destination: LiveData<Event<Destination>>
        get() = _destination
    
}