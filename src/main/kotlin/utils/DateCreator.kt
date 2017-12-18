package utils

import java.util.*

class DateCreator {
    companion object {
        fun createDateString(): String {
            val calendar = Calendar.getInstance()
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val month = calendar.get(Calendar.MONTH)
            val year = calendar.get(Calendar.YEAR)
            return year.toString() + "-" + (month + 1).toString() + "-" + (day - 3).toString()
        }
    }
}