package com.example.todoapp.ui.main.main

import com.example.todoapp.R
import com.example.todoapp.ui.main.util.Destination

object MainDestination {
    val home = Destination { navController, _ ->
        navController.navigate(R.id.action_mainFragment_to_homeFragment)
    }
}