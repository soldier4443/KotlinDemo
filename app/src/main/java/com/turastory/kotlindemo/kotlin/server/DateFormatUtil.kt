@file:JvmName("DateFormatUtil")

package com.turastory.kotlindemo.kotlin.server

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Util class - @file:JvmName, @JvmStatic, @JvmField, @JvmOverloads, extension functions
 */
const val DAY_IN_MILLIS = 24 * 60 * 60 * 1000

@JvmField
var date: DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA)
@JvmField
var day: DateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA)

@JvmOverloads
fun getDate(year: Int, month: Int, date: Int, hour: Int = 0, minute: Int = 0, second: Int = 0): Date {
    val cal = Calendar.getInstance()
    cal.set(year, month - 1, date, hour, minute, second)
    cal.set(Calendar.MILLISECOND, 0)
    return cal.time
}

fun String.parseDay(): Date {
    return day.parse(this)
}

fun Date.dayAfter(day: Int): Date {
    return Date(this.time + day * DAY_IN_MILLIS)
}

operator fun Date.plus(day: Int): Date {
    return Date(this.time + day * DAY_IN_MILLIS)
}

fun Date.dayBefore(day: Int): Date {
    return Date(this.time - day * DAY_IN_MILLIS)
}

operator fun Date.minus(day: Int): Date {
    return Date(this.time - day * DAY_IN_MILLIS)
}
