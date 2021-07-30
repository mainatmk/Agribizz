package com.example.agribizz.register

import androidx.lifecycle.LiveData
import com.example.agribizz.data.UserDao
import com.example.agribizz.data.user

 class RegisterRepository (private val registerDao: RegisterDao) {

    val readAllData: LiveData<List<UserRegister>> = registerDao.readAllData()

    suspend fun addUser(register: UserRegister) {
       registerDao.addUser(register)
    }

    fun fetchdata(): LiveData<UserRegister> {
        return registerDao.getdata()
    }
}
