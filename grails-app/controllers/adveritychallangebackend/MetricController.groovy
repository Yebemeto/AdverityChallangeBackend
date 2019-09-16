package adveritychallangebackend


import grails.rest.*
import grails.converters.*

class MetricController extends RestfulController {
    def MetricService
	static responseFormats = ['json', 'xml']

    MetricController() {
        super(Metric)
    }

    def index() {
        respond Metric.list()
    }

    def search(SearchRequest request) {
        respond metricService.search(request.datasources, request.campaigns)
    }
}
