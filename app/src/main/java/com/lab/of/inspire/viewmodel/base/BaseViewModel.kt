package com.lab.of.inspire.viewmodel.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lab.of.inspire.extensions.execute
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

open class BaseViewModel: ViewModel() {

    /////////////////////////////////////////////////////////
    ///////////////// Live Data with getters ////////////////
    /////////////////////////////////////////////////////////

    private var _isLoadingLD = MutableLiveData<Boolean>()
    val isLoadingLD: LiveData<Boolean> get() = _isLoadingLD

    private var _isRefreshingLD = MutableLiveData<Boolean>()
    val isRefreshingLD: LiveData<Boolean> get() = _isRefreshingLD

    private var _showToastMessageByIdLD = MutableLiveData<Int>()
    val showToastMessageByIdLD: LiveData<Int> get() = _showToastMessageByIdLD

    private var _showToastMessageLD = MutableLiveData<String>()
    val showToastMessageLD: LiveData<String> get() = _showToastMessageLD

    private var _hideKeyboardLD = MutableLiveData<Unit>()
    val hideKeyboardLD: LiveData<Unit> get() = _hideKeyboardLD

    private var _showKeyboardLD = MutableLiveData<Unit>()
    val showKeyboardLD: LiveData<Unit> get() = _showKeyboardLD

    /////////////////////////////////////////////////////////
    /////////////////////// Variables ///////////////////////
    /////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////
    ///////////////////////// Calls /////////////////////////
    /////////////////////////////////////////////////////////

    fun showLoading() {
        if (_isLoadingLD.value != true) {
            _isLoadingLD.value = true
        }
    }

    fun hideLoading(delay: Long = 0) {
        viewModelScope.launch {
            delay(delay)
            _isLoadingLD.postValue(false)
        }
    }

    fun hideRefreshing() {
        _isRefreshingLD.value = false
    }

    fun showToastMessageById(messageId: Int) {
        _showToastMessageByIdLD.value = messageId
    }

    fun showToastMessage(message: String) {
        _showToastMessageLD.value = message
    }

    fun hideKeyboard() {
        _hideKeyboardLD.execute()
    }

    fun showKeyboard() {
        _showKeyboardLD.execute()
    }

    /**
     * Base method for handling the server error message which shows this message in toast
     * and hides progress bar dialog
     */
    fun basicServerErrorHandling(message: String) {
        showToastMessage(message)
        hideLoading()
        hideRefreshing()
    }

}