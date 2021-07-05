package com.example.agribizz.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [user::class], version = 1, exportSchema = false)
abstract class database: RoomDatabase() {

  abstract fun userDao():UserDao

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