package com.lab.of.inspire.networking.repository

import com.lab.of.inspire.networking.*

object PhotoRepository {

    private val apiRequests: ApiRequest.Photos = ApiClient.getInstance().create(ApiRequest.Photos::class.java)

    suspend fun getPhotos(page: Int, pepPage: Int = 15) = safeApiCall {
        val response = apiRequests.getPhotos(page, pepPage)
        response.baseResponseHandler(onSuccess = { Result.Success(response.body()!!) })
    }

}