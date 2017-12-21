package moex

import spark.Spark.*

fun main(args: Array<String>){

    get("/quotes") { _, _ -> ResponseCreator.getJSONResponseAll() }
    get("/quotes/:id") { req, _ -> ResponseCreator.getQuoteByID(req.params(":id").toInt())}

}