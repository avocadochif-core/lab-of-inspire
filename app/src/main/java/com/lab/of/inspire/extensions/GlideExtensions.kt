package com.lab.of.inspire.extensions

import android.widget.ImageView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.lab.of.inspire.utils.consts.ApplicationConstants.CROSS_FADE_DURATION

fun RequestManager.loadWithCache(url: String, iv: ImageView) {
    load(url)
        .transition(DrawableTransitionOptions.withCrossFade(CROSS_FADE_DURATION))
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(iv)
        .clearOnDetach()
}
