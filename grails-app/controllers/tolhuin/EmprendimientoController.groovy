package tolhuin

import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.authentication.AnonymousAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder

import javax.xml.bind.ValidationException

import static org.springframework.http.HttpStatus.*
@Secured(['ROLE_ANONYMOUS','ROLE_ADMIN','ROLE_MINISTERIO','ROLE_INVESTIGADOR','ROLE_ADMINISTRADOR','ROLE_EMPRENDEDOR'])
class EmprendimientoController {

    EmprendimientoService emprendimientoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def visitante() {
        respond emprendimientoService.list()
    }
    def busqueda(String buscar,String rubro,String ambito,String sector ,String actions) {


            if(actions == 'mapa'){
                redirect(controller:"map",action: "mapa",params: [buscar:buscar,rubro:rubro,ambito:ambito,sector:sector])
            }else if(actions =='filtro'){

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
        }  else {

        }





    }
    @Secured(['ROLE_ADMIN','ROLE_MINISTERIO','ROLE_ADMINISTRADOR'])
    def FiltrosEspeciales(String id,String rubro,String ambito,String sector ,String dni,Boolean sinDni,String direccion,Boolean sinDireccion,String local,Boolean sinLocal,String dueno,Boolean sinDueno,Boolean solo){

            def amb = Ambito.findByNombreLike('%' + ambito + '%')
            def rub = Rubro.findByNombreLike('%' + rubro + '%')

            def sec = Sector.findByNombreLike('%' + sector + '%')
            def dniX
            if (dni != null) {
                dniX = Usuario.findByDniLike(dni.toLong())
            }
            def idx
            if(id!=''){
                idx=id
            }
            print(sinDni)
        List<Emprendimiento> List = Emprendimiento.findAllByNombreLike('%' + local + '%')
        if (solo==false) {

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
            if (amb != null) {

                List = List.findAll { it.ambito == amb }

            }


            if (rub != null) {
                List = List.findAll { it.rubro == rub }

            }
            if (sec != null) {


                print(List.rubro.sector.nombre)
                List = List.findAll { it.rubro.sector.nombre == sec.nombre }

            }
            if (direccion != null) {

                List = List.findAll { it.direccion =~ direccion }
            }
            if (dueno != null) {

                List = List.findAll { it.usuario =~ dueno }
            }


            if (sinDni) {
                List = List.findAll { it.user == null }
            }

            if (dniX != null) {

                List = List.findAll {
                    if (it.user != null) {
                        it.user == dniX
                    }
                }

            }
            if (sinDueno) {
                List = List.findAll { it.usuario == null }
            }
            if (sinDireccion) {
                List = List.findAll { it.direccion == null }
            }
            if(idx!=null){
                List=Emprendimiento.findAllById(idx)
            }
        }
        else{
            if (sinDni){
                List=Emprendimiento.findAllByUser(null)
            }
            if (sinDireccion){
                List=Emprendimiento.findAllByDireccion(null)
            }
            if (sinDueno){
                List=Emprendimiento.findAllByUsuario(null)
            }




        }




        [list:List]




    }
    @Secured(['ROLE_ANONYMOUS','ROLE_ADMIN','ROLE_MINISTERIO','ROLE_INVESTIGADOR','ROLE_ADMINISTRADOR','ROLE_EMPRENDEDOR'])
    def index() {

     def List=emprendimientoService.list()
        [list:List]
    }

    def show(Long id) {
        def N= Emprendimiento.get(id).visitas
        emprendimientoService.get(id).visitas=N+1
        emprendimientoService.save(emprendimientoService.get(id))
        respond emprendimientoService.get(id)
    }
    @Secured(['ROLE_ADMIN','ROLE_MINISTERIO','ROLE_INVESTIGADOR','ROLE_ADMINISTRADOR','ROLE_EMPRENDEDOR'])
    def create() {
        Emprendimiento emp= new Emprendimiento(params)
       /* print(params.latitud)
        emp.setLatitud(params.latitud as Double)
        emp.setLongitud(params.longitud as Double)*/
        respond emp
    }
    @Secured(['ROLE_ADMIN','ROLE_MINISTERIO','ROLE_INVESTIGADOR','ROLE_ADMINISTRADOR','ROLE_EMPRENDEDOR'])
    def save(Emprendimiento emprendimiento) {
        if (emprendimiento == null) {
            notFound()
            return
        }

        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (!(authentication instanceof AnonymousAuthenticationToken)) {



                emprendimiento.setUser(authenticatedUser.getUsuario())
                Usuario us= Usuario.findById((authenticatedUser.getUsuario().id))
                if(!(emprendimiento.user==us)){
                us.addToEmprendimientos(emprendimiento)}
                emprendimientoService.save(emprendimiento)




            }


        } catch (ValidationException e) {
            respond emprendimiento.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'emprendimiento.label', default: 'Emprendimiento'), emprendimiento.nombre])
                redirect emprendimiento
            }
            '*' { respond emprendimiento, [status: CREATED] }
        }
    }
    @Secured(['ROLE_ADMIN','ROLE_MINISTERIO','ROLE_INVESTIGADOR','ROLE_ADMINISTRADOR','ROLE_EMPRENDEDOR'])
    def edit(Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {


            Usuario us=getAuthenticatedUser().getUsuario()
            if (us.emprendimientos.contains(emprendimientoService.get(id))||us.user.authorities.contains(Role.findByAuthority("ROLE_ADMIN"))||us.user.authorities.contains(Role.findByAuthority("ROLE_MINISTERIO"))) {
                respond emprendimientoService.get(id)
            }else {
                flash.message =
                redirect (controller: "emprendimiento",action: "show",id:id)
            }
        }

    }

    @Secured(['ROLE_ADMIN','ROLE_MINISTERIO','ROLE_INVESTIGADOR','ROLE_ADMINISTRADOR','ROLE_EMPRENDEDOR'])
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
                flash.message = message(code: 'default.updated.message', args: [message(code: 'emprendimiento.label', default: 'Emprendimiento'), emprendimiento.nombre])
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
                redirect controller: "main", action:"index"
            }
            '*'{ render status: NO_CONTENT }
        }
    }
    @Secured(['ROLE_ADMIN','ROLE_MINISTERIO','ROLE_INVESTIGADOR','ROLE_ADMINISTRADOR','ROLE_EMPRENDEDOR'])
    def editFeaturedImage(Long id) {
        Emprendimiento emprendi = emprendimientoService.get(id)
        if (!emprendi) {
            notFound()
        }
        [emprendimiento: emprendi]
    }
    @Secured(['ROLE_ADMIN','ROLE_MINISTERIO','ROLE_INVESTIGADOR','ROLE_ADMINISTRADOR','ROLE_EMPRENDEDOR'])
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
    @Secured(['ROLE_ANONYMOUS','ROLE_ADMIN','ROLE_MINISTERIO','ROLE_INVESTIGADOR','ROLE_ADMINISTRADOR','ROLE_EMPRENDEDOR'])
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

    @Secured(['ROLE_ADMIN','ROLE_USER'])
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
