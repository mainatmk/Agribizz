package com.example.agribizz.buyer

import androidx.lifecycle.LiveData

class BuyerRepository
    (private val buyerdao: BuyerDao) {

    val readAllData: LiveData<List<Buyer>> = buyerdao.readAllData()

    suspend fun addUser(buyer: Buyer) {
        buyerdao.addUser(buyer)
    }

    fun fetchdata(): LiveData<Buyer> {
        return buyerdao.getdata()

    }

}