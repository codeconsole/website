package website

import grails.core.GrailsApplication
import grails.core.GrailsClass
import org.grails.core.artefact.DomainClassArtefactHandler
import org.grails.datastore.mapping.simple.SimpleMapDatastore

class BootStrap {

    GrailsApplication grailsApplication

    def init = { servletContext ->

        // https://gorm.grails.org/latest/developer/manual/index.html
        def simple = new SimpleMapDatastore(grailsApplication.getMainContext())
        def domainClasses = grailsApplication.getArtefacts(DomainClassArtefactHandler.TYPE)
                .collect() { GrailsClass cls -> simple.mappingContext.addPersistentEntity(cls.clazz)  }

        def s = new Sample(prop1: "Hello", prop2: 123, prop3: new Date())
        s.save(flush:true, failOnError:true)
        println "${s.id} ${Sample.count()} ${Sample.get(1)}"

        return simple.connect()

    }
    def destroy = {
    }
}