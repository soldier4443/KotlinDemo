package com.turastory.kotlindemo.kotlin.server

import java.util.*

/**
 * Util class - object, @JvmStatic, extension functions, operator overloading
 */
object FreeEventChecker {
    @JvmStatic
    fun checkRegistrationTimeBefore(registerTime: Date, currentTime: Date): Boolean {
        if (currentTime < registerTime)
            throw IllegalArgumentException("current time < register time")

        // 5월 16일 이전에 가입했고, 가입한지 2주일이 안 됬으면 true
        return registerTime < getDate(2018, 5, 16, 23, 59, 59) &&
            currentTime < registerTime + 14
    }
}
