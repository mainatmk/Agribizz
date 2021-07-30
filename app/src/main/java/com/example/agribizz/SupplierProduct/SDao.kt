package com.example.agribizz.SupplierProduct

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.agribizz.data.user


@Dao
interface SDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user: user)

    @Query("SELECT * FROM Users_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<SGoods>>

    @Query("SELECT * FROM Users_table LIMIT 1")
    fun getdata(): LiveData<user>

}