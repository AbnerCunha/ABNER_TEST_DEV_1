package backend

import grails.rest.*

@Resource(uri = '/api/companies')
class Company {
    String name
    String segment
    static hasMany = [quotes: Stock]
}
