package website

import grails.core.GrailsApplication
import grails.core.GrailsClass
import org.grails.core.artefact.DomainClassArtefactHandler
import org.grails.datastore.mapping.keyvalue.mapping.config.KeyValueMappingContext
import org.grails.datastore.mapping.model.MappingContext
import org.grails.datastore.mapping.simple.SimpleMapDatastore
import org.springframework.beans.factory.annotation.Autowire
import org.springframework.beans.factory.annotation.Autowired

class BootStrap {

    GrailsApplication grailsApplication
    SimpleMapDatastore simpleMapDatastore

    def init = { servletContext ->

        // https://gorm.grails.org/latest/developer/manual/index.html
        def domainClasses = grailsApplication.getArtefacts(DomainClassArtefactHandler.TYPE)
                .collect() { GrailsClass cls -> simpleMapDatastore.mappingContext.addPersistentEntity(cls.clazz)  }
        simpleMapDatastore.connect()

        def s = new Sample(prop1: "Hello", prop2: 123, prop3: new Date())
        s.save(flush:true, failOnError:true)
        println "${s.id} ${Sample.count()} ${Sample.get(1)}"
    }
    def destroy = {
    }
}