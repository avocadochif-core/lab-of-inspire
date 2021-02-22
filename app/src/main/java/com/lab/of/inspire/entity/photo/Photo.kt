package com.lab.of.inspire.entity.photo

import com.google.gson.annotations.SerializedName
import com.lab.of.inspire.entity.link.Links
import com.lab.of.inspire.entity.url.Urls
import com.lab.of.inspire.networking.consts.SerializedNames.ALT_DESCRIPTION
import com.lab.of.inspire.networking.consts.SerializedNames.COLOR
import com.lab.of.inspire.networking.consts.SerializedNames.CREATED_AT
import com.lab.of.inspire.networking.consts.SerializedNames.DESCRIPTION
import com.lab.of.inspire.networking.consts.SerializedNames.HEIGHT
import com.lab.of.inspire.networking.consts.SerializedNames.ID
import com.lab.of.inspire.networking.consts.SerializedNames.LIKED_BY_USER
import com.lab.of.inspire.networking.consts.SerializedNames.LIKES
import com.lab.of.inspire.networking.consts.SerializedNames.LINKS
import com.lab.of.inspire.networking.consts.SerializedNames.URLS
import com.lab.of.inspire.networking.consts.SerializedNames.WIDTH

data class Photo(

    @SerializedName(ID)
    var id: String = "",

    @SerializedName(CREATED_AT)
    var createdAt: String? = null,

    @SerializedName(WIDTH)
    var width: Int? = null,

    @SerializedName(HEIGHT)
    var height: Int? = null,

    @SerializedName(COLOR)
    var color: String? = null,

    @SerializedName(DESCRIPTION)
    var description: String? = null,

    @SerializedName(ALT_DESCRIPTION)
    var altDescription: String? = null,

    @SerializedName(URLS)
    var urls: Urls? = null,

    @SerializedName(LINKS)
    var links: Links? = null,

    @SerializedName(LIKES)
    var likes: Int? = null,

    @SerializedName(LIKED_BY_USER)
    var likedByUser: Boolean = false

)
