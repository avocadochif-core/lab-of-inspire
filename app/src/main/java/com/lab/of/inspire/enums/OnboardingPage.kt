package com.lab.of.inspire.enums

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.lab.of.inspire.R

enum class OnboardingPage(@DrawableRes val imgResId: Int, @StringRes val titleResId: Int, @StringRes val descriptionResId: Int) {
    FIRST(R.drawable.ic_onboarding_page_1, R.string.onboarding_title_1, R.string.onboarding_description_1),
    SECOND(R.drawable.ic_onboarding_page_1, R.string.onboarding_title_2, R.string.onboarding_description_2),
    THIRD(R.drawable.ic_onboarding_page_1, R.string.onboarding_title_3, R.string.onboarding_description_3)
}