package tolhuin
import grails.gorm.annotation.Entity
import grails.transaction.Rollback
import org.grails.orm.hibernate.HibernateDatastore
import org.springframework.transaction.PlatformTransactionManager
class Rubro {
    String nombre ;
    static hasMany=[detalles:Detalle]
    static belongsTo=[sector:Sector]

    String toString() {
    	nombre
    }
    
    static constraints = {
    	detalles display: false

    }
}
