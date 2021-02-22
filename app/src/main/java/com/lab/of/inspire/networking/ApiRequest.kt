package com.lab.of.inspire.networking

import com.lab.of.inspire.networking.consts.ApiRoutes.GET_PHOTOS
import com.lab.of.inspire.networking.consts.NetworkingGeneralConst.ORDER_BY
import com.lab.of.inspire.networking.consts.NetworkingGeneralConst.PAGE
import com.lab.of.inspire.networking.consts.NetworkingGeneralConst.PER_PAGE
import retrofit2.Response
import com.lab.of.inspire.entity.photo.Photo
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRequest {

    /////////////////////////////////////////////////////////
    /////////////////////// PHOTOS //////////////////////////
    /////////////////////////////////////////////////////////

    interface Photos {

        @GET(GET_PHOTOS)
        suspend fun getPhotos(
            @Query(PAGE) page: Int,
            @Query(PER_PAGE) perPage: Int? = null,
            @Query(ORDER_BY) orderBy: String? = null,
        ): Response<List<Photo>>

    }

}