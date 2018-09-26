@file:JvmName("DeviceConfiguration")

package com.turastory.kotlindemo.kotlin.app

import android.content.Context
import android.content.res.Configuration

/**
 * Util class - Extension functions
 */
fun Context.isTablet(): Boolean {
    val xlarge = screenConfig() == Configuration.SCREENLAYOUT_SIZE_XLARGE
    val large = screenConfig() == Configuration.SCREENLAYOUT_SIZE_LARGE
    return xlarge || large
}

private fun Context.screenConfig(): Int {
    return this.config().screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK
}

private fun Context.config(): Configuration {
    return this.applicationContext.resources.configuration
}