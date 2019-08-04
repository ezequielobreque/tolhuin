/*package tolhuin

import org.grails.plugins.excelimport.*

class EmprendimientoExcelImporter extends AbstractExcelImporter {



    static Map CONFIG_BOOK_COLUMN_MAP = [
            sheet:'hoja1',
            startRow: 3,
            cellMap: [ 'B':'nombre',
                       'D':'telefono',
                       'E':'direccion',
                       'F':'rubro',
                       'H':'situacion',
                       'I':'ambito',
                       'J':'sector'

            ]
    ]
    public EmprendimientoExcelImporter(fileName) {
        super(fileName)
    }

    List<Map> getEmps() {
        List empList = ExcelImportService.convertColumnMapConfigManyRows(workbook, CONFIG_BOOK_COLUMN_MAP)
    }


    Map getOneMoreBookParams() {
        Map bookParams = ExcelImportService.convertFromCellMapToMapWithValues(workbook, CONFIG_BOOK_CELL_MAP )
    }



    static constraints = {
    }
}
*/