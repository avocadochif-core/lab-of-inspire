package com.lab.of.inspire.viewmodel.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lab.of.inspire.enums.OnboardingPage
import com.lab.of.inspire.extensions.execute
import com.lab.of.inspire.viewmodel.base.BaseViewModel

class OnboardingViewModel : BaseViewModel() {

    /////////////////////////////////////////////////////////
    ///////////////// Live Data with getters ////////////////
    /////////////////////////////////////////////////////////

    private val _onboardingPagesLD = MutableLiveData<MutableList<OnboardingPage>>()
    val onboardingPagesLD: LiveData<MutableList<OnboardingPage>> get() = _onboardingPagesLD

    private val _skipBtnClickedLD = MutableLiveData<Unit>()
    val skipBtnClickedLD: LiveData<Unit> get() = _skipBtnClickedLD

    private val _getStartedBtnClickedLD = MutableLiveData<Unit>()
    val getStartedBtnClickedLD: LiveData<Unit> get() = _getStartedBtnClickedLD

    private val _getStartedBtnInvisibilityLD = MutableLiveData<Boolean>()
    val getStartedBtnInvisibilityLD: LiveData<Boolean> get() = _getStartedBtnInvisibilityLD

    private val _skipBtnInvisibilityLD = MutableLiveData<Boolean>()
    val skipBtnInvisibilityLD: LiveData<Boolean> get() = _skipBtnInvisibilityLD

    /////////////////////////////////////////////////////////
    /////////////////////// Variables ///////////////////////
    /////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////
    ///////////////////////// Calls /////////////////////////
    /////////////////////////////////////////////////////////

    init {
        _onboardingPagesLD.value = OnboardingPage.values().toMutableList()
    }

    fun onSkipBtnClick() { _skipBtnClickedLD.execute() }

    fun onGetStartedBtnClick() { _getStartedBtnClickedLD.execute() }

    fun onPageChanged(position: Int) {
        _getStartedBtnInvisibilityLD.value = position != OnboardingPage.values().size - 1
        _skipBtnInvisibilityLD.value = position == OnboardingPage.values().size - 1
    }

}