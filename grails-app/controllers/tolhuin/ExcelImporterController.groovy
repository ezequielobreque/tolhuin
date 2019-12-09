package tolhuin

import grails.plugin.springsecurity.annotation.Secured
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import static com.lowagie.text.Cell.*
import java.io.File
import groovy.json.*
@Secured(['ROLE_ANONYMOUS','ROLE_ADMIN'])
class ExcelImporterController {

    EmprendimientoService emprendimientoService

    def index(Boolean si, String dni,String dueno,String nombre,String direccion) {
      if(si){

          File file = new File("out.txt")
        file.write "Log de los pequeños problemas encontrados||"



        List<Emprendimiento> dnix
        if(dni!=null) {
            if(!dni.isEmpty()){
            dnix = Emprendimiento.getAll(dni.replace("[", '').replace(']', '').split(',').toList())
            }
        }

        if(dnix!=null){
            if(!dnix.isEmpty()){
                file.append( "los sieguientes emprendimientos que se cargaron no tienen dni asociado:||")
                dnix.each{file.append(  "emprendimiento id :"+it.id+"||")}
            }
        }
        List<Emprendimiento> duenox
        if(dueno!=null) {
            if(!dueno.isEmpty()){
            duenox = Emprendimiento.getAll(dueno.replace("[", '').replace(']', '').split(',').toList())
        }}

        if(duenox!=null){
            if(!duenox.isEmpty()){\
                file.append("los sieguientes emprendimientos que se cargaron no tienen nombre del dueño:||")
                duenox.each{file.append( "emprendimiento id :"+it.id+"||")}



            }
        }
        List<Emprendimiento> nombrex
        if(nombre!=null) {
            if(!nombre.isEmpty()) {
                nombrex = Emprendimiento.getAll(dueno.replace("[", '').replace(']', '').split(',').toList())
            }}
        if(nombrex!=null){
            if(!nombrex.isEmpty()){
                file.append( "los sieguientes emprendimientos que se cargaron no tienen nombre del local:||")
                nombrex.each{file.append( "emprendimiento id :"+it.id+"||")}


            }
        }
        List<Emprendimiento> direccionx
        if(direccion!=null) {
            if(!direccion.isEmpty()){
            direccionx = Emprendimiento.getAll(dni.replace("[", '').replace(']', '').split(',').toList())
        }}

        if(direccionx!=null){
            if(!direccionx.isEmpty()){
                file.append( "los sieguientes emprendimientos que se cargaron no tienen direccion:||")
                direccionx.each{file.append( "emprendimiento id :"+it.id+"||")}
            }
        }
          print(file.text)

          [text:file.text,dni: dni, dueno: dueno, nombre: nombre, direccion: direccion]
        }

        else {

          [text:null,dni: dni, dueno: dueno, nombre: nombre, direccion: direccion]


      }


            }
        def uploadFile() {
            def file = request.getFile('excelFile')
            if(!file.empty) {
                def sheetheader = []
                def values = []
                def workbook = new XSSFWorkbook(file.getInputStream())
                def sheet = workbook.getSheetAt(0)

                for (cell in sheet.getRow(0).cellIterator()) {
                    sheetheader << cell.stringCellValue
                }

                def headerFlag = true
                for (row in sheet.rowIterator()) {
                    if (headerFlag) {
                        headerFlag = false
                        continue
                    }
                    def value = ''
                    def map = [:]
                    for (cell in row.cellIterator()) {
                        switch(cell.cellType) {
                            case 1:
                                value = cell.stringCellValue
                                map["${sheetheader[cell.columnIndex]}"] = value
                                break
                            case 0:
                                value = cell.numericCellValue
                                map["${sheetheader[cell.columnIndex]}"] = value
                                break
                            default:
                                value = ''
                        }
                    }
                    values.add(map)
                }
                List<Emprendimiento> emprendimientosSinDni
                List<Emprendimiento> emprendimientosSinDueno
                List<Emprendimiento> emprendimientosSinNombre
                List<Emprendimiento> emprendimientosSinDireccion




                values.each { v ->
                    if(v) {

                        /*def nombre = ""

                        if (v.nombre.isNull()) {

                            nombre = ""

                        } else {
                            nombre = v.nombre
                        }
                        def local = ""

                        if (v.local.isNull()){

                            local=""

                        }else

                        {
                            local=v.nombre
                        }*/

                        Usuario user=Usuario.findByDni(v.dni)
                        def rubros=Rubro.findAll()
                        print(user)
                        def local=v.local;
                        print(v.local)
                        if (local==null){
                            local="negocio de " + v.nombre+".Dir: "+v.direccion
                        }
                        def ambito=Ambito.findByNombre(v.ambito)
                        def sector= Sector.findByNombre(v.sector)
                        if(!(v.rubro in(rubros.nombre))){
                            Rubro rub= new Rubro(nombre:v.rubro,sector:sector)
                            rub.save()

                        }


                        def latitud
                        def longitud
                        String direcion
                        if(v.direccion!=null){
                        direcion=v.direccion
                        String dire= direcion.replaceAll("[^A-Za-z0-9]", "+")
                        print(dire)
                        def get = new URL("https://geocoder.api.here.com/6.2/geocode.json?app_id=yRbrv8bfdmGRDhUlolXl&app_code=LzSuSfgDM53H-Bc1YCMU-g&searchtext=" +dire+ "+tolhuin+tierra+del+fuego").openConnection();
                        def getRC = get.getResponseCode();
                            println(getRC)
                            if(getRC.equals(200)){
                                String jsonString = get.getInputStream().getText()
                                JsonSlurper slurper = new JsonSlurper()
                                Map parsedJson = slurper.parseText(jsonString)

                                latitud=(parsedJson.Response.View.Result.Location.DisplayPosition.Latitude[0][0])

                                longitud=(parsedJson.Response.View.Result.Location.DisplayPosition.Longitude[0][0])

                            }else{
                                latitud=(-54.0000-Math.random())
                                longitud=(-54.0000-Math.random())

                            }}else{longitud=null
                            latitud=null}
                        def rubro=Rubro.findByNombre(v.rubro)

                        emprendimientoService.save(Emprendimiento.findByNombre(v.nro)?: new Emprendimiento(usuario:v.nombre,habilitado: true,validado: true,nombre: local,direccion: v.direccion,rubro:rubro,ambito:ambito,longitud: longitud,latitud:latitud,user: user))
                        def emp= Emprendimiento.findByNombreAndDireccionAndUsuario(local,v.direccion,v.nombre)
                        if(user!=null&&user!=[]){

                            user.addToEmprendimientos(emp)

                        }
                        if(emp.user!=null){


                            emprendimientosSinDni.add(emp)

                        }
                        if(emp.usuario!=null){



                            emprendimientosSinDueno.add(emp)
                        }
                        if(emp.nombre!=null){


                            emprendimientosSinNombre.add(emp)

                        }
                        if(emp.direccion!=null){

                            emprendimientosSinDireccion.add(emp)



                        }



                    }


                }



                flash.message = "Subscriber imported successfully"
                redirect action:"index",params: [si: true,dni:emprendimientosSinDni,dueno:emprendimientosSinDueno,nombre:emprendimientosSinNombre,direccion:emprendimientosSinDireccion]
            }
        }


    def log(String dni,String dueno,String nombre,String direccion){





    }

}
