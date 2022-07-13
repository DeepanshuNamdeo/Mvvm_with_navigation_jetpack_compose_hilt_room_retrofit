package com.test.multitab.data.remote

import com.test.multitab.data.entities.User
import com.test.multitab.data.entities.UserList
import retrofit2.Response

interface UserRemoteData {

    suspend fun getRemoteUserList() : Response<UserList>

    suspend fun delete(user: User) : Response<Unit>

    suspend fun createUser(user: User) : Response<User>

}