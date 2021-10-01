package com.byjus.jetpack.paging

import java.text.SimpleDateFormat
import java.util.*

private const val serverDateFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'"
const val formatYearFirst = "yyyy-MM-dd"

object DateUtils {

    fun getPublishedDate(date: String?): String{
        if (date.isNullOrEmpty()){
            return ""
        }
       return transformDateFormat(date, serverDateFormat, formatYearFirst) ?:  ""
    }

    fun transformDateFormat(fromDate: String, fromPattern: String, toPattern: String): String? {
        return try {
            var toDate: String? = null
            val from = SimpleDateFormat(fromPattern, Locale.US).parse(fromDate)
            from?.let { toDate = SimpleDateFormat(toPattern, Locale.US).format(from) }
            toDate
        } catch (ex: Exception) {
            null
        }
    }
}