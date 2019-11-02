package tolhuin

import grails.plugin.springsecurity.annotation.Secured
import groovy.json.*
@Secured(['ROLE_ANONYMOUS','ROLE_ADMIN','ROLE_MINISTERIO','ROLE_INVESTIGADOR','ROLE_ADMINISTRADOR','ROLE_EMPRENDEDOR'])
class MapController {

    def index() { }
    def map3(){

    }
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
    def mapa(String id,String buscar,String rubro,String ambito,String sector ) {
        print(id)
        Emprendimiento emp
        if (id!=null) {
            emp = Emprendimiento.findById(id.toInteger())

        print(emp)
        }
        def json=JsonOutput.toJson(null)

        if(emp!=null) {
            json = JsonOutput.toJson([nombre: emp.nombre,usuario:emp.usuario,telefono:emp.telefono, rubro: emp.rubro.nombre, sector: emp.rubro.sector.nombre, longitud: emp.longitud, latitud: emp.latitud, direccion: emp.direccion, telefono: emp.telefono])
        }

        def List = Emprendimiento.getAll()
        def listJson = JsonOutput.toJson(null)
        def aray = []

            def amb=null
            if(ambito!=null){
                if(!ambito.isEmpty()){

                    amb = Ambito.findByNombreLike('%' + ambito + '%')
                }
            }
            print(amb)

            def rub=null
        if(rubro!=null){
            if(!rubro.isEmpty()) {
                rub = Rubro.findByNombreLike('%' + rubro + '%')

            }
            }
            def sec=null

                if(sector!=null) {
                    if (!sector.isEmpty()) {
                        sec = Sector.findByNombreLike('%' + sector + '%')
                    }
                }

        if(buscar!=null){
            if(!buscar.isEmpty()) {
                print (buscar.isEmpty())
                List = Emprendimiento.findAllByNombreLike('%' + buscar + '%')

            }
        }


            /*if (amb!=null && rub!=null) {

                List = Emprendimiento.findAllByNombreLikeAndAmbitoAndRubro('%' + buscar + '%', amb, rub)
            }else
                if(amb!=null&& rub==null){

                    List = Emprendimiento.findAllByNombreLikeAndAmbito('%' + buscar + '%', amb)
                }
            else if(rub!=null && amb==null){

                    List = Emprendimiento.findAllByNombreLikeAndRubro('%' + buscar + '%', rub)

                }else if(rub==null && amb==null)
                    {

                        List = Emprendimiento.findAllByNombreLike('%' + buscar + '%')

                    }*/

            if (amb!=null){
                List=List.findAll{it.ambito.nombre.toString()==ambito.toString()}



            }
            if (rub!=null){
                print(rubro.toString())
                List=List.findAll { it.rubro.nombre.toString()==rubro.toString()}

            }
            if (sec!=null) {


                print(List.rubro.sector.nombre)
                List=List.findAll { it.rubro.sector.nombre.toString()==sector.toString() }

            }

        if (List != null) {
            List.each {
                aray.add([id: it.id,telefono:it.telefono,usuario:it.user, nombre: it.nombre, ambito:it.ambito.nombre,rubro: it.rubro.nombre, sector: it.rubro.sector.nombre, longitud: it.longitud, latitud: it.latitud, direccion: it.direccion, imagen: it.featuredImageBytes, telefono: it.telefono])
            }


            listJson = JsonOutput.toJson(aray)
        }

        [emp: json,list:listJson]




    }
}
