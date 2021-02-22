package com.lab.of.inspire.networking

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.lab.of.inspire.BuildConfig
import com.lab.of.inspire.datasource.sharedpreference.CorePreferences
import com.lab.of.inspire.networking.consts.NetworkingGeneralConst.ACCEPT_HEADER
import com.lab.of.inspire.networking.consts.NetworkingGeneralConst.ACCEPT_HEADER_NAME
import com.lab.of.inspire.networking.consts.NetworkingGeneralConst.ACCEPT_VERSION_HEADER
import com.lab.of.inspire.networking.consts.NetworkingGeneralConst.ACCEPT_VERSION_HEADER_NAME
import com.lab.of.inspire.networking.consts.NetworkingGeneralConst.AUTHORIZATION
import com.lab.of.inspire.networking.consts.NetworkingGeneralConst.CONNECTION_TIMEOUT
import com.lab.of.inspire.networking.consts.NetworkingGeneralConst.CONTENT_TYPE_HEADER
import com.lab.of.inspire.networking.consts.NetworkingGeneralConst.CONTENT_TYPE_HEADER_NAME
import com.lab.of.inspire.networking.consts.NetworkingGeneralConst.READ_WRITE_TIMEOUT
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .client(buildOkHttpClient())
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    private fun buildOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
            .readTimeout(READ_WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
            .writeTimeout(READ_WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
            .addInterceptor(getLoggingInterceptor())
            .addInterceptor(getAuthenticationInterceptor())
            .addInterceptor { chain ->
                val requestBuilder = chain.request().newBuilder()
                requestBuilder.header(CONTENT_TYPE_HEADER_NAME, CONTENT_TYPE_HEADER)
                requestBuilder.header(ACCEPT_HEADER_NAME, ACCEPT_HEADER)
                requestBuilder.header(ACCEPT_VERSION_HEADER_NAME, ACCEPT_VERSION_HEADER)
                chain.proceed(requestBuilder.build())
            }
            .build()
    }

    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return httpLoggingInterceptor
    }

    private fun getAuthenticationInterceptor(): Interceptor {
        return object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val requestBuilder = chain.request().newBuilder()
                requestBuilder.addHeader(AUTHORIZATION, BuildConfig.PUBLIC_CLIENT_ID)
                return chain.proceed(requestBuilder.build())
            }
        }
    }

}