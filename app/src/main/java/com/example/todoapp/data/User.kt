package com.example.todoapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class User {

    @PrimaryKey(autoGenerate = false)
    var uid: String = ""

    @ColumnInfo(name = "username")
    var username: String = ""

    @ColumnInfo(name = "profile")
    var profile: String = ""

    @ColumnInfo(name = "email")
    var email: String = ""
}