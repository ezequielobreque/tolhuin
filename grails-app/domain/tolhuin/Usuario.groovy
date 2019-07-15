package tolhuin

class Usuario {
    String nick
    String apellido
    String nombre
    String tipo
    String contrasena
    static hasMany=[contactos: Contacto]
    
    static constraints = {
    	nick unique:true
        apellido()
        nombre()
        tipo(inList:['administrador','municipalidad','emprendedor','investigador'])
        contrasena password: true
        contactos nullable: true
    }
}
