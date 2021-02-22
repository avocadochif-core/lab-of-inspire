package com.lab.of.inspire.view.activity.home

import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lab.of.inspire.R
import com.lab.of.inspire.databinding.ActivityMainBinding
import com.lab.of.inspire.entity.photo.Photo
import com.lab.of.inspire.extensions.obs
import com.lab.of.inspire.view.activity.base.BaseActivity
import com.lab.of.inspire.view.recyclerview.adapter.PhotosAdapter
import com.lab.of.inspire.view.recyclerview.decorator.VerticalItemDecorator
import com.lab.of.inspire.view.ui.listener.EndlessRecyclerViewScrollListener
import com.lab.of.inspire.viewmodel.home.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding>(), PhotosAdapter.PhotosListener {

    override val viewModel by viewModels<MainViewModel>()
    override val layoutResId: Int = R.layout.activity_main

    private val adapter = PhotosAdapter(this)
    private val endlessRVScrollListener = EndlessRecyclerViewScrollListener()

    override fun initViews() {
        super.initViews()
        initPhotosRV()
    }

    override fun initObservers() {
        viewModel.photosLD.obs(this) { adapter.addData(it) }
        viewModel.isLastPageLD.obs(this) { endlessRVScrollListener.setIsLastPage(it) }
        viewModel.paginationLoadingLD.obs(this) { endlessRVScrollListener.setIsLoading(it) }
    }

    override fun initListeners() {
        super.initListeners()
        endlessRVScrollListener.funLoadMoreItems = { viewModel.getPhotos() }
    }

    private fun initPhotosRV() {
        val lm = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        endlessRVScrollListener.setLayoutManager(lm)
        with(binding.photosRV) {
            layoutManager = lm
            this.adapter = this@MainActivity.adapter
            addOnScrollListener(endlessRVScrollListener)
            addItemDecoration(VerticalItemDecorator(0, 1))
        }
    }

    override fun onPhotoClick(photo: Photo) {

    }

}