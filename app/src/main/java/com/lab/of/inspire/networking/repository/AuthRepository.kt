package com.lab.of.inspire.networking.repository

import com.lab.of.inspire.networking.*

object AuthRepository {

    private val apiRequests: ApiRequest.Auth = ApiClient.getInstance().create(ApiRequest.Auth::class.java)

    suspend fun login() = safeApiCall {
        val response = apiRequests.login()
        response.baseResponseHandler(onSuccess = { Result.Success(response.body()!!) })
    }

}