package tolhuin

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured('ROLE_ANONYMOUS')
class UsuarioController {

    UsuarioService usuarioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    @Secured(['ROLE_ADMIN','ROLE_MINISTERIO','ROLE_ADMINISTRADOR'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond usuarioService.list(params), model:[usuarioCount: usuarioService.count()]
    }
    @Secured(['ROLE_ADMIN','ROLE_MINISTERIO','ROLE_ADMINISTRADOR'])
    def show(Long id) {
        respond usuarioService.get(id)

    }
    @Secured(['ROLE_ANONYMOUS','ROLE_ADMIN','ROLE_ADMINISTRADOR'])
    def create() {

       respond new Usuario(params)



    }
    @Secured(['ROLE_ADMIN','ROLE_MINISTERIO','ROLE_ADMINISTRADOR','ROLE_EMPRENDEDOR','ROLE_INVESTIGADOR'])
    def misEmprendimientos(){

        Usuario us=getAuthenticatedUser().getUsuario()
        def lista= us.emprendimientos

        [lista:lista]
    }

    @Secured(['ROLE_ANONYMOUS','ROLE_ADMIN','ROLE_MINISTERIO','ROLE_ADMINISTRADOR','ROLE_EMPRENDEDOR','ROLE_INVESTIGADOR'])
    def ayuda(){

    }
    @Secured(['ROLE_ANONYMOUS','ROLE_ADMIN','ROLE_MINISTERIO','ROLE_ADMINISTRADOR'])
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
                case 'administrador' :role= Role.findByAuthority('ROLE_ADMIN');break;
                case 'municipalidad' : role = Role.findByAuthority('ROLE_MINISTERIO');break;
                case 'emprendedor' : role = Role.findByAuthority('ROLE_EMPRENDEDOR');break;
                case 'investigador' : role = Role.findByAuthority('ROLE_INVESTIGADOR');break;
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

                redirect(controller:"main",action: "index")

        }else{
            flash.errorUsuario=true
        }
    }


    /*def cambiarRol(){
        Usuario usuario=Usuario.findById(params.id)

        def rl= Role.findByAuthority(user.user.getAuthorities())
        User user = User.get(usuario.user)
        user.user.setAuthorities(rl)
        print(user.user.getAuthorities())


    }*/


    def springSecurityService
    @Secured(['ROLE_ADMIN','ROLE_MINISTERIO','ROLE_ADMINISTRADOR'])
    def cambiarRol(){

        User user = User.get(springSecurityService.principal.id) //get the user
        User nuevo= new User(username: '' ,password: '')
        nuevo.properties=User.get(springSecurityService.principal.id).properties
        Role adminRole = Role.findByAuthority('ROLE_ADMIN')
        UserRole.remove user, adminRole // remove admin Role

        Role userRole = Role.findByAuthority('ROLE_ADMINISTRADOR')
                UserRole.create user,userRole  //add the user Role


        if (!user.hasErrors() && user.save(flush: true)) {
            springSecurityService.reauthenticate user.username // refresh the users security deatils
        }
    }


    @Secured(['ROLE_ADMIN','ROLE_ADMINISTRADOR'])
    def edit(Long id) {
        respond usuarioService.get(id)
    }
    @Secured(['ROLE_ADMIN','ROLE_ADMINISTRADOR'])
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
