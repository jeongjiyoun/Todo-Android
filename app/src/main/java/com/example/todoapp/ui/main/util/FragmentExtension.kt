package com.example.todoapp.ui.main.util

import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

fun Fragment.navigateTo(destination: Destination) {
    destination.navigate(findNavController(), requireContext())
}
