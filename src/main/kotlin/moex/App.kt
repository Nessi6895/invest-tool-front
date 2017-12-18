package moex

import utils.Constants.Companion.BOARDS
import utils.DateCreator.Companion.createDateString
import java.net.URL
import utils.Constants.Companion.ENGINE
import spark.Spark.*

fun main(args: Array<String>){
    val response = buildResponse()

    get("/quotes") { _, _ -> QuoteViewer.viewQuotes(response)}

}

fun buildResponse(): List<Quote> {
    val listBuilder: MutableList<Quote> = mutableListOf()
    BOARDS
            .map { ResponseParser.parse(URL("http://iss.moex.com/iss/history/engines/$ENGINE/markets/shares/boards/$it/securities.json?date=${createDateString()}").readText()) }
            .forEach { listBuilder.addAll(it) }
    return listBuilder.toList()
}