package com.example.agribizz.buyer

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.viewModelScope
import com.example.agribizz.data.database
import com.example.agribizz.data.user
import com.example.agribizz.register.RegisterRepository
import com.example.agribizz.register.UserRegister
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BuyerViewModel (application: Application): AndroidViewModel(application){

    val readAllData : LiveData<List<Buyer>>

    private val repository: BuyerRepository
    private val readuserobservable = MediatorLiveData<Buyer>()


    init {
        val buyerDao = database.getDatabase(application).buyerDao()
        repository = BuyerRepository(buyerDao)
        readAllData = repository.readAllData

    }

    fun addUser(buyer: Buyer) {
        viewModelScope.launch(Dispatchers.IO) {
            //this coroutine will run the function in a background thread
            repository.addUser(buyer)

        }
    }

    fun observeuser(): LiveData<Buyer> {
        return repository.fetchdata()
    }
}