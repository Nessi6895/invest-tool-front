package moex

import com.beust.klaxon.*

class ResponseParser {
    companion object {
        fun parse(response: String): List<FullQuote> {
            val json = Parser().parse(StringBuilder(response)) as JsonObject
            val history = json.obj("history") ?: throw RuntimeException("History is null")
            val dataArray = history.array<JsonArray<Any?>>("data") ?: throw RuntimeException("Data is null")
            return dataArray.map { it.map { if(it is Double? || it is Int?) it?.toString() ?: "0" else it?.toString() ?: "null"} }.map { FullQuote.parseJson(it) }
        }
        fun getNumOfQuotes(response: String): Int = getDataList(response)[1]

        fun getNumOfQuotesOnPage(response: String):Int = getDataList(response)[2]

        private fun getDataList(response: String):List<Int> {
            val json = Parser().parse(StringBuilder(response)) as JsonObject
            val historyCursor = json.obj("history.cursor") ?: throw RuntimeException("\"history.cursor\" field is null")
            return (historyCursor.array<JsonArray<Int>>("data")?.get(0) ?: throw RuntimeException("Data field is null")).toList()
        }
    }
}