package com.example.agribizz.SupplierProduct

import androidx.lifecycle.LiveData
import com.example.agribizz.data.UserDao
import com.example.agribizz.data.user

class SRepository (private val SDao: SDao) {

    val readAllData: LiveData<List<SGoods>> = SDao.readAllData()

    suspend fun addUser(supplier: SGoods) {
        SDao.addUser(supplier)
    }


    fun fetchdata(): LiveData<SGoods> {
        return SDao.getdata()
    }
}