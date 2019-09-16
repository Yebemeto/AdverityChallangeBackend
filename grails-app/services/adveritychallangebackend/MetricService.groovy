package adveritychallangebackend

import grails.gorm.transactions.Transactional

@Transactional
class MetricService {

    def search(List<Datasource> datasources, List<Campaign> campaigns){
        if(datasources&&campaigns){
           return Metric.findAllByDatasourceInList(datasources).intersect(Metric.findAllByCampaignInList(campaigns))
        }else{
            if(datasources){
                return Metric.findAllByDatasourceInList(datasources)
            }
            if(campaigns){
                return Metric.findAllByCampaignInList(campaigns)
            }
            Metric.list()
        }
    }
}
