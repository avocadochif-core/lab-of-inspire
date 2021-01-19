package com.lab.of.inspire.networking.consts

import android.text.format.DateUtils

object NetworkingGeneralConst {

    ////////////////////////////// Api client /////////////////////////////////

    const val CONTENT_TYPE_HEADER = "application/json"
    const val CONTENT_TYPE_HEADER_NAME = "Content-Type"
    const val ACCEPT_HEADER = "application/json"
    const val ACCEPT_HEADER_NAME = "Accept"
    const val READ_WRITE_TIMEOUT: Long = 30 * DateUtils.SECOND_IN_MILLIS
    const val CONNECTION_TIMEOUT: Long = 20 * DateUtils.SECOND_IN_MILLIS

    /////////////////////////////// Headers ///////////////////////////////////

    const val AUTHORIZATION = "Authorization"

    //////////////////////////////// Paths ////////////////////////////////////

    //////////////////////////////// Parts ////////////////////////////////////

    //////////////////////////////// Queries //////////////////////////////////

}