package backend

import groovy.transform.CompileStatic

import java.text.SimpleDateFormat

@CompileStatic
class BootStrap {
    CompanyService companyService
    StockService stockService

    def init = { servletContext ->
        def dateNow = new GregorianCalendar(TimeZone.getTimeZone("GMT-3:00"))

        //System.out.print("\n")
        companyService.register("Subway", "Food", dateNow)
        companyService.register("Citi", "Bank", dateNow)
        companyService.register("Melitta", "Coffee", dateNow)
        //System.out.print("\n")

        stockService.getStock("Subway", 1)
    }
    def destroy = {
    }
}
