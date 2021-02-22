package com.lab.of.inspire.view.activity.home

import androidx.activity.viewModels
import com.lab.of.inspire.R
import com.lab.of.inspire.databinding.ActivityMainBinding
import com.lab.of.inspire.entity.photo.Photo
import com.lab.of.inspire.extensions.initVertical
import com.lab.of.inspire.extensions.obs
import com.lab.of.inspire.extensions.setWindowTransparency
import com.lab.of.inspire.extensions.windowLightStatusBar
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
        initInsets()
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

    private fun initInsets() {
        windowLightStatusBar = false
        setWindowTransparency { statusBarSize, navigationBarSize -> }
    }

    private fun initPhotosRV() {
        binding.photosRV.initVertical(adapter, endlessRVScrollListener, VerticalItemDecorator(0, 1))
    }

    override fun onPhotoClick(photo: Photo) {

    }

}