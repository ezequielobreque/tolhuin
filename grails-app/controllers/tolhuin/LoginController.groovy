package tolhuin

class LoginController {

	def logear(){
		def usr=Usuario.findByNickAndContrasena(params.usuario, params.password)
		if (usr!=null){
			session["logeado"]=true	
			session["tipo"]=usr.tipo
			redirect(action:"index", controller: "main")
			return
		}else{
				flash.errorUsuario=true
			}		
		render(view:"login")
	}
	def login(){}
	def logout() {

		session.logeado = false

		redirect(controller: "main")
	}

    def index() {}
}


