package tolhuin

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured('ROLE_ANONYMOUS')
class UsuarioController {

    UsuarioService usuarioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond usuarioService.list(params), model:[usuarioCount: usuarioService.count()]
    }

    def show(Long id) {
        respond usuarioService.get(id)

    }

    def create() {

       respond new Usuario(params)



    }

    def save(Usuario usuario) {
        if (usuario == null) {
            notFound()
            return
        }

        try {
            def us = User.findOrSaveWhere(username: params.nick ,password: params.password)
            usuario.user=us
            print('llege')
            def role= Role.findByAuthority('ROLE_ADMIN');
            switch (usuario.tipo){
                case 'administrador' :role=Role.findByAuthority('ROLE_ADMIN');
                case 'municipalidad' : role =Role.findByAuthority('ROLE_MINISTERIO');
                case 'emprendedor' : role =Role.findByAuthority('ROLE_EMPRENDEDOR');
                case 'investigador' : role =Role.findByAuthority('ROLE_INVESTIGADOR');
                default : role = Role.findByAuthority('ROLE_EMPRENDEDOR');
            }
            usuarioService.save(usuario)
            print(usuario)
            us.setUsuario(usuario)
            UserRole.create(us,role,true)




        } catch (ValidationException e) {
            respond usuario.errors, view:'create'
            return
        }

        if (usuario!=null){

            if(usuario.tipo=='emprendedor'){

                flash.message = "Su usuario ha sido creado ahora ingrese los datos de su emprendimiento"

                redirect(controller: "Emprendimiento", action: "create")


            }else{redirect usuario}

        }else{
            flash.errorUsuario=true
        }
    }

    @Secured(['ROLE_ADMIN','ROLE_MINISTERIO','ROLE_ADMINISTRADOR'])
    def cambiarRol(){
        Usuario user=Usuario.findById(params.id)
        def role= Role.findByAuthority('ROLE_ADMIN')
        switch (user.tipo){
            case 'administrador' :role =Role.findByAuthority('ROLE_ADMIN');
            case 'municipalidad' : role =Role.findByAuthority('ROLE_MINISTERIO');
            case 'emprendedor' : role =Role.findByAuthority('ROLE_EMPRENDEDOR');
            case 'investigador' : role =Role.findByAuthority('ROLE_INVESTIGADOR');

        }
        def rl= Role.findByAuthority('ROLE_ADMIN')
        switch (params.tipo){
            case 'administrador' :rl=Role.findByAuthority('ROLE_ADMIN');
            case 'municipalidad' : rl =Role.findByAuthority('ROLE_MINISTERIO');
            case 'emprendedor' : rl =Role.findByAuthority('ROLE_EMPRENDEDOR');
            case 'investigador' : rl =Role.findByAuthority('ROLE_INVESTIGADOR');

        }
        UserRole userrole=UserRole.findByUserAndRole(user.user)
        userrole.setRole([rl])
       /* print(getAuthenticatedUser().getUsuario())*/


    }

    def edit(Long id) {
        respond usuarioService.get(id)
    }

    def update(Usuario usuario) {
        if (usuario == null) {
            notFound()
            return
        }

        try {
            usuarioService.save(usuario)
        } catch (ValidationException e) {
            respond usuario.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'usuario.label', default: 'Usuario'), usuario.id])
                redirect usuario
            }
            '*'{ respond usuario, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        usuarioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'usuario.label', default: 'Usuario'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuario.label', default: 'Usuario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
