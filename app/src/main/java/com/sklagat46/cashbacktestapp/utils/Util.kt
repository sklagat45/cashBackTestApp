package com.sklagat46.cashbacktestapp.utils

import java.io.IOException
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

object Util {

    fun dateStringToReadableFullDate(dateformatString: String?): String {
        val originalFormat = SimpleDateFormat(Constants.SIMPLE_DATE_TIME_MS_FORMAT)
        val targetFormat =
            SimpleDateFormat(
                Constants.SIMPLE_DATE_TIME_FORMAT,
                Locale.getDefault()
            )
        var date: Date? = null
        return try {
            date = originalFormat.parse(dateformatString)
            """ ${targetFormat.format(date)}"""
        } catch (ex: IOException) {
            ex.printStackTrace()
            ""
        }
    }
    fun roundToDecimal(number: String):String{
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val roundoff = df.format(number)
        return roundoff
    }

}