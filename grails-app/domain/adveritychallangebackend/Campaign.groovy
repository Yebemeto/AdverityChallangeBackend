package adveritychallangebackend

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Campaign {
    String name

    static hasMany = [metrics:Metric]
    static constraints = {
        name unique: true
    }
}
