package adveritychallangebackend


import grails.rest.*
import grails.converters.*

class DatasourceController  extends RestfulController {
	static responseFormats = ['json', 'xml']

    DatasourceController() {
        super(Datasource)
    }

    def index() {
        respond Datasource.list()
    }
}
