package moex

class FullQuote(val boardID: String,
            val date: String,
            val shortName: String,
            val secID: String,
            val numOfTrades: Double,
            val value: Double,
            val open: Double,
            val low: Double,
            val high: Double,
            val legalClosePrice: Double,
            val waPrice: Double,
            val close: Double,
            val volume: Double,
            val marketPrice2: Double,
            val marketPrice3: Double,
            val admittedQuote: Double,
            val mp2ValTrd: Double,
            val marketPrice3TradesValue: Double,
            val admittedValue: Double,
            val waVal: Double) {

    companion object {
        fun parseJson(listOfParams: List<String>): FullQuote {
            return FullQuote(listOfParams[0],
                    listOfParams[1],
                    listOfParams[2],
                    listOfParams[3],
                    listOfParams[4].toDouble(),
                    listOfParams[5].toDouble(),
                    listOfParams[6].toDouble(),
                    listOfParams[7].toDouble(),
                    listOfParams[8].toDouble(),
                    listOfParams[9].toDouble(),
                    listOfParams[10].toDouble(),
                    listOfParams[11].toDouble(),
                    listOfParams[12].toDouble(),
                    listOfParams[13].toDouble(),
                    listOfParams[14].toDouble(),
                    listOfParams[15].toDouble(),
                    listOfParams[16].toDouble(),
                    listOfParams[17].toDouble(),
                    listOfParams[18].toDouble(),
                    listOfParams[19].toDouble())
        }
    }

    override fun toString(): String {
        return "FullQuote(boardID='$boardID', date=$date, shortName='$shortName', secID='$secID', numOfTrades=$numOfTrades, value=$value, open=$open, low=$low, high=$high, legalClosePrice=$legalClosePrice, waPrice=$waPrice, close=$close, volume=$volume, marketPrice2=$marketPrice2, marketPrice3=$marketPrice3, admittedQuote=$admittedQuote, mp2ValTrd=$mp2ValTrd, marketPrice3TradesValue=$marketPrice3TradesValue, admittedValue=$admittedValue, waVal=$waVal)"
    }

}