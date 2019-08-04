package tolhuin


class EmprendimientoInterceptor {

    public EmprendimientoInterceptor(){
        match(controller:'emprendimiento',action:'edit')
    }

    boolean before() { if(session["tipo"]=="administrador" ||session["tipo"]=="municipalidad"){
        return true

    }else{
        flash.message = "No tiene permisos para acceder a esta opcion"
        redirect(controller: 'emprendimiento', action:"index")
        return false
    }



      }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
