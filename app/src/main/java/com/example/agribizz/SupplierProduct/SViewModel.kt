package com.example.agribizz.SupplierProduct

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

class SViewModel  (application: Application): AndroidViewModel(application) {

    val readAllData : LiveData<List<SGoods>>

    private val repository: SRepository
    private val readuserobservable = MediatorLiveData<SGoods>()

    init {
        val sDao = database.getDatabase(application).supplierDao()
        repository = SRepository(sDao)
        readAllData = repository.readAllData
    }

    fun addUser(supplier: SGoods) {
        viewModelScope.launch(Dispatchers.IO) {
            //this coroutine will run the function in a background thread
            repository.addUser(supplier)
        }
    }
    fun observeuser(): LiveData<SGoods>{
        return repository.fetchdata()
    }
}