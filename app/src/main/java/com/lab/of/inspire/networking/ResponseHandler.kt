package com.lab.of.inspire.networking

import android.util.Log
import com.lab.of.inspire.networking.error.ApiError
import com.lab.of.inspire.networking.error.ErrorType
import com.lab.of.inspire.networking.error.HttpErrorChecker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.net.SocketTimeoutException
import java.net.UnknownHostException

suspend fun <T : Any> safeApiCall(call: suspend () -> Result<T>): Result<T> = try {
    withContext(Dispatchers.IO) { call.invoke() }
} catch (e: HttpException) {
    Result.Error(ApiError(e.message(), ErrorType.UNSPECIFIED))
} catch (e: UnknownHostException) {
    Result.Error(ApiError("No internet connection", ErrorType.NO_NETWORK))
} catch (e: SocketTimeoutException) {
    Result.Error(ApiError("Bad internet connection", ErrorType.NETWORK_TIMEOUT))
} catch (e: Throwable) {
    Log.e("Internal API ERROR", e.stackTrace.toString())
    Result.Error(ApiError("Ooops: Something else went wrong", ErrorType.INTERNAL_ERROR))
}

fun <T: Any, B: Any>Response<T>.baseResponseHandler(onSuccess: () -> Result<B>): Result<B> {
    return if (this.isSuccessful) onSuccess() else Result.Error(HttpErrorChecker.checkError(this))
}

fun isAllResultSuccess(vararg results: Result<Any>): Boolean {
    return results.all { it is Result.Success }
}