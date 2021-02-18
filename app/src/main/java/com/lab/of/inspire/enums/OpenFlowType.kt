package com.lab.of.inspire.enums

/**
 * Enum class present all possible flows for application opening
 */
enum class OpenFlowType {

    /**
     * Opens OnboardingActivity when application was opened first time
     */
    ONBOARDING,

    /**
     * Opens MainActivity when user already watched onboarding
     */
    DEFAULT

}