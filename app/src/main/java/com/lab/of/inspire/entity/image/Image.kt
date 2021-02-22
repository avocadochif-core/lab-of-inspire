package com.lab.of.inspire.entity.image

import com.google.gson.annotations.SerializedName
import com.lab.of.inspire.networking.consts.SerializedNames.LARGE
import com.lab.of.inspire.networking.consts.SerializedNames.MEDIUM
import com.lab.of.inspire.networking.consts.SerializedNames.SMALL

data class Image(

    @SerializedName(SMALL)
    var small: String? = null,

    @SerializedName(MEDIUM)
    var medium: String? = null,

    @SerializedName(LARGE)
    var large: String? = null

)
