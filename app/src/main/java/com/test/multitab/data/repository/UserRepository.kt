package com.test.multitab.data.repository

import com.test.multitab.data.entities.User
import com.test.multitab.data.entities.UserList
import retrofit2.Response

interface UserRepository {

    suspend fun getUserList(): Response<UserList>

    suspend fun delete(user: User) : Response<Unit>

    suspend fun createUser(user: User) : Response<User>

}