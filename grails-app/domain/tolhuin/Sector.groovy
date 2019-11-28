package tolhuin
import grails.gorm.annotation.Entity
import grails.transaction.Rollback
import org.grails.orm.hibernate.HibernateDatastore
import org.springframework.transaction.PlatformTransactionManager
class Sector {
    String nombre
    static hasMany=[rubros: Rubro]
    
     
    String toString() {
    	nombre
    }

    static constraints = {
    	rubros display: false
    }
}
