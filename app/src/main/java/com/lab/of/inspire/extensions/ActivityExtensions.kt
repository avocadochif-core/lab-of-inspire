package com.lab.of.inspire.extensions

import android.app.Activity
import android.content.Context.INPUT_METHOD_SERVICE
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity

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
