package com.test.multitab.utils

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response


class TokenInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val yourtokenvalue = "d26ffd4353f0c142e802931f8c8aaa183d2e29eb2628a7af60b04d0f3ab70fd5"
        val newRequest: Request = chain.request().newBuilder()
            .header("Authorization", "Bearer $yourtokenvalue")
            .build()
        return chain.proceed(newRequest)
    }
}