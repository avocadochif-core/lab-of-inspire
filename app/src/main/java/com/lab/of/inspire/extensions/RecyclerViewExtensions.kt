package com.lab.of.inspire.extensions

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lab.of.inspire.view.ui.listener.EndlessRecyclerViewScrollListener

fun <A : RecyclerView.ViewHolder>RecyclerView.initVertical(adapter: RecyclerView.Adapter<A>, listener: EndlessRecyclerViewScrollListener? = null, decorator: RecyclerView.ItemDecoration? = null, isReverse: Boolean = false) {
    val layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, isReverse)
    this.adapter = adapter
    this.layoutManager = layoutManager
    listener?.let { it.setLayoutManager(layoutManager) }
    listener?.let { this.addOnScrollListener(listener) }
    decorator?.let { this.addItemDecoration(it) }
}
