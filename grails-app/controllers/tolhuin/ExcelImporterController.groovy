package tolhuin
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import static org.apache.poi.ss.usermodel.Cell.*
import java.io.File
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
                        def rubros=Rubro.findAll()
                        def ambito=Ambito.findByNombre(v.ambito)
                        def sector= Sector.findByNombre(v.sector)
                        if(!(v.rubro in(rubros.nombre))){
                            Rubro rub= new Rubro(nombre:v.rubro,sector:sector)
                            rub.save()

                        }


                        def rubro=Rubro.findByNombre(v.rubro)

                        emprendimientoService.save(Emprendimiento.findByNombre(v.nro)?: new Emprendimiento(usuario:v.nombre,habilitado: true,nombre: v.local,direccion: v.direccion,rubro:rubro,ambito:ambito))

                    }


                }


                flash.message = "Subscriber imported successfully"
                redirect action:"index"
            }
        }

}
