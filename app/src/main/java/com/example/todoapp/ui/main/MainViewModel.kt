package com.example.todoapp.ui.main

import androidx.lifecycle.ViewModel
import com.example.todoapp.dao.UserDao
import com.example.todoapp.data.User

class MainViewModel(val userDao: UserDao) : ViewModel() {

    init {
        //testRoom()
    }

    fun onClickStartbtn(){
        //TODO("Not yet implemented")
    }

    fun onClickSignInbtn() {
        //TODO("Not yet implemented")
    }

    private fun testRoom(){
        var user = User()
        user.uid = "test1"
        user.profile = "1"
        user.email = "1"
        user.username = "1"

        userDao.insertUser(user)
    }
}