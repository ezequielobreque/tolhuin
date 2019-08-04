package tolhuin


import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DetalleController {

    DetalleService detalleService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond detalleService.list(params), model:[detalleCount: detalleService.count()]
    }

    def show(Long id) {
        respond detalleService.get(id)
    }

    def create() {
        respond new Detalle(params)
    }

    def save(Detalle detalle) {
        if (detalle == null) {
            notFound()
            return
        }

        try {
            detalleService.save(detalle)
        } catch (ValidationException e) {
            respond detalle.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'detalle.label', default: 'Detalle'), detalle.id])
                redirect detalle
            }
            '*' { respond detalle, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond detalleService.get(id)
    }

    def update(Detalle detalle) {
        if (detalle == null) {
            notFound()
            return
        }

        try {
            detalleService.save(detalle)
        } catch (ValidationException e) {
            respond detalle.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'detalle.label', default: 'Detalle'), detalle.id])
                redirect detalle
            }
            '*'{ respond detalle, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        detalleService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'detalle.label', default: 'Detalle'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'detalle.label', default: 'Detalle'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
