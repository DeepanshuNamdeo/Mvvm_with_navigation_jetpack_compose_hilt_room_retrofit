package com.test.multitab.data.remote

import com.test.multitab.data.entities.User
import com.test.multitab.data.entities.UserList
import retrofit2.Response
import javax.inject.Inject


class UserRemoteDataImpl @Inject constructor(private val apiService: ApiService) : UserRemoteData {

    override suspend fun getRemoteUserList(): Response<UserList> = apiService.getRemoteUserList()

    override suspend fun delete(user: User) : Response<Unit> {
        return apiService.deleteUser(user.id)
    }

    override suspend fun createUser(user: User) : Response<User>  {
        return apiService.createUser(user)
    }


}