package tolhuin

import grails.validation.Validateable

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
    int telefono
    //Detalle detalle
    String descripcion
    Usuario investigador
    byte[] featuredImageBytes
    String featuredImageContentType
    String usuario
    static constraints = {
        nombre display:true,nullable: true,unique:['direccion','usuario']
        usuario display:true,nullable: true,unique: ['direccion','nombre']
        latitud display: false, nullable:true
        longitud display: false, nullable:true
        descripcion display:true, nullable: true
        direccion nullable: true;
        validado display: false, nullable:true
        habilitado nullable: true;
        foto nullable: true, display:false
        rubro nullable: true
        ambito nullable: true
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