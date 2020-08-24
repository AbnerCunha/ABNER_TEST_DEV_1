package backend

import grails.gorm.transactions.Transactional
import org.springframework.stereotype.Service

import java.util.concurrent.TimeUnit

@Service('companyService')
@Transactional
class CompanyService {

    StockService stockService

    def register(String companyName, String companySegment, GregorianCalendar dateNow ) {
        def hours = dateNow.get(dateNow.HOUR_OF_DAY)
        def minutes = dateNow.get(dateNow.MINUTE)
        def manyQuotes

        if (hours > 18 || (hours == 18 && minutes > 0)) { //Number of quotes for every business minute of the past 30 days, counting the past business minutes of today
            manyQuotes = (8 * 60 + 1) * 2 //é 30
        } else if (hours < 10) { //Number of quotes for every business minute of the past 30 days, but today doesn't enter the counting because it's not business time yet
            manyQuotes = (8 * 60 + 1) * 1 //é 29
        } else { //Number of quotes for every business minute of the past 30 days, counting the today's current business minutes
            manyQuotes = (8 * 60 + 1) * 1 //é 29
            for (int x = 10; x <= hours; x++) {
                if (x == hours) {
                    manyQuotes = manyQuotes + minutes + 1
                } else {
                    manyQuotes = manyQuotes + 60
                }
            }
        }

        def comp = new Company( name: companyName, segment: companySegment)

        manyQuotes.times {
            def randomNum = (Math.random() * 100).intValue()
            comp.addToQuotes(stockService.addStockQuote(randomNum, dateNow))
        }

        comp.save(flush: true)

    }
}
