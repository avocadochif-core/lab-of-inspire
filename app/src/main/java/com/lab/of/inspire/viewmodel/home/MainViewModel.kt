package com.lab.of.inspire.viewmodel.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lab.of.inspire.entity.photo.Photo
import com.lab.of.inspire.networking.Result
import com.lab.of.inspire.networking.repository.PhotoRepository
import com.lab.of.inspire.viewmodel.base.BaseViewModel
import com.lab.of.inspire.viewmodel.singleLiveEvent.SingleLiveEvent
import kotlinx.coroutines.launch

class MainViewModel : BaseViewModel() {

    /////////////////////////////////////////////////////////
    ///////////////// Live Data with getters ////////////////
    /////////////////////////////////////////////////////////

    private val _photosLD = SingleLiveEvent<List<Photo>>()
    val photosLD: LiveData<List<Photo>> get() = _photosLD

    private val _isLastPageLD = MutableLiveData<Boolean>()
    val isLastPageLD: LiveData<Boolean> get() = _isLastPageLD

    private val _paginationLoadingLD = MutableLiveData<Boolean>()
    val paginationLoadingLD: LiveData<Boolean> get() = _paginationLoadingLD

    /////////////////////////////////////////////////////////
    /////////////////////// Variables ///////////////////////
    /////////////////////////////////////////////////////////

    private var page: Int = 1

    /////////////////////////////////////////////////////////
    ///////////////////////// Calls /////////////////////////
    /////////////////////////////////////////////////////////

    init {
        getPhotos()
    }

    fun getPhotos() {
        changeProgressState(true)
        viewModelScope.launch {
            when (val result = PhotoRepository.getPhotos(page)) {
                is Result.Success -> handlePhotosResponse(result.data)
                is Result.Error -> basicServerErrorHandling(result.apiError.message)
            }
        }
    }

    private fun handlePhotosResponse(photos: List<Photo>) {
        page++
        hideLoading()
        hideRefreshing()
        changeProgressState(false)
        checkLastPage(photos)
        _photosLD.value = photos
    }

    private fun checkLastPage(photos: List<Photo>) {
        _isLastPageLD.value = photos.isEmpty()
    }

    private fun changeProgressState(state: Boolean) {
        _paginationLoadingLD.value = state
    }

}