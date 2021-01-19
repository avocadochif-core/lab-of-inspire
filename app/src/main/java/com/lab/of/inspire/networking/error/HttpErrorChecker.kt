package com.lab.of.inspire.networking.error

import org.json.JSONObject
import retrofit2.Response

object HttpErrorChecker {

    fun <T>checkError(response: Response<T>): ApiError {
        return try {
            val error = JSONObject(response.errorBody()!!.string())
            ApiError(error.getString("message"), ErrorType.UNSPECIFIED)
        } catch (e: Exception) {
            e.printStackTrace()
            getErrorBasedOnResponseCode(response.code())
        }
    }

    private fun getErrorBasedOnResponseCode(code: Int): ApiError {
        return when(code) {
            401 -> ApiError("User is not authorized to do this action", ErrorType.AUTHORIZATION)
            403 -> ApiError("The requested operation is forbidden and cannot be completed", ErrorType.AUTHORIZATION)
            404 -> ApiError("The requested operation failed because a resource associated with the request could not be found", ErrorType.NOT_FOUND)
            422 -> ApiError("Sent data isn't valid", ErrorType.VALIDATION_ERROR)
            429 -> ApiError("Too many requests have been sent within a given time span", ErrorType.TOO_MANY_REQUESTS)
            500 -> ApiError("The request failed due to an internal server error", ErrorType.SERVER_ERROR)
            else -> ApiError("Something else went wrong", ErrorType.UNSPECIFIED)
        }
    }

}