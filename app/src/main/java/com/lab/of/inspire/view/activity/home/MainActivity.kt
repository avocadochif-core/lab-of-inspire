package com.lab.of.inspire.view.activity.home

import androidx.activity.viewModels
import com.lab.of.inspire.R
import com.lab.of.inspire.databinding.ActivityMainBinding
import com.lab.of.inspire.view.activity.base.BaseActivity
import com.lab.of.inspire.viewmodel.home.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val viewModel by viewModels<MainViewModel>()
    override val layoutResId: Int = R.layout.activity_main

    override fun initObservers() {

    }

}