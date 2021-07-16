package com.example.agribizz.register

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.agribizz.data.user

    @Dao
    interface RegisterDao {
        @Insert(onConflict = OnConflictStrategy.IGNORE)
        fun addUser(register: UserRegister)

        @Query("SELECT * FROM Users_table ORDER BY id ASC")
        fun readAllData(): LiveData<List<user>>

        @Query("SELECT * FROM Users_table LIMIT 1")
        fun getdata(): LiveData<user>

        @Query("Select * FROM users_table where Email = (:email_login) and Password = (:login_password) ")
        //select all the records in the database that has the firstname and password that the user has given
        fun loginuser(email_login:String , login_password: String): user
    }
