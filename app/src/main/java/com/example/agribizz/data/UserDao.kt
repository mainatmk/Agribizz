package com.example.agribizz.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
    interface UserDao {
        @Insert(onConflict = OnConflictStrategy.IGNORE)
        fun addUser(user: user)

        @Query("SELECT * FROM Users_table ORDER BY id ASC")
        fun readAllData(): LiveData<List<user>>

    }