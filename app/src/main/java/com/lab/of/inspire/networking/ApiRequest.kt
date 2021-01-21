package com.lab.of.inspire.networking

import com.lab.of.inspire.networking.consts.ApiRoutes.LOGIN
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.POST

interface ApiRequest {

    /////////////////////////////////////////////////////////
    ///////////////////////// AUTH //////////////////////////
    /////////////////////////////////////////////////////////

    interface Auth {

        @POST(LOGIN)
        suspend fun login() : Response<ResponseBody>

    }

}