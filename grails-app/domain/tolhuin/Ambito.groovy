package tolhuin

class Ambito {
    String nombre

    String toString() {
    	nombre
    }
    
    static constraints = {
        nombre(blank: false)
    }
}
