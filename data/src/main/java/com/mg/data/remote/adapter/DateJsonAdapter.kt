package com.mg.data.remote.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateJsonAdapter {

    @FromJson
    fun fromJson(date: String): Date? {
        try {
            return SimpleDateFormat(DEFAULT_FORMAT, Locale.US).parse(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return null
    }

    @ToJson
    fun toJson(date: Date): String {
        return SimpleDateFormat(DEFAULT_FORMAT, Locale.US).format(date)
    }

    companion object {
        const val DEFAULT_FORMAT = "yyyy-MM-dd"
    }
}