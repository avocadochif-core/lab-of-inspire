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
    private const val OPEN_FLOW_TYPE = "open.flow.type"

    private lateinit var preferences: SharedPreferences

    //Init class in Application class
    fun init(context: Context) {
        preferences = context.getSharedPreferences(CORE_PREFERENCES, Context.MODE_PRIVATE)
    }

    fun clearData() {
        preferences.edit(true) {
            remove(IS_USER_LOGGED)
            remove(OPEN_FLOW_TYPE)
        }
    }

    var isUserLogged
        get() = preferences.getBoolean(IS_USER_LOGGED, false)
        set(value) = preferences.edit().putBoolean(IS_USER_LOGGED, value).apply()

    var openFlowType
        get() = preferences.getString(OPEN_FLOW_TYPE, null)
        set(value) = preferences.edit().putString(OPEN_FLOW_TYPE, value).apply()

}