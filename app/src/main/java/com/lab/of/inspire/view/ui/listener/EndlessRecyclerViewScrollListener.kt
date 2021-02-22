package com.lab.of.inspire.view.ui.listener

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EndlessRecyclerViewScrollListener : RecyclerView.OnScrollListener() {

    private var isLoading: Boolean = false
    private var isLastPage: Boolean = false
    private var visibleThreshold: Int = 5
    private var linearLayoutManager: LinearLayoutManager? = null

    var funLoadMoreItems: () -> Unit = { }

    fun setIsLoading(isLoading: Boolean) {
        this.isLoading = isLoading
    }

    fun setVisibleThreshold(visibleThreshold: Int) {
        this.visibleThreshold = visibleThreshold
    }

    fun setIsLastPage(isLastPage: Boolean) {
        this.isLastPage = isLastPage
    }

    fun setLayoutManager(layoutManager: LinearLayoutManager) {
        this.linearLayoutManager = layoutManager
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        linearLayoutManager?.let {
            if (!isLoading && !isLastPage && (it.findLastCompletelyVisibleItemPosition() + visibleThreshold) > it.itemCount) {
                funLoadMoreItems()
            }
        }
    }


}