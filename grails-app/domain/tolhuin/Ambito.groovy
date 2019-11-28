package tolhuin
import grails.gorm.annotation.Entity
import grails.transaction.Rollback
import org.grails.orm.hibernate.HibernateDatastore
import org.springframework.transaction.PlatformTransactionManager
class Ambito {
    String nombre

    String toString() {
    	nombre
    }
    
    static constraints = {
        nombre(blank: false)
    }
}
