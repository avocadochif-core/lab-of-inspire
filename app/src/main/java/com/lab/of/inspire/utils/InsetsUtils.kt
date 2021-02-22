package com.lab.of.inspire.utils

import android.view.View
import androidx.core.view.ViewCompat
import com.lab.of.inspire.extensions.isKeyboardAppeared

typealias OnSystemBarsSizeChangedListener = (statusBarSize: Int, navigationBarSize: Int) -> Unit

object InsetsUtils {

    fun removeSystemInsets(view: View, listener: OnSystemBarsSizeChangedListener) {
        ViewCompat.setOnApplyWindowInsetsListener(view) { _, insets ->
            val desiredBottomInset = calculateDesiredBottomInset(
                view,
                insets.systemWindowInsetTop,
                insets.systemWindowInsetBottom,
                listener
            )

            ViewCompat.onApplyWindowInsets(
                view,
                insets.replaceSystemWindowInsets(0, 0, 0, desiredBottomInset)
            )
        }
    }

    private fun calculateDesiredBottomInset(view: View, topInset: Int, bottomInset: Int, listener: OnSystemBarsSizeChangedListener): Int {
        val hasKeyboard = view.isKeyboardAppeared(bottomInset)
        val desiredBottomInset = if (hasKeyboard) bottomInset else 0
        listener(topInset, if (hasKeyboard) 0 else bottomInset)
        return desiredBottomInset
    }

}