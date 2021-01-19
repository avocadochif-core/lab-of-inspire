package com.lab.of.inspire.networking

import com.lab.of.inspire.networking.error.ApiError

sealed class Result<out T: Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val apiError: ApiError) : Result<Nothing>()
}