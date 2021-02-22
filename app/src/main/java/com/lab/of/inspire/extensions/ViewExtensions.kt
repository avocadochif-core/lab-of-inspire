package com.lab.of.inspire.extensions

import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginBottom
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import androidx.core.view.marginTop
import com.lab.of.inspire.view.ui.listener.SingleClickListener

fun View.singleClickListener(onSingleClick:(View) -> Unit) {
    val singleClickListener = SingleClickListener { onSingleClick(it) }
    setOnClickListener(singleClickListener)
}

fun View.isKeyboardAppeared(bottomInset: Int) = bottomInset / resources.displayMetrics.heightPixels.toDouble() > .25

/**
 * Extension for view to set margins in edge-to-edge mode
 */
@Suppress("UNCHECKED_CAST")
fun <T: ViewGroup.MarginLayoutParams>View.setMargins(left: Int? = null, top: Int? = null, right: Int? = null, bottom: Int? = null) {
    (layoutParams as T).setMargins(
        left ?: marginLeft,
        top?.let { it + marginTop } ?: marginTop,
        right ?: marginRight,
        bottom?.let { it + marginBottom } ?: marginBottom
    )
}

/**
 * Extension for view to set paddings in edge-to-edge mode
 */
fun View.setPaddings(left: Int? = null, top: Int? = null, right: Int? = null, bottom: Int? = null) {
    setPadding(
        left ?: paddingStart,
        top?.let { it + paddingTop } ?: paddingTop,
        right ?: paddingEnd,
        bottom?.let { it + paddingBottom } ?: paddingBottom
    )
}