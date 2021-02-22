package com.lab.of.inspire.extensions

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun <A : RecyclerView.ViewHolder>RecyclerView.initVertical(adapter: RecyclerView.Adapter<A>, decorator: RecyclerView.ItemDecoration? = null, isReverse: Boolean = false) {
    this.adapter = adapter
    layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, isReverse)
    decorator?.let { this.addItemDecoration(it) }
}
