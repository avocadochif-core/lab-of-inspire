package com.lab.of.inspire.viewmodel.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lab.of.inspire.datasource.sharedpreference.CorePreferences
import com.lab.of.inspire.enums.OnboardingPage
import com.lab.of.inspire.enums.OpenFlowType
import com.lab.of.inspire.extensions.execute
import com.lab.of.inspire.viewmodel.base.BaseViewModel
import com.lab.of.inspire.viewmodel.singleLiveEvent.SingleLiveEvent

class OnboardingViewModel : BaseViewModel() {

    /////////////////////////////////////////////////////////
    ///////////////// Live Data with getters ////////////////
    /////////////////////////////////////////////////////////

    private val _onboardingPagesLD = MutableLiveData<MutableList<OnboardingPage>>()
    val onboardingPagesLD: LiveData<MutableList<OnboardingPage>> get() = _onboardingPagesLD

    private val _getStartedBtnInvisibilityLD = MutableLiveData<Boolean>()
    val getStartedBtnInvisibilityLD: LiveData<Boolean> get() = _getStartedBtnInvisibilityLD

    private val _skipBtnInvisibilityLD = MutableLiveData<Boolean>()
    val skipBtnInvisibilityLD: LiveData<Boolean> get() = _skipBtnInvisibilityLD

    private val _navigateToMainFlowLD = SingleLiveEvent<Unit>()
    val navigateToMainFlowLD: LiveData<Unit> get() = _navigateToMainFlowLD

    /////////////////////////////////////////////////////////
    /////////////////////// Variables ///////////////////////
    /////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////
    ///////////////////////// Calls /////////////////////////
    /////////////////////////////////////////////////////////

    init {
        initOnboardingPages()
    }

    fun onSkipBtnClick() { navigateToNextFlow() }

    fun onGetStartedBtnClick() { navigateToNextFlow() }

    fun onPageChanged(position: Int) {
        _getStartedBtnInvisibilityLD.value = position != OnboardingPage.values().size - 1
        _skipBtnInvisibilityLD.value = position == OnboardingPage.values().size - 1
    }

    private fun initOnboardingPages() {
        _onboardingPagesLD.value = OnboardingPage.values().toMutableList()
    }

    private fun navigateToNextFlow() {
        CorePreferences.openFlowType = OpenFlowType.MAIN.name
        _navigateToMainFlowLD.execute()
    }

}