package moex

import utils.*

class QuoteViewer {
    companion object {
        fun viewQuotes(quotes: List<FullQuote>): String {
            return html {
                table {
                    tr {
                        td {
                            text("BOARDID")
                        }
                        td {
                            text("DATE")
                        }
                        td {
                            text("SHORTNAME")
                        }
                        td {
                            text("SECID")
                        }
                        td {
                            text("NUMTRADES")
                        }
                        td {
                            text("VALUE")
                        }
                        td {
                            text("OPEN")
                        }
                        td {
                            text("LOW")
                        }
                        td {
                            text("HIGH")
                        }
                        td {
                            text("LEGALCLOSEPRICE")
                        }
                        td {
                            text("WAPRICE")
                        }
                        td {
                            text("CLOSE")
                        }
                        td {
                            text("VOLUME")
                        }
                        td {
                            text("MARKETPRICE2")
                        }
                        td {
                            text("MARKETPRICE3")
                        }
                        td {
                            text("ADMITTEDQUOTE")
                        }
                        td {
                            text("MP2VALTRD")
                        }
                        td {
                            text("MARKETPRICE3TRADESVALUE")
                        }
                        td {
                            text("ADMITTEDVALUE")
                        }
                        td {
                            text("WAVAL")
                        }
                    }
                    for (quote in quotes){
                        tr{
                            td {
                                text(quote.boardID)
                            }
                            td {
                                text(quote.date)
                            }
                            td {
                                text(quote.shortName)
                            }
                            td {
                                text(quote.secID)
                            }
                            td {
                                text(quote.numOfTrades)
                            }
                            td {
                                text(quote.value)
                            }
                            td {
                                text(quote.open)
                            }
                            td {
                                text(quote.low)
                            }
                            td {
                                text(quote.high)
                            }
                            td {
                                text(quote.legalClosePrice)
                            }
                            td {
                                text(quote.waPrice)
                            }
                            td {
                                text(quote.close)
                            }
                            td {
                                text(quote.volume)
                            }
                            td {
                                text(quote.marketPrice2)
                            }
                            td {
                                text(quote.marketPrice3)
                            }
                            td {
                                text(quote.admittedQuote)
                            }
                            td {
                                text(quote.mp2ValTrd)
                            }
                            td {
                                text(quote.marketPrice3TradesValue)
                            }
                            td {
                                text(quote.admittedValue)
                            }
                            td {
                                text(quote.waVal)
                            }
                        }
                    }
                }
            }.toString()
        }
    }
}