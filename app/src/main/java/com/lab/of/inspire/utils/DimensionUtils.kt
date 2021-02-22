package com.lab.of.inspire.utils

import android.content.res.Resources

object DimensionUtils {

    fun pxToDp(pxValue: Int): Float {
        return pxValue * Resources.getSystem().displayMetrics.density
    }

    fun dpToPx(dpValue: Int): Float {
        return dpValue / Resources.getSystem().displayMetrics.density
    }

}