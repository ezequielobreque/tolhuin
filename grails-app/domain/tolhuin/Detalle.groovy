package tolhuin
import grails.gorm.annotation.Entity
import grails.transaction.Rollback
import org.grails.orm.hibernate.HibernateDatastore
import org.springframework.transaction.PlatformTransactionManager
class Detalle {
    String nombre
    static belongsTo=[rubro:Rubro]

	String toString() {
    	nombre
    }

    static constraints = {
    
    }
}
