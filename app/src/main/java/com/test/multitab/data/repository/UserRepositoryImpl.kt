package com.test.multitab.data.repository

import com.test.multitab.data.entities.User
import com.test.multitab.data.entities.UserList
import com.test.multitab.data.remote.UserRemoteData
import com.test.multitab.data.local.UserDao
import retrofit2.Response
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userRemoteData: UserRemoteData,
    private val userDao: UserDao
    )
    : UserRepository {

    //Todo : FetchingStrategy fetch from server and store it in local db
    override suspend fun getUserList(): Response<UserList> = userRemoteData.getRemoteUserList()

    override suspend fun delete(user: User): Response<Unit> {
        return userRemoteData.delete(user)
    }

    override suspend fun createUser(user: User): Response<User>  {
        return userRemoteData.createUser(user)
    }

}