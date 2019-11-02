package tolhuin
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.authentication.AnonymousAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder


@Secured(['ROLE_ANONYMOUS','ROLE_ADMIN','ROLE_MINISTERIO','ROLE_INVESTIGADOR','ROLE_ADMINISTRADOR','ROLE_EMPRENDEDOR'])

class MainController {

    def index() {
    	respond Emprendimiento.list()

		/*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			Usuario us=authenticatedUser.getUsuario()

		}*/




		/*if (!(auth instanceof AnonymousAuthenticationToken)) {

			print(name)
		}*/


	}
	def index2(){

	}
}
