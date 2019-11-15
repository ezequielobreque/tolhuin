package tolhuin

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured(['ROLE_ADMIN','ROLE_MINISTERIO','ROLE_ADMINISTRADOR'])

class RubroController {

    RubroService rubroService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond rubroService.list(params), model:[rubroCount: rubroService.count()]
    }

    def show(Long id) {
        respond rubroService.get(id)
    }

    def create() {
        respond new Rubro(params)
    }

    def save(Rubro rubro) {
        if (rubro == null) {
            notFound()
            return
        }

        try {
            rubroService.save(rubro)
        } catch (ValidationException e) {
            respond rubro.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'rubro.label', default: 'Rubro'), rubro.id])
                redirect rubro
            }
            '*' { respond rubro, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond rubroService.get(id)
    }

    def update(Rubro rubro) {
        if (rubro == null) {
            notFound()
            return
        }

        try {
            rubroService.save(rubro)
        } catch (ValidationException e) {
            respond rubro.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'rubro.label', default: 'Rubro'), rubro.id])
                redirect rubro
            }
            '*'{ respond rubro, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        rubroService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'rubro.label', default: 'Rubro'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'rubro.label', default: 'Rubro'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
