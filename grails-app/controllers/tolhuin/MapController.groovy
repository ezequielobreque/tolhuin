package tolhuin

import groovy.json.*

class MapController {

    def index() { }
    def mapi(){
        String direcion='Gobernador Campos N°1416'
       String dire= direcion.replaceAll("[^A-Za-z0-9]", "+")
        print(dire)
        def get = new URL("https://geocoder.api.here.com/6.2/geocode.json?app_id=yRbrv8bfdmGRDhUlolXl&app_code=LzSuSfgDM53H-Bc1YCMU-g&searchtext=" +dire+ "+tolhuin+tierra+del+fuego").openConnection();
        def getRC = get.getResponseCode();
        println(getRC)
        if(getRC.equals(200)) {
            println()

            String jsonString = get.getInputStream().getText()
            JsonSlurper slurper = new JsonSlurper()
            Map parsedJson = slurper.parseText(jsonString)

            print(parsedJson.Response.View.Result.Location.DisplayPosition.Latitude[0][0])

        }
    }
    def mapa(String id) {
        print(id)
        def emp
        if (id!=null) {
            emp = Emprendimiento.findById(id.toInteger())

        print(emp)
        }
        def json=JsonOutput.toJson(null)

        if(emp!=null) {
            json = JsonOutput.toJson([nombre: emp.nombre, rubro: emp.rubro.nombre, sector: emp.rubro.sector.nombre, longitud: emp.longitud, latitud: emp.latitud, direccion: emp.direccion, telefono: emp.telefono])
        }

        def List=Emprendimiento.getAll()
        def listJson=JsonOutput.toJson(null)
        def aray=[]
        if(List!=null) {
            List.each {
                aray.add([id:it.id,nombre: it.nombre, rubro: it.rubro.nombre, sector: it.rubro.sector.nombre, longitud: it.longitud, latitud: it.latitud, direccion: it.direccion,imagen:it.featuredImageBytes, telefono: it.telefono])
            }


            listJson=JsonOutput.toJson(aray)
            print(listJson)
        }


        [emp: json,list:listJson]




    }
}
