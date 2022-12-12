package com.aib.assessment.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Converts Kelvin to celsius.
 * @receiver - Kelvin
 * @return - celsius
 */
fun Double.kelvinToCelsius(): Int {
    return (this - 273.15).toInt()
}

fun Int.convertTimestampToDateTimeString(): String {
    try {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = this * 1000.toLong()
        val outputDateFormat = SimpleDateFormat("dd MMM, yyyy - hh:mm a", Locale.ENGLISH)
        outputDateFormat.timeZone = TimeZone.getDefault()
        return outputDateFormat.format(calendar.time)

    } catch (e: Exception) {
        e.printStackTrace()
    }

    return this.toString()
}

fun Int.convertTimestampToTimeString(): String {
    try {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = this * 1000.toLong()
        val outputDateFormat = SimpleDateFormat("hh:mm a", Locale.ENGLISH)
        outputDateFormat.timeZone = TimeZone.getDefault()
        return outputDateFormat.format(calendar.time)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return this.toString()
}