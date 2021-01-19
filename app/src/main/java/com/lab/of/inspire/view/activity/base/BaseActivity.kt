package com.lab.of.inspire.view.activity.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lab.of.inspire.extensions.hideKeyboardForm

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    /**
     * Closing keyboard always when user click back button
     */
    override fun onBackPressed() {
        super.onBackPressed()
        hideKeyboardForm()
    }

}