package tolhuin

import grails.validation.Validateable
import pl.touk.excel.export.WebXlsxExporter

import java.lang.reflect.Array

class ExcelExportController{

    def index() {
        List<Emprendimiento> emprendimientos = Emprendimiento.list()
        def headers = ['nombre', 'local','celular','direccion','rubro', 'ambito', 'sector']
        def withProperties = ['usuario', 'nombre', 'telefono','direccion', 'rubro.nombre', 'ambito.nombre', 'rubro.sector.nombre']

        new WebXlsxExporter().with {
            setResponseHeaders(response)
            fillHeader(headers)
            add(emprendimientos, withProperties)
            save(response.outputStream)
        }

    }

    def filtro(String filt){
        print(filt.replace("[",'').replace(']','').split(',').toList())

       /* def intList=params.filt.toList()
        for(String s : params.filt.toList()){
            intList.add(Integer.valueOf(s))};
        print(intList);*/
        List<Emprendimiento> emprendimientos =Emprendimiento.getAll(filt.replace("[",'').replace(']','').split(',').toList())



        def headers = ['nombre', 'local','celular','direccion','rubro', 'ambito', 'sector']
        def withProperties = ['usuario', 'nombre', 'telefono','direccion', 'rubro.nombre', 'ambito.nombre', 'rubro.sector.nombre']

        new WebXlsxExporter().with {
            setResponseHeaders(response)
            fillHeader(headers)
            add(emprendimientos, withProperties)
            save(response.outputStream)
        }

    }

    def PDF(int id){
    // Get the bytes
    //    def bytes = gifRenderingService.render(template:'/images/coupon', model: [serial: 12345])
    // Render to a file
        renderPdf(template: '/emprendimiento/show/'+id+'', model: [report: reportObject], filename: reportObject.name)
        /*
        new File("nuevo.pdf").withOutputStream { outputStream ->
            pdfRenderingService.render([template: '/emprendimiento/show/'+id+'', model: [serial: 12345]], outputStream)
        }*/

    }
    }

