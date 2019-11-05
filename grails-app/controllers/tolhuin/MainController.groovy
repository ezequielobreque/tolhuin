package tolhuin
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.authentication.AnonymousAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder


@Secured(['ROLE_ANONYMOUS','ROLE_ADMIN','ROLE_MINISTERIO','ROLE_INVESTIGADOR','ROLE_ADMINISTRADOR','ROLE_EMPRENDEDOR'])

class MainController {

    def index() {


			/*User us=authenticatedUser
				print(	us.getAuthorities())*/

		print(Usuario.get(1).emprendimientos)



		/*if (!(auth instanceof AnonymousAuthenticationToken)) {

			print(name)
		}*/


	}
	def Emprendimientos() {
		respond Emprendimiento.list()

		/*User us=authenticatedUser
            print(	us.getAuthorities())*/






		/*if (!(auth instanceof AnonymousAuthenticationToken)) {

			print(name)
		}*/


	}
	def index2(){

	}
}
