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



		/*if (!(auth instanceof AnonymousAuthenticationToken)) {

			print(name)
		}*/


	}
	def Emprendimientos() {

		List<Emprendimiento> Emp=Emprendimiento.findAllByValidado(true)


		Emp.sort{y,x->x.visitas<=>y.visitas}
		List<Emprendimiento> Emp2=[]
		for(int i = 0; i < 8; i++) {
			Emp2.add(Emp.get(i))
		}
		[Emp:Emp2]

		/*User us=authenticatedUser
            print(	us.getAuthorities())*/





		/*if (!(auth instanceof AnonymousAuthenticationToken)) {

			print(name)
		}*/


	}
	def index2(){

	}
}
