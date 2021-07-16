package com.example.agribizz.register

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Register_Table")
data class UserRegister (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val Name:String,
    val Email:String,
    val PhoneNumber:String,
    val Address:String,


        )
