package tolhuin

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
