package com.lab.of.inspire.view.activity.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.lab.of.inspire.BR
import com.lab.of.inspire.R
import com.lab.of.inspire.databinding.ActivityMainBinding
import com.lab.of.inspire.extensions.bindData
import com.lab.of.inspire.viewmodel.home.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.bindData(BR.viewModel, viewModel)

        initViews()
        initObservers()
        initListeners()
    }

    private fun initViews() {

    }

    private fun initObservers() {

    }

    private fun initListeners() {

    }

}