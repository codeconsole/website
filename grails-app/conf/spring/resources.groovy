import org.grails.datastore.mapping.simple.SimpleMapDatastore

// Place your Spring DSL code here
beans = {
    simpleMapDatastore(SimpleMapDatastore, grailsApplication.mainContext)
    simpleDomainClassMappingContext(simpleMapDatastore:"getMappingContext")
}