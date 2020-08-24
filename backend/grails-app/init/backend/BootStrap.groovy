package backend

import groovy.transform.CompileStatic

@CompileStatic
class BootStrap {
    CompanyService companyService
    StockService stockService

    def init = { servletContext ->
        def dateNow = new GregorianCalendar(TimeZone.getTimeZone("GMT-3:00"))

        companyService.register("Subway", "Food", dateNow)
        companyService.register("Citi", "Bank", dateNow)
        companyService.register("Melitta", "Coffee", dateNow)

        stockService.getStock("Subway", 1)
    }
    def destroy = {
    }
}
