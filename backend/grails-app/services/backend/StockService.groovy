package backend

import grails.gorm.transactions.Transactional
import org.springframework.stereotype.Service

@Service('stockService')
@Transactional
class StockService {

    def addStockQuote(Integer stockPrice, GregorianCalendar stockPriceDate) {
        new Stock( price: stockPrice, priceDate: stockPriceDate)
    }

    def getStock(String nameCompany, Integer hrUntilNow) {
        long now = System.currentTimeMillis(); // Get time to see what was spent in the end
        Company[] results = Company.findAllByName(nameCompany)
        Stock[] stocks = results[0].quotes
        def lastQuotes = hrUntilNow * 60 // Get the last quotes per minutes from the hours received as argument

        System.out.print("\n\nCompany: " + results[0].name + "\n")
        System.out.print("\nQuotes retrieved: " + lastQuotes + "\n\n")

        stocks.eachWithIndex { Stock entry, int i ->
            if (i < lastQuotes) {
                System.out.print("Stock quote number " + (i + 1) + ": " + entry.price + "\n")
            }
        }

        System.out.print("\nTotal time: " + (System.currentTimeMillis() - now) + " ms")

        System.out.print("\n\n\n\n")
    }

    def serviceMethod() {

    }
}
