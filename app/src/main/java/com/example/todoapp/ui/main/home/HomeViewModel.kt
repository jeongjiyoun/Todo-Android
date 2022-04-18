package com.example.todoapp.ui.main.home


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.dao.UserDao
import com.example.todoapp.ui.main.util.Destination
import com.example.todoapp.ui.main.util.Event

class HomeViewModel(userDao: UserDao) : ViewModel() {

    private val _destination = MutableLiveData<Event<Destination>>()
    val destination: LiveData<Event<Destination>>
        get() = _destination

    fun goSetting() {
        _destination.postValue(Event(HomeDestination.setting))
    }
}