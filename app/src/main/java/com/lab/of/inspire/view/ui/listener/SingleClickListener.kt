package com.lab.of.inspire.view.ui.listener

import android.os.SystemClock
import android.view.View

/**
 * Click listener class which is to prevent double quick clicking of a view
 */
class SingleClickListener(private val onSingleClick: (View) -> Unit): View.OnClickListener {

    private var interval: Int = 1000
    private var lastTimeClicked: Long = 0

    override fun onClick(v: View?) {
        if (SystemClock.elapsedRealtime() - lastTimeClicked < interval) {
            return
        }
        lastTimeClicked = SystemClock.elapsedRealtime()
        onSingleClick(v!!)
    }
}