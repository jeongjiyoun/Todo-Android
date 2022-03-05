package com.example.todoapp.ui.main.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.dao.UserDao
import com.example.todoapp.ui.main.util.Destination
import com.example.todoapp.ui.main.util.Event

class MainViewModel(val userDao: UserDao) : ViewModel() {

    private val _destination = MutableLiveData<Event<Destination>>()
    val destination: LiveData<Event<Destination>>
        get() = _destination

    fun goHome(){
        _destination.postValue(Event(MainDestination.home))
    }

}