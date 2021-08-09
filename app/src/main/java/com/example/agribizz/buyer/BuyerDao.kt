package com.example.agribizz.buyer

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface BuyerDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(Buyer: Buyer)

    @Query("SELECT * FROM Buyer_Table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Buyer>>

    @Query("SELECT * FROM Buyer_Table LIMIT 1")
    fun getdata(): LiveData<Buyer>

    @Query("DELETE FROM Buyer_Table WHERE Id LIKE :id" )
    fun delete(id: Int): Int


}