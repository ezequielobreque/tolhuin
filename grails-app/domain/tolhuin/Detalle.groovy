package tolhuin

class Detalle {
    String nombre
    static belongsTo=[rubro:Rubro]

	String toString() {
    	nombre
    }

    static constraints = {
    
    }
}
