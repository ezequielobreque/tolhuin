package tolhuin


class LogueoInterceptor {
	public LogueoInterceptor(){
		matchAll().excludes(controller: 'usuario', action: "save").excludes(controller: 'usuario', action: "show").excludes(controller: 'emprendimiento', action: "index").excludes(controller: 'map', action: "mapa").excludes(controller: 'usuario', action: "create").excludes(controller: 'login').excludes(controller:'main').excludes(controller:'grafico').excludes(controller:'emprendimiento',action:'show')
	}

    boolean before() {
    	if (!session.logeado){
    		redirect (controller: 'login', action:"login")
    		return false
    	}
    	true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}

