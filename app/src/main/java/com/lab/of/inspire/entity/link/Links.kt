package com.lab.of.inspire.entity.link

import com.google.gson.annotations.SerializedName
import com.lab.of.inspire.networking.consts.SerializedNames.DOWNLOAD
import com.lab.of.inspire.networking.consts.SerializedNames.DOWNLOAD_LOCATION
import com.lab.of.inspire.networking.consts.SerializedNames.HTML
import com.lab.of.inspire.networking.consts.SerializedNames.SELF

data class Links(

    @SerializedName(SELF)
    var self: String = "",

    @SerializedName(HTML)
    var html: String = "",

    @SerializedName(DOWNLOAD)
    var download: String = "",

    @SerializedName(DOWNLOAD_LOCATION)
    var downloadLocation: String = ""

)
