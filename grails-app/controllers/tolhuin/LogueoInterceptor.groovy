package tolhuin


class LogueoInterceptor {
	public LogueoInterceptor(){
		matchAll().excludes(controller: 'login').excludes(controller:'main').excludes(controller:'grafico').excludes(controller:'emprendimiento',action:'show')
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

