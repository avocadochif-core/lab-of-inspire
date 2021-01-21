package com.lab.of.inspire.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lab.of.inspire.R
import com.lab.of.inspire.extensions.openActivityWithFinish
import com.lab.of.inspire.view.activity.onboarding.OnboardingActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openActivityWithFinish(OnboardingActivity())
    }
}