package com.lab.of.inspire.view.activity.onboarding

import androidx.activity.viewModels
import androidx.core.view.isInvisible
import com.lab.of.inspire.R
import com.lab.of.inspire.databinding.ActivityOnboardingBinding
import com.lab.of.inspire.extensions.init
import com.lab.of.inspire.extensions.obs
import com.lab.of.inspire.extensions.openActivityWithFinish
import com.lab.of.inspire.view.activity.base.BaseActivity
import com.lab.of.inspire.view.activity.home.MainActivity
import com.lab.of.inspire.view.viewpager.adapter.OnboardingAdapter
import com.lab.of.inspire.view.viewpager.callbacks.PageChangedCallback
import com.lab.of.inspire.viewmodel.onboarding.OnboardingViewModel

class OnboardingActivity : BaseActivity<ActivityOnboardingBinding>() {

    override val viewModel by viewModels<OnboardingViewModel>()
    override val layoutResId: Int = R.layout.activity_onboarding

    private val adapter = OnboardingAdapter()
    private val callback = PageChangedCallback { viewModel.onPageChanged(it) }

    override fun onDestroy() {
        super.onDestroy()
        binding.onboardingVP.unregisterOnPageChangeCallback(callback)
    }

    override fun initViews() {
        super.initViews()
        initOnboardingVP()
    }

    override fun initObservers() {
        viewModel.onboardingPagesLD.obs(this) { adapter.updateData(it) }
        viewModel.skipBtnInvisibilityLD.obs(this) { binding.skipTV.isInvisible = it }
        viewModel.navigateToDefaultFlowLD.obs(this) { openActivityWithFinish(MainActivity()) }
        viewModel.getStartedBtnInvisibilityLD.obs(this) { binding.getStartedBTN.isInvisible = it }
    }

    private fun initOnboardingVP() {
        binding.onboardingVP.init(adapter, binding.pageIndicator, callback)
    }

}