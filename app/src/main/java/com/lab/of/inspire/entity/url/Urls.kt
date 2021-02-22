package com.lab.of.inspire.entity.url

import com.google.gson.annotations.SerializedName
import com.lab.of.inspire.networking.consts.SerializedNames.FULL
import com.lab.of.inspire.networking.consts.SerializedNames.RAW
import com.lab.of.inspire.networking.consts.SerializedNames.REGULAR
import com.lab.of.inspire.networking.consts.SerializedNames.SMALL
import com.lab.of.inspire.networking.consts.SerializedNames.THUMB

data class Urls(

    @SerializedName(RAW)
    var raw: String = "",

    @SerializedName(FULL)
    var full: String = "",

    @SerializedName(REGULAR)
    var regular: String = "",

    @SerializedName(SMALL)
    var small: String = "",

    @SerializedName(THUMB)
    var thumb: String = ""

)
