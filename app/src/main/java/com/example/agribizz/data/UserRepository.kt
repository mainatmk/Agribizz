package com.example.agribizz.data

import androidx.lifecycle.LiveData

class UserRepository (private val userDao: UserDao) {

    val readAllData: LiveData<List<user>> = userDao.readAllData()

    suspend fun addUser(user: user) {
        userDao.addUser(user)
    }


    fun fetchdata(): LiveData<user> {
      return userDao.getdata()
    }

}
