package tolhuin
import grails.gorm.annotation.Entity
import grails.transaction.Rollback
import org.grails.orm.hibernate.HibernateDatastore
import org.springframework.transaction.PlatformTransactionManager
import grails.plugin.springsecurity.userdetails.GrailsUser
import org.springframework.security.core.GrantedAuthority

class Usuario {
    String nick
    long dni
    String apellido
    String nombre
    String tipo
    User user

    static hasMany=[emprendimientos:Emprendimiento]


    static constraints = {
    	nick unique:true
        apellido()
        nombre()
        dni display:true,nullable:true
        tipo(inList:['administrador','municipalidad','emprendedor','investigador'])
        emprendimientos display:false, nullable: true
        user display :false,nullable: true


    }
}