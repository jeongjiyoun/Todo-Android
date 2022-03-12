package com.example.todoapp.ui.main.setting

import com.example.todoapp.R
import com.example.todoapp.ui.main.util.Destination

object SettingDestination {
    
    //setting 각 화면 실장후 수정
    val setting = Destination { navController, _ ->
        navController.navigate(R.id.action_homeFragment_to_SettingFragment)
    }

}