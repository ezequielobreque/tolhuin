package tolhuin
import groovy.json.JsonSlurper

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

/*
		//String fileName = "c:\\dev\\HEAD\\plugins\\excel-import\\test\\projects\\sample\\test-data\\books.xls"


		File f = new File('C:/Users/ezequiel_o/Downloads/localization.json')

*/
		/*
		String fileName ="C:\\Users\\ezequiel_o\\Desktop\\Laboratorio de Software 2017\\Integración_bases - PvA - Copy.xlsx"
		EmprendimientoExcelImporter importer = new EmprendimientoExcelImporter(fileName);

		def empsMapList = importer.getEmps()
		println empsMapList

		empsMapList.each { Map empParams ->
			def newEmp = new Emprendimiento(empParams)
			if (!newEmp.save()) {
				println "Book not saved, errors = ${newEmp.errors}"
			}
		}

*/
/*
// Example Response Data
// Parse the response
		def list = new JsonSlurper().parseText(f.getText())

// Print them out to make sure
		list.each { println it }
*/

		new Usuario(nombre: "abc", apellido: "def",nick:"admin", tipo: "administrador", contrasena:"admin" ).save()

		new Usuario(nombre: "nuevo", apellido: "alguno",nick:"normal", tipo: "emprendedor", contrasena:"normal" ).save()
    	def primario=new Sector(nombre:"PRIMARIO")
    	def secundario=new Sector(nombre:"SECUNDARIO")
    	def terciario=new Sector(nombre:"TERCIARIO")
    	primario.save()
    	secundario.save()
    	terciario.save()
    	def publico=new Ambito(nombre: "ESTATAL")
    	def privado=new Ambito(nombre: "PRIVADO")
    	publico.save()
    	privado.save()
    	def forestal=new Rubro(nombre:"FORESTAL")
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
		def tel=new Rubro(nombre: "TELEFONÍA E INFORMÁTICA")
		tel.save()
		def tel2=new Rubro(nombre: "INMOBILIARIA")
		tel2.save()
		terciario.addToRubros(tel)
		terciario.addToRubros(tel2)

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


		def HORTÍCOLA=new Rubro(nombre: "HORTÍCOLA")
		HORTÍCOLA.save()
		/*
		FORESTAL
		GANADERO
		TURBERO
		GIMNASIO
		ALOJAMIENTO
		AGENCIA DE VIAJES
		TALLER MECÁNICO
		RECICLAJE
		TELEFONÍA E INFORMÁTICA
		INMOBILIARIA
		POLIRRUBRO
		GASTRONÓMICO
		COMERCIO
		VIDRIERÍA
		GOMERÍA
		TRANSPORTE
		VIVERO
		MERCADO
		PELUQUERÍA
		SALÓN
		OFICINA PÚBLICA
		DISTRIBUIDORA
		LAVADERO DE AUTOS
		SEGUROS
		BAR
		ALQUILER DE AUTOS
		EMBOTELLADORA
		MUEBLERIA
		KINESIOLOGÍA
		ACOPÍADORA
		BANCO
		VETERINARIA
		SERVICIO
		CONSULTORIO
		FERRETERÍA
		RESPUESTOS PARA AUTOS
		EDUCACIÓN
		RADIO
		FARMACIA
		PANADERÍA
		LIBRERÍA
		LOCUTORIO
		ÓPTICA

		SERVICIOS TURÍSTICOS
		TRANSPORTE DE CARGA
		CONSULTORA AMBIENTAL
		CÁMARA DE COMERCIO
		LUBRICENTRO
		TALLER DE HERRERÍA
		INFORMATICA
		MOVIMIENTO DE SUELO
		CONSTRUCTORA
		GRANJA
		ARTESANIAS
		SERVICIOS
		CERRAJERIA
		AGRIMENSURA
		ESTUDIO JURIDICO
		CARPINTERIA
		*/


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
