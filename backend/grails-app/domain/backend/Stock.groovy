package backend

import grails.rest.*

@Resource(uri = '/api/stocks')
class Stock {
    Integer price
    GregorianCalendar priceDate
    static belongsTo = [company: Company]
}
