package com.test.multitab.data.local

import androidx.room.Dao
import androidx.room.Query
import com.test.multitab.data.entities.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getLocalUserList() : Flow<MutableList<User>>

}