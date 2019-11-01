package tolhuin

import grails.plugin.springsecurity.userdetails.GrailsUser
import org.springframework.security.core.GrantedAuthority

class Usuario {
    String nick
    String apellido
    String nombre
    String tipo
    User user

    static hasMany=[emprendimientos:Emprendimiento]


    static constraints = {
    	nick unique:true
        apellido()
        nombre()
        tipo(inList:['administrador','municipalidad','emprendedor','investigador'])
        emprendimientos display:false, nullable: true
        user display :false,nullable: true


    }
}