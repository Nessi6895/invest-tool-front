package moex

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import utils.Constants
import utils.Constants.Companion.BOARDS
import utils.DateCreator
import java.net.URL

class ResponseCreator {
    companion object {
        private val mapper = ObjectMapper().registerModule(KotlinModule())
        private fun getAllQuotesFromMoex(): List<FullQuote>{
            val listBuilder: MutableList<FullQuote> = mutableListOf()
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
            val quotes = (0 until list.size).map { ShortQuote(it, list[it].shortName) }
            return mapper.writeValueAsString(quotes)
        }

        fun getQuoteByID(id: Int): String {
            val fullQuote = getAllQuotesFromMoex()[id]
            val quote = Quote(id, fullQuote.shortName, "TO BE IMPLEMENTED", fullQuote.legalClosePrice)
            return mapper.writeValueAsString(quote)
        }
    }
}