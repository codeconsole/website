package website

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SampleController {

    SampleService sampleService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sampleService.list(params), model:[sampleCount: sampleService.count()]
    }

    def show(Serializable id) {
        respond sampleService.get(id)
    }

    def create() {
        respond new Sample(params)
    }

    def save(Sample sample) {
        if (sample == null) {
            notFound()
            return
        }

        try {
            sampleService.save(sample)
        } catch (ValidationException e) {
            respond sample.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sample.label', default: 'Sample'), sample.id])
                redirect sample
            }
            '*' { respond sample, [status: CREATED] }
        }
    }

    def edit(Serializable id) {
        respond sampleService.get(id)
    }

    def update(Sample sample) {
        if (sample == null) {
            notFound()
            return
        }

        try {
            sampleService.save(sample)
        } catch (ValidationException e) {
            respond sample.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sample.label', default: 'Sample'), sample.id])
                redirect sample
            }
            '*'{ respond sample, [status: OK] }
        }
    }

    def delete(Serializable id) {
        if (id == null) {
            notFound()
            return
        }

        sampleService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sample.label', default: 'Sample'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sample.label', default: 'Sample'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
