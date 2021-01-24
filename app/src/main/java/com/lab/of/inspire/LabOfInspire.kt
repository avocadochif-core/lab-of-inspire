package com.lab.of.inspire

import android.app.Application
import com.lab.of.inspire.datasource.sharedpreference.CorePreferences

class LabOfInspire : Application() {

    override fun onCreate() {
        super.onCreate()
        init()
    }

    //Init all general instances here (Preferences, Facebook, Branch.io, Firebase etc.)
    private fun init() {
        CorePreferences.init(applicationContext)
    }

}