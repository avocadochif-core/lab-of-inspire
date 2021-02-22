package com.lab.of.inspire.extensions

import android.app.Activity
import android.content.Context.INPUT_METHOD_SERVICE
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.lab.of.inspire.utils.InsetsUtils
import com.lab.of.inspire.utils.OnSystemBarsSizeChangedListener

fun AppCompatActivity.setWindowTransparency(listener: OnSystemBarsSizeChangedListener = { _, _ -> }) {
    InsetsUtils.removeSystemInsets(window.decorView, listener)
    window.navigationBarColor = Color.TRANSPARENT
    window.statusBarColor = Color.TRANSPARENT
}

var AppCompatActivity.windowLightStatusBar: Boolean
    get() = false
    set(value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val statusBarAppearance = if (value) WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS else 0
            val statusBarMask = WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
            window.insetsController?.setSystemBarsAppearance(statusBarAppearance, statusBarMask)
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val statusBarAppearance = if (value) View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR else 0
            window.decorView.systemUiVisibility = statusBarAppearance
        }
    }

fun AppCompatActivity.openActivity(activity: AppCompatActivity, extra: Bundle.() -> Unit = {}) {
    hideKeyboardForm()
    val intent = Intent(this, activity::class.java)
    intent.putExtras(Bundle().apply(extra))
    startActivity(intent)
}

fun AppCompatActivity.openActivityWithFinish(activity: AppCompatActivity) {
    val intent = Intent(this, activity::class.java)
    startActivity(intent)
    finish()
}

fun AppCompatActivity.hideKeyboardForm() {
    val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    val v = findViewById<View>(android.R.id.content)
    imm.hideSoftInputFromWindow(v.windowToken, 0)
}

fun AppCompatActivity.showKeyboard() {
    val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
}
