package com.sklagat46.cashbacktestapp.utils

internal class Constants {
    companion object {
        const val SPLASH_SLEEP_TIME: Long = 2000
        const val SLEEP_TIME: Long = 1000
        const val BASE_URL_STAGING = "https://cashbacktest.s3.eu-west-2.amazonaws.com/"
        const val BASE_URL_RELEASE = "https://cashbacktest.s3.eu-west-2.amazonaws.com/"
        val SIMPLE_DATETIME_FORMAT = "YYYY-MM-DD"
        const val SIMPLE_DATE_TIME_FORMAT = "d MMM"
        const val SIMPLE_DATE_TIME_MS_FORMAT = "yyyy-MM-dd HH:mm:ss"
    }
}