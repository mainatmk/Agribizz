package com.example.agribizz.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Users_Table")
data class user (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val FirstName:String,
    val LastName:String,
    val Email:String,

    )