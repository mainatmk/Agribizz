package com.example.agribizz.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UserViewModel  (application: Application): AndroidViewModel(application) {
    private val repository: UserRepository


    init {
        val userDao = database.getDatabase(application).userDao()
        repository = UserRepository(userDao)
    }

        fun addUser(user: user) {
            viewModelScope.launch(Dispatchers.IO) {
                //this coroutine will run the function in a background thread
                repository.addUser(user)
            }
        }
    }

