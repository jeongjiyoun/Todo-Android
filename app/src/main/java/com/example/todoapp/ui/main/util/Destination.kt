package com.example.todoapp.ui.main.util

import android.content.Context
import androidx.navigation.NavController

class Destination(
    private vararg val keys: Any? = emptyArray(),
    val navigate: (NavController, Context) -> Unit
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Destination
        return keys.isNotEmpty() && keys.contentEquals(other.keys)
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}