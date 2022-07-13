package com.test.multitab.data.remote

import com.test.multitab.data.entities.User
import com.test.multitab.data.entities.UserList
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("v2/users")
    suspend fun getRemoteUserList() : Response<UserList>

    @DELETE("v2/users/{id}")
    suspend fun deleteUser(@Path("id") int: Int) : Response<Unit>

    @POST("/public/v2/users")
    suspend fun createUser(@Body user: User) : Response<User>

}