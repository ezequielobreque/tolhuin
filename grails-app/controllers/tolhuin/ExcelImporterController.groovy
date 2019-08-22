package tolhuin
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import static org.apache.poi.ss.usermodel.Cell.*
import java.io.File
import groovy.json.*
class ExcelImporterController {

    EmprendimientoService emprendimientoService

    def index() {}
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
                        def rubros=Rubro.findAll()
                        def local=v.local;
                        print(v.local)
                        if (local==null){
                            local="negocio de " + v.nombre
                        }
                        def ambito=Ambito.findByNombre(v.ambito)
                        def sector= Sector.findByNombre(v.sector)
                        if(!(v.rubro in(rubros.nombre))){
                            Rubro rub= new Rubro(nombre:v.rubro,sector:sector)
                            rub.save()

                        }


                        def latitud
                        def longitud
                        String direcion=v.direccion
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

                            }
                        def rubro=Rubro.findByNombre(v.rubro)

                        emprendimientoService.save(Emprendimiento.findByNombre(v.nro)?: new Emprendimiento(usuario:v.nombre,habilitado: true,nombre: local,direccion: v.direccion,rubro:rubro,ambito:ambito,longitud: longitud,latitud:latitud))

                    }


                }


                flash.message = "Subscriber imported successfully"
                redirect action:"index"
            }
        }

}
