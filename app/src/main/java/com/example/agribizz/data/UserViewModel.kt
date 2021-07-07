package com.example.agribizz.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UserViewModel  (application: Application): AndroidViewModel(application) {
    private val repository: UserRepository
    private val readuserobservable = MediatorLiveData<user>()

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
    fun observeuser(): LiveData<user>{
        return repository.fetchdata()
    }
    }

