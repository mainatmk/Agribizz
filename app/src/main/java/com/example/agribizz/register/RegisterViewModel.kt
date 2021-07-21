package com.example.agribizz.register

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.viewModelScope
import com.example.agribizz.data.UserRepository
import com.example.agribizz.data.database
import com.example.agribizz.data.user
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel (application: Application): AndroidViewModel(application) {

    val readAllData :LiveData<List<user>>

    private val repository: RegisterRepository
    private val readuserobservable = MediatorLiveData<user>()


    init {
        val userDao = database.getDatabase(application).RegisterDao()
        repository = RegisterRepository(userDao)
        readAllData = repository.readAllData

    }

    fun addUser(register: UserRegister) {
        viewModelScope.launch(Dispatchers.IO) {
            //this coroutine will run the function in a background thread
            repository.addUser(register)
        }
    }

    fun observeuser(): LiveData<user> {
        return repository.fetchdata()
    }
}