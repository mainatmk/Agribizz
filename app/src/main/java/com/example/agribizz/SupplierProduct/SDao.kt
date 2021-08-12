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
    fun addUser(supplier: SGoods)

    @Query("SELECT * FROM Suppliers_Table ORDER BY id ASC")
    fun readAllData(): LiveData<List<SGoods>>

    @Query("SELECT * FROM Suppliers_Table LIMIT 1")
    fun getdata(): LiveData<SGoods>

    @Query("DELETE FROM Suppliers_Table WHERE Id LIKE :id" )
    fun delete(id: Int): Int

}