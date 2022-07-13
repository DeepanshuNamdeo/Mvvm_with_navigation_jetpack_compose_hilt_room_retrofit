package com.test.multitab.di

import android.content.Context
import androidx.room.Room
import com.test.multitab.data.local.AppDatabase
import com.test.multitab.data.local.UserDao
import com.test.multitab.data.remote.ApiService
import com.test.multitab.data.remote.UserRemoteData
import com.test.multitab.data.remote.UserRemoteDataImpl
import com.test.multitab.data.repository.UserRepository
import com.test.multitab.data.repository.UserRepositoryImpl
import com.test.multitab.utils.Constants
import com.test.multitab.utils.TokenInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Singleton
    @Provides
    fun provideOkhttpInterceptor(): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(interceptor = TokenInterceptor()).build()

    @Provides
    @Singleton
    @Inject
    fun provideRetrofit(baseUrl: String, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)


    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(appContext, AppDatabase::class.java, "App_database").build()
    }

    //locale dependencies
    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDao = appDatabase.userDao()

    //remote dependencies
    @Provides
    fun provideUserRemoteData(userRemoteDataImpl: UserRemoteDataImpl): UserRemoteData =
        userRemoteDataImpl

    @Provides
    fun provideUserRepo(userRepositoryImpl: UserRepositoryImpl): UserRepository = userRepositoryImpl
}