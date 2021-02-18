package com.lab.of.inspire.viewmodel

import androidx.lifecycle.LiveData
import com.lab.of.inspire.datasource.sharedpreference.CorePreferences
import com.lab.of.inspire.enums.OpenFlowType
import com.lab.of.inspire.enums.OpenFlowType.ONBOARDING
import com.lab.of.inspire.enums.OpenFlowType.DEFAULT
import com.lab.of.inspire.extensions.execute
import com.lab.of.inspire.viewmodel.base.BaseViewModel
import com.lab.of.inspire.viewmodel.singleLiveEvent.SingleLiveEvent

class SplashViewModel : BaseViewModel() {

    /////////////////////////////////////////////////////////
    ///////////////// Live Data with getters ////////////////
    /////////////////////////////////////////////////////////

    private val _openOnboardingFlowLD = SingleLiveEvent<Unit>()
    val openOnboardingFlowLD: LiveData<Unit> get() = _openOnboardingFlowLD

    private val _openDefaultFlowLD = SingleLiveEvent<Unit>()
    val openDefaultFlowLD: LiveData<Unit> get() = _openDefaultFlowLD

    /////////////////////////////////////////////////////////
    /////////////////////// Variables ///////////////////////
    /////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////
    ///////////////////////// Calls /////////////////////////
    /////////////////////////////////////////////////////////

    init {
        navigateToNextFlow()
    }

    private fun navigateToNextFlow() {
        CorePreferences.openFlowType?.let {
            when (OpenFlowType.valueOf(it)) {
                ONBOARDING -> _openOnboardingFlowLD.execute()
                DEFAULT -> _openDefaultFlowLD.execute()
            }
        } ?: kotlin.run { _openOnboardingFlowLD.execute() }
    }

}