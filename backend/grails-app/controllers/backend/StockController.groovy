package backend

import grails.rest.RestfulController

class StockController extends RestfulController {
    static responseFormats = ['json']

    StockController() {
        super(Stock)
    }
}
