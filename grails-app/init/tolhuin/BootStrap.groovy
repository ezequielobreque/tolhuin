package tolhuin

class BootStrap {

    def init = { servletContext ->
    	environments {
            development {
                cargar()
            }
        }
    }
    	
    
    def destroy = {
    }

    def cargar(){
    	new Usuario(nombre: "abc", apellido: "def",nick:"admin", tipo: "administrador", contrasena:"admin" ).save()
    	def primario=new Sector(nombre:"primario")
    	def secundario=new Sector(nombre:"secundario")
    	def terciario=new Sector(nombre:"terciario")
    	primario.save()
    	secundario.save()
    	terciario.save()
    	def publico=new Ambito(nombre: "público")
    	def privado=new Ambito(nombre: "privado")
    	publico.save()
    	privado.save()
    	def forestal=new Rubro(nombre:"forestal")
    	def panaderia=new Rubro(nombre: "panadería")
    	def horticola=new Rubro(nombre: "horticola")
    	def ganadero=new Rubro(nombre: "ganadero")
    	def polirrubro=new Rubro(nombre:"polirrubro")
    	def artesanias=new Rubro(nombre: "artesanias")
    	def carpinteria=new Rubro(nombre:"carpintería")
    	def gastronomico=new Rubro(nombre:"gastronomico")
    	forestal.save()
    	panaderia.save()
    	horticola.save()
    	ganadero.save()
    	polirrubro.save()
    	artesanias.save()
    	carpinteria.save()
    	gastronomico.save()
    	primario.addToRubros(forestal)
    	primario.addToRubros(horticola)
    	primario.addToRubros(ganadero)
    	primario.save()
    	secundario.addToRubros(artesanias)
    	secundario.addToRubros(carpinteria)
    	secundario.addToRubros(panaderia)
    	secundario.save()
    	terciario.addToRubros(polirrubro)
    	terciario.addToRubros(gastronomico)
    	terciario.save()
    	new Emprendimiento(nombre:"aserradero1", latitud: 1.1, longitud: 2.2, direccion:"abc 123", validado:true, habilitado:true,rubro:forestal, ambito:privado).save()
    	new Emprendimiento(nombre:"huerta a", latitud: 1.1, longitud: 2.2, direccion:"abc def", validado:true, habilitado:true,rubro:horticola, ambito:privado).save()
    	new Emprendimiento(nombre:"vacas", latitud: 1.1, longitud: 2.2, direccion:"zxc ef", validado:true, habilitado:true,rubro:ganadero, ambito:privado).save()
    	new Emprendimiento(nombre:"huerta b", latitud: 1.1, longitud: 2.2, direccion:"abc cda", validado:true, habilitado:true,rubro:horticola, ambito:privado).save()
    	new Emprendimiento(nombre:"artemania", latitud: 1.1, longitud: 2.2, direccion:"abc 123", validado:true, habilitado:true,rubro:artesanias, ambito:privado).save()
    	new Emprendimiento(nombre:"madera", latitud: 1.1, longitud: 2.2, direccion:"abc 123", validado:true, habilitado:true,rubro:carpinteria, ambito:privado).save()
    	new Emprendimiento(nombre:"centro de tolhuin", latitud: 1.1, longitud: 2.2, direccion:"abc 123", validado:true, habilitado:true,rubro:panaderia, ambito:privado).save()
    	new Emprendimiento(nombre:"polirubro abcde", latitud: 1.1, longitud: 2.2, direccion:"abc 123", validado:true, habilitado:true,rubro:polirrubro, ambito:privado).save()
    	new Emprendimiento(nombre:"restaurant", latitud: 1.1, longitud: 2.2, direccion:"abc 123", validado:true, habilitado:true,rubro:gastronomico, ambito:privado).save()

    }
}
