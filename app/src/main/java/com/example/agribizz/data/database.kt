package com.example.agribizz.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.agribizz.register.RegisterDao
import com.example.agribizz.register.UserRegister

@Database(entities = [user::class,UserRegister::class], version = 3, exportSchema = false)
abstract class
database: RoomDatabase() {

  abstract fun userDao():UserDao
  abstract fun RegisterDao():RegisterDao


    companion object{
        @Volatile
        private var INSTANCE: database?=null

        fun getDatabase(context: Context):database{
            val tempInstance = INSTANCE

            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    database::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance

                return  instance
            }

        }

    }

}