package com.lab.of.inspire.view.fragment.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.CallSuper
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.lab.of.inspire.BR
import com.lab.of.inspire.extensions.bindData
import com.lab.of.inspire.extensions.obs
import com.lab.of.inspire.viewmodel.base.BaseViewModel
import org.jetbrains.anko.support.v4.toast

abstract class BaseFragment<VB: ViewDataBinding> : Fragment() {

    abstract val viewModel: BaseViewModel
    abstract val layoutResId: Int

    abstract fun initObservers()

    protected lateinit var binding: VB

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        binding.bindData(BR.viewModel, viewModel)
        return binding.root
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
        initBaseObservers()
        initListeners()
    }

    @CallSuper
    protected open fun initViews() {

    }

    private fun initBaseObservers() {
        viewModel.showToastMessageLD.obs(viewLifecycleOwner) { toast(it) }
        viewModel.showToastMessageByIdLD.obs(viewLifecycleOwner) { toast(it) }
    }

    @CallSuper
    protected open fun initListeners() {

    }

    protected fun hideKeyboardFrom(context: Context?, view: View) {
        (context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(view.windowToken, 0)
    }

    protected fun showKeyboardFor(context: Context?, view: View) {
        (context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).showSoftInput(view, InputMethodManager.SHOW_FORCED)
    }
}