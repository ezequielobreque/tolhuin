package tolhuin


import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EmprendimientoController {

    EmprendimientoService emprendimientoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def visitante() {
        respond emprendimientoService.list()
    }
    def busqueda(String buscar,String rubro,String ambito,String sector) {

        def amb=Ambito.findByNombreLike('%'+ambito+'%')
        def rub=Rubro.findByNombreLike('%'+rubro+'%')

        def sec=Sector.findByNombreLike('%'+sector+'%')
        print (sec)
        def List=Emprendimiento.findAllByNombreLike('%' + buscar + '%')
        /*if (amb!=null && rub!=null) {

            List = Emprendimiento.findAllByNombreLikeAndAmbitoAndRubro('%' + buscar + '%', amb, rub)
        }else
            if(amb!=null&& rub==null){

                List = Emprendimiento.findAllByNombreLikeAndAmbito('%' + buscar + '%', amb)
            }
        else if(rub!=null && amb==null){

                List = Emprendimiento.findAllByNombreLikeAndRubro('%' + buscar + '%', rub)

            }else if(rub==null && amb==null)
                {

                    List = Emprendimiento.findAllByNombreLike('%' + buscar + '%')

                }*/
        if (amb!=null){
            List=List.findAll { it.ambito == amb }

        }
        if (rub!=null){
            List=List.findAll { it.rubro == rub }

        }
        if (sec!=null) {


            print(List.rubro.sector.nombre)
          List=List.findAll { it.rubro.sector.nombre == sec.nombre }

        }


        [list:List]



    }

    def index() {
    respond emprendimientoService.list()
    }

    def show(Long id) {
        respond emprendimientoService.get(id)
    }

    def create(String tipo) {

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

    def editFeaturedImage(Long id) {
        Emprendimiento emprendi = emprendimientoService.get(id)
        if (!emprendi) {
            notFound()
        }
        [emprendimiento: emprendi]
    }

    def uploadFeaturedImage(FeaturedImageCommand cmd) {
        if (cmd == null) {
            notFound()
            return
        }

        if (cmd.hasErrors()) {
            respond(cmd.errors, model: [emprendimiento: cmd], view: 'editFeaturedImage')
            return
        }

        Emprendimiento emprendimiento = emprendimientoService.update(cmd.id,
                cmd.version,
                cmd.featuredImageFile.bytes,
                cmd.featuredImageFile.contentType)

        if (emprendimiento == null) {
            notFound()
            return
        }

        if (emprendimiento.hasErrors()) {
            respond(emprendimiento.errors, model: [emprendimiento: emprendimiento], view: 'editFeaturedImage')
            return
        }

        //Locale locale = request.locale
        //flash.message = crudMessageService.message(CRUD.UPDATE, domainName(locale), cmd.id, locale)
        redirect emprendimiento
    }
    def featuredImage(Long id) {
        Emprendimiento emprendimiento = emprendimientoService.get(id)
        if (!emprendimiento || emprendimiento.featuredImageBytes == null) {
            notFound()
            return
        }
        render file: emprendimiento.featuredImageBytes,
                contentType: emprendimiento.featuredImageContentType
    }

    def exportService


    def export() {

        if (!params.max) params.max = 10

        if (params?.format && params.format != "html") {
            response.contentType = grailsApplication.config.grails.mime.types[params.format]
            response.setHeader("Content-disposition", "attachment; filename=books.${params.extension}")


            /* String
                Double
                Double longitud
                String direccion
                Boolean validado
                Boolean habilitado
                String foto
                Rubro rubro
                Ambito ambito
                int telefono
                //Detalle detalle
                String descripcion
                Usuario investigador
                byte[] featuredImageBytes
                String featuredImageContentType
                String */
            List fields = ['nombre', "usuario", "direccion"]
            Map labels = ["nombre": "Nombre", "usuario": "Usuario", "direccion": "Direccion"]

            /* Formatter closure in previous releases
                def upperCase = { value ->
                    return value.toUpperCase()
                }
                */

            // Formatter closure
            def upperCase = { domain, value ->
                return value.toUpperCase()
            }

            Map formatters = [nombre: upperCase]

            exportService.export(params.format, response.outputStream, Emprendimiento.list(params), fields, labels, formatters)
        }

        [bookInstanceList: Emprendimiento.list(params)]

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
