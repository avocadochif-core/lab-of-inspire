package com.lab.of.inspire.entity.user

import com.google.gson.annotations.SerializedName
import com.lab.of.inspire.entity.image.Image
import com.lab.of.inspire.networking.consts.SerializedNames.FIRST_NAME
import com.lab.of.inspire.networking.consts.SerializedNames.ID
import com.lab.of.inspire.networking.consts.SerializedNames.LAST_NAME
import com.lab.of.inspire.networking.consts.SerializedNames.NAME
import com.lab.of.inspire.networking.consts.SerializedNames.PROFILE_IMAGE
import com.lab.of.inspire.networking.consts.SerializedNames.USERNAME

data class User(

    @SerializedName(ID)
    var id: String = "",

    @SerializedName(NAME)
    var name: String? = null,

    @SerializedName(USERNAME)
    var username: String? = null,

    @SerializedName(FIRST_NAME)
    var firstName: String? = null,

    @SerializedName(LAST_NAME)
    var lastName: String? = null,

    @SerializedName(PROFILE_IMAGE)
    var image: Image? = null

) {

    fun getUsernameForShowing(): String {
        name?.let { return it }
        username?.let { return it }
        return ""
    }

}
