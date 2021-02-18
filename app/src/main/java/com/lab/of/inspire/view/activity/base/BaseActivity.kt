package com.lab.of.inspire.view.activity.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.lab.of.inspire.BR
import com.lab.of.inspire.extensions.bindData
import com.lab.of.inspire.extensions.hideKeyboardForm
import com.lab.of.inspire.extensions.obs
import com.lab.of.inspire.view.dialog.ProgressDialog
import com.lab.of.inspire.viewmodel.base.BaseViewModel
import org.jetbrains.anko.toast

abstract class BaseActivity<VB: ViewDataBinding> : AppCompatActivity() {

    abstract val viewModel: BaseViewModel
    abstract val layoutResId: Int

    abstract fun initObservers()

    protected lateinit var binding: VB
    private lateinit var progressDialog: ProgressDialog

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResId)
        binding.bindData(BR.viewModel, viewModel)

        initViews()
        initObservers()
        initBaseObservers()
        initListeners()
    }

    @CallSuper
    protected open fun initViews() {
        progressDialog = ProgressDialog(this)
    }

    private fun initBaseObservers() {
        viewModel.hideKeyboardLD.obs(this) { hideKeyboardForm() }
        viewModel.showToastMessageLD.obs(this) { toast(it) }
        viewModel.showToastMessageByIdLD.obs(this) { toast(it) }
    }

    @CallSuper
    protected open fun initListeners() {

    }

    protected fun handleProgressDialogState(isLoading: Boolean) {
        progressDialog.changeProgressState(isLoading)
    }
    /**
     * Closing keyboard always when user click back button
     */
    override fun onBackPressed() {
        super.onBackPressed()
        hideKeyboardForm()
    }

}