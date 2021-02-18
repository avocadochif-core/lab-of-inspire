package com.lab.of.inspire.view.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.lab.of.inspire.R
import com.lab.of.inspire.extensions.obs
import com.lab.of.inspire.extensions.openActivityWithFinish
import com.lab.of.inspire.view.activity.home.MainActivity
import com.lab.of.inspire.view.activity.onboarding.OnboardingActivity
import com.lab.of.inspire.viewmodel.SplashViewModel

class SplashActivity : AppCompatActivity() {

    private val viewModel by viewModels<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        initViews()
        initObservers()
        initListeners()
    }

    private fun initViews() {

    }

    private fun initObservers() {
        viewModel.openDefaultFlowLD.obs(this) { openActivityWithFinish(MainActivity()) }
        viewModel.openOnboardingFlowLD.obs(this) { openActivityWithFinish(OnboardingActivity()) }
    }

    private fun initListeners() {

    }

}