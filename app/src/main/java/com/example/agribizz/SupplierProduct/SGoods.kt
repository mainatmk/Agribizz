package com.example.agribizz.SupplierProduct

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Suppliers_Table")
data class SGoods (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
        )
