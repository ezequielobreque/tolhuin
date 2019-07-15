package tolhuin

class Sector {
    String nombre
    static hasMany=[rubros: Rubro]
    
     
    String toString() {
    	nombre
    }

    static constraints = {
    	rubros display: false
    }
}
