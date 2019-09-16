package adveritychallangebackend

import grails.rest.Resource


class Metric {

    Date date
    Integer clicks
    Integer impressions

    static belongsTo = [campaign:Campaign, datasource:Datasource]
    static constraints = {
    }
    static namedQueries = {
        hasDatasource { dsNamesList ->
            datasource {
                    or {
                        dsNamesList.each {
                            eq('title', it)
                        }
                    }
            }
        }
    }

}
