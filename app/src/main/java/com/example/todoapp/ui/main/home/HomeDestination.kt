package com.example.todoapp.ui.main.home

import com.example.todoapp.R
import com.example.todoapp.ui.main.util.Destination

object HomeDestination {
    val setting = Destination { navController, _ ->
        navController.navigate(R.id.action_homeFragment_to_SettingFragment)
    }
}