package adveritychallangebackend


import java.text.SimpleDateFormat

class BootStrap {
    def grailsApplication
    def init = { servletContext ->
        def pattern = "dd.MM.yyyy"
       File csvFile = grailsApplication.mainContext.getResource("resources/metrics.csv").file
        csvFile.splitEachLine(',') {fields ->
            def domainObject = new Metric(
                    date: new SimpleDateFormat(pattern).parse(fields[0].trim()),
                    datasource: (Datasource.findByName(fields[1].trim()))?: new Datasource(name : fields[1].trim()).save(),
                    campaign: (Campaign.findByName(fields[2].trim()))?: new Campaign(name : fields[2].trim()).save(),
                    clicks: (fields[3]) ?  fields[3].trim().toInteger() : 0,
                    impressions: (fields[4]) ?  fields[4].trim().toInteger() : 0
            )

        domainObject.save();
        }

    }
    def destroy = {
    }
}
