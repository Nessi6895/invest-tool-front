package moex

import com.beust.klaxon.json
import utils.Constants
import utils.Constants.Companion.BOARDS
import utils.DateCreator
import java.net.URL

class ResponseCreator {
    companion object {
        private fun getAllQuotesFromMoex(): List<Quote>{
            val listBuilder: MutableList<Quote> = mutableListOf()
            for (board in BOARDS) {
                val initResponse = URL("http://iss.moex.com/iss/history/engines/${Constants.ENGINE}/markets/shares/boards/$board/securities.json?date=${DateCreator.createDateString()}").readText()
                val numOfQuotes = ResponseParser.getNumOfQuotes(initResponse)
                val numOfQuotesOnPage = ResponseParser.getNumOfQuotesOnPage(initResponse)
                (0..numOfQuotes step numOfQuotesOnPage)
                        .map { URL("http://iss.moex.com/iss/history/engines/${Constants.ENGINE}/markets/shares/boards/$board/securities.json?date=${DateCreator.createDateString()}&start=$it").readText() }
                        .map { ResponseParser.parse(it) }
                        .forEach { listBuilder.addAll(it) }
            }
            return listBuilder.toList()
        }
        fun getJSONResponseAll(): String {
            val list = getAllQuotesFromMoex()
            return json {
                array(listOf(0..(list.size - 1)).flatten().map {
                    obj("id" to it, "name" to list[it].shortName)
                })
            }.toJsonString()
        }

        fun getQuoteByID(id: Int): String {
            val all = getAllQuotesFromMoex()
            return json {
                obj("id" to id,
                        "name" to all[id].shortName,
                        "issuerName" to "TO BE IMPLEMENTED",
                        "lastPrice" to all[id].legalClosePrice)
            }.toJsonString()
        }
    }
}