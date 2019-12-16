package tolhuin
import grails.gorm.annotation.Entity
import grails.transaction.Rollback
import org.grails.orm.hibernate.HibernateDatastore
import org.springframework.transaction.PlatformTransactionManager
import grails.validation.Validateable

class Emprendimiento {
    String nombre
    Double latitud
    Double longitud
    String direccion
    Boolean validado=false
    Boolean habilitado
    String foto
    Rubro rubro
    Ambito ambito
    long telefono
    String descripcion
    Usuario investigador
    byte[] featuredImageBytes
    String featuredImageContentType
    Usuario user
    String usuario
    int visitas=0
    static constraints = {

        nombre display:true,nullable: true ,unique:['direccion','usuario']
        usuario display:true,nullable: true
        user display:false,nullable: true
        latitud display: true, nullable:true
        longitud display: true, nullable:true
        descripcion display:true, nullable: true
        direccion nullable: true
        validado display: false, nullable:true
        habilitado nullable: true
        foto nullable: true, display:false
        rubro nullable: true
        ambito nullable: true
        telefono nullable: true
        //detalle nullable:true
        investigador display: false, nullable:true
        featuredImageBytes nullable: true
        featuredImageContentType nullable: true
        visitas nullable: true
    }
    static mapping = {
        featuredImageBytes column: 'featured_image_bytes', sqlType: 'longblob'

    }
}