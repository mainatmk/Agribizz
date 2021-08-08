package com.example.agribizz.buyer

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Buyer_Table")
data class Buyer (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val ProductName:String,
    val ProductDescription:String,
    val PriceRange:String,
    val AreasTargetted:String,
    val PhoneNumber:String,

        )

