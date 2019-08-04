package tolhuin
class Emprendimiento  {
    String nombre
    Double latitud
    Double longitud
    String direccion
    Boolean validado
    Boolean habilitado
    String foto
    Rubro rubro
    Ambito ambito
    int telefono
    //Detalle detalle
    Usuario investigador
    byte[] featuredImageBytes
    String featuredImageContentType
    String usuario;
    static constraints = {
        nombre()
        usuario display:false,nullable: true
        latitud display: false, nullable:true
        longitud display: false, nullable:true
        direccion()
        validado display: false, nullable:true
        habilitado()
        foto nullable: true, display:false
        rubro()
        ambito()
        telefono nullable: true
        //detalle nullable:true
        investigador display: false, nullable:true
        featuredImageBytes nullable: true
        featuredImageContentType nullable: true
    }
    static mapping = {
        featuredImageBytes column: 'featured_image_bytes', sqlType: 'longblob'
    }
}