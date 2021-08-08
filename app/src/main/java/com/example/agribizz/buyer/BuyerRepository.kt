package com.example.agribizz.buyer

import androidx.lifecycle.LiveData
import com.example.agribizz.register.RegisterDao
import com.example.agribizz.register.UserRegister

class BuyerRepository
    (private val buyerdao: BuyerDao) {

    val readAllData: LiveData<List<Buyer>> = buyerdao.readAllData()

    suspend fun addUser(buyer: BuyerRepository) {
        buyerdao.addUser(buyer)
    }

    fun fetchdata(): LiveData<Buyer> {
        return buyerdao.getdata()
    }

}