package com.lab.of.inspire.view.viewpager.callbacks

import androidx.viewpager2.widget.ViewPager2

class PageChangedCallback(val onPageChanged: (position: Int) -> Unit) : ViewPager2.OnPageChangeCallback() {

    override fun onPageSelected(position: Int) {
        super.onPageSelected(position)
        onPageChanged(position)
    }
}