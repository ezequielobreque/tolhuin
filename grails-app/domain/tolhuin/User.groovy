package tolhuin

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    String username
    String password
    boolean enabled = true
    Usuario usuario
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }
    void setAuthorities(Role rol) {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role=rol
    }

    static constraints = {
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
        usuario nullable: true

    }
    Usuario getUsuario(){
        return this.usuario

    }
    void setUsuario(Usuario us){
        this.usuario=us
        us.setUser(this)

    }

    static mapping = {
	    password column: '`password`'
    }
}
