package com.example.agribizz.register

import androidx.lifecycle.LiveData
import com.example.agribizz.data.UserDao
import com.example.agribizz.data.user

class RegisterRepository (private val registerDao: RegisterDao) {

    val readAllData: LiveData<List<user>> = registerDao.readAllData()

    suspend fun addUser(user: user) {
        RegisterDao.addUser(register)
    }


    fun fetchdata(): LiveData<user> {
        return registerDao.getdata()
    }
}
