package com.example.agribizz.register

import android.os.FileObserver.DELETE
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

        @Query("SELECT * FROM Register_Table ORDER BY id ASC")
        fun readAllData(): LiveData<List<UserRegister>>

        @Query("SELECT * FROM Register_Table LIMIT 1")
        fun getdata(): LiveData<UserRegister>

        @Query("DELETE FROM Register_Table WHERE Id LIKE :id" )
        fun delete(id: Int): Int

        @Query("Select * FROM Register_Table where Email = (:email_login) and Password = (:login_password) ")
        //select all the records in the database that has the firstname and password that the user has given
        fun loginuser(email_login:String , login_password: String):UserRegister

    }

