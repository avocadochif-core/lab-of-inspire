package com.lab.of.inspire.networking.repository

import com.lab.of.inspire.networking.ApiClient
import com.lab.of.inspire.networking.ApiRequest
import com.lab.of.inspire.networking.Result
import com.lab.of.inspire.networking.baseResponseHandler
import com.lab.of.inspire.networking.safeApiCall

object AuthRepository {

    private val apiRequests: ApiRequest.Auth = ApiClient.getInstance().create(ApiRequest.Auth::class.java)

    suspend fun login() = safeApiCall {
        val response = apiRequests.login()
        response.baseResponseHandler(onSuccess = { Result.Success(response.body()!!) })
    }

}