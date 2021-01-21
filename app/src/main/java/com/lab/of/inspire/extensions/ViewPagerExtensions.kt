package com.lab.of.inspire.extensions

import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

fun ViewPager2.init(adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>, callback: ViewPager2.OnPageChangeCallback) {
    this.adapter = adapter
    this.registerOnPageChangeCallback(callback)
}
