package tolhuin


import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AmbitoController {

    AmbitoService ambitoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ambitoService.list(params), model:[ambitoCount: ambitoService.count()]
    }

    def show(Long id) {
        respond ambitoService.get(id)
    }

    def create() {
        respond new Ambito(params)
    }

    def save(Ambito ambito) {
        if (ambito == null) {
            notFound()
            return
        }

        try {
            ambitoService.save(ambito)
        } catch (ValidationException e) {
            respond ambito.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'ambito.label', default: 'Ambito'), ambito.id])
                redirect ambito
            }
            '*' { respond ambito, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond ambitoService.get(id)
    }

    def update(Ambito ambito) {
        if (ambito == null) {
            notFound()
            return
        }

        try {
            ambitoService.save(ambito)
        } catch (ValidationException e) {
            respond ambito.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ambito.label', default: 'Ambito'), ambito.id])
                redirect ambito
            }
            '*'{ respond ambito, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        ambitoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ambito.label', default: 'Ambito'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'ambito.label', default: 'Ambito'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
