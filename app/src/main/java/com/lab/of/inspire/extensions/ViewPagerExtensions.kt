package com.lab.of.inspire.extensions

import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

fun ViewPager2.init(adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>, tabLayout: TabLayout? = null, callback: ViewPager2.OnPageChangeCallback? = null) {
    this.adapter = adapter
    tabLayout?.let { TabLayoutMediator(it, this) { _, _ -> }.attach() }
    callback?.let { this.registerOnPageChangeCallback(it) }
}
