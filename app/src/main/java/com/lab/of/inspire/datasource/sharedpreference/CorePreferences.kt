package com.lab.of.inspire.datasource.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

/**
 * Class which works with shared preferences and contains all keys
 */
object CorePreferences {

    private const val CORE_PREFERENCES = "com.lab.of.inspire.core.preferences"

    private const val IS_USER_LOGGED = "is.user.logged"

    private lateinit var preferences: SharedPreferences

    //Init class in Application class
    fun init(context: Context) {
        preferences = context.getSharedPreferences(CORE_PREFERENCES, Context.MODE_PRIVATE)
    }

    fun clearData() {
        preferences.edit(true) {
            remove(IS_USER_LOGGED)
        }
    }

    var isUserLogin
        get() = preferences.getBoolean(IS_USER_LOGGED, false)
        set(value) = preferences.edit().putBoolean(IS_USER_LOGGED, value).apply()

}