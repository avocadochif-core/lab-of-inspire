package com.lab.of.inspire.view.activity.onboarding

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isInvisible
import androidx.databinding.DataBindingUtil
import com.lab.of.inspire.BR
import com.lab.of.inspire.R
import com.lab.of.inspire.databinding.ActivityOnboardingBinding
import com.lab.of.inspire.extensions.bindData
import com.lab.of.inspire.extensions.init
import com.lab.of.inspire.extensions.obs
import com.lab.of.inspire.extensions.openActivityWithFinish
import com.lab.of.inspire.view.activity.base.BaseActivity
import com.lab.of.inspire.view.activity.home.MainActivity
import com.lab.of.inspire.view.viewpager.adapter.OnboardingAdapter
import com.lab.of.inspire.view.viewpager.callbacks.PageChangedCallback
import com.lab.of.inspire.viewmodel.onboarding.OnboardingViewModel

class OnboardingActivity : BaseActivity() {

    private val viewModel by viewModels<OnboardingViewModel>()
    private lateinit var binding: ActivityOnboardingBinding

    private val adapter = OnboardingAdapter()
    private val callback = PageChangedCallback { viewModel.onPageChanged(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_onboarding)
        binding.bindData(BR.viewModel, viewModel)

        initViews()
        initObservers()
        initListeners()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.onboardingVP.unregisterOnPageChangeCallback(callback)
    }

    private fun initViews() {
        initOnboardingVP()
    }

    private fun initObservers() {
        viewModel.onboardingPagesLD.obs(this) { adapter.updateData(it) }
        viewModel.navigateToMainFlowLD.obs(this) { openActivityWithFinish(MainActivity()) }
        viewModel.skipBtnInvisibilityLD.obs(this) { binding.skipTV.isInvisible = it }
        viewModel.getStartedBtnInvisibilityLD.obs(this) { binding.getStartedBTN.isInvisible = it }
    }

    private fun initListeners() {

    }

    private fun initOnboardingVP() {
        binding.onboardingVP.init(adapter, binding.pageIndicator, callback)
    }

}