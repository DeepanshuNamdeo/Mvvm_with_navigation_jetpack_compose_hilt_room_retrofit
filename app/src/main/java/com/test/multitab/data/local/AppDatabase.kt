package com.test.multitab.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.multitab.data.entities.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){

    abstract fun userDao() : UserDao
}