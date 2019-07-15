package tolhuin

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EmprendimientoController {

    EmprendimientoService emprendimientoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
    respond emprendimientoService.list()
    }

    def show(Long id) {
        respond emprendimientoService.get(id)
    }

    def create() {
        respond new Emprendimiento(params)
    }

    def save(Emprendimiento emprendimiento) {
        if (emprendimiento == null) {
            notFound()
            return
        }

        try {
            emprendimientoService.save(emprendimiento)
        } catch (ValidationException e) {
            respond emprendimiento.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'emprendimiento.label', default: 'Emprendimiento'), emprendimiento.id])
                redirect emprendimiento
            }
            '*' { respond emprendimiento, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond emprendimientoService.get(id)
    }

    def update(Emprendimiento emprendimiento) {
        if (emprendimiento == null) {
            notFound()
            return
        }

        try {
            emprendimientoService.save(emprendimiento)
        } catch (ValidationException e) {
            respond emprendimiento.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'emprendimiento.label', default: 'Emprendimiento'), emprendimiento.id])
                redirect emprendimiento
            }
            '*'{ respond emprendimiento, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        emprendimientoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'emprendimiento.label', default: 'Emprendimiento'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'emprendimiento.label', default: 'Emprendimiento'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
