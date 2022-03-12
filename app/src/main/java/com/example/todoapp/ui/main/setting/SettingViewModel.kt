package com.example.todoapp.ui.main.setting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.R
import com.example.todoapp.dao.UserDao
import com.example.todoapp.ui.main.data.SettingItem
import com.example.todoapp.ui.main.home.HomeDestination
import com.example.todoapp.ui.main.util.Destination
import com.example.todoapp.ui.main.util.Event

class SettingViewModel(val userDao: UserDao) : ViewModel() {

    private val _destination = MutableLiveData<Event<Destination>>()
    val destination: LiveData<Event<Destination>>
        get() = _destination

    val settingItemList = listOf<SettingItem>(
        SettingItem(id= 0, name = "", description = "", image = 1),
        SettingItem(id= 1, name = "", description = "", image = androidx.appcompat.R.drawable.abc_btn_colored_material),
        SettingItem(id= 2, name = "", description = "", image = 1)

    )

    fun goSettingMenu(itemName: String) {

        when(itemName) {
            "A" -> _destination.postValue(Event(SettingDestination.setting))
            "B" -> _destination.postValue(Event(SettingDestination.setting))

        }
    }
}