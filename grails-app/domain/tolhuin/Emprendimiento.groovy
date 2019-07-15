package tolhuin

class Emprendimiento {
    String nombre
    Double latitud
    Double longitud
    String direccion
    Boolean validado
    Boolean habilitado
    String foto
    Rubro rubro
    Ambito ambito
    Detalle detalle
    Usuario investigador
    
    static constraints = {
        nombre()
        latitud display: false, nullable:true
        longitud display: false, nullable:true
        direccion()
        validado display: false, nullable:true
        habilitado()
        foto nullable: true, display:false
        rubro()
        ambito()
        detalle nullable:true
        investigador display: false, nullable:true
    }
}