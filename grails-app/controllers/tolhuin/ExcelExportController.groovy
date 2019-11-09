package tolhuin

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.Validateable
import pl.touk.excel.export.WebXlsxExporter

import java.lang.reflect.Array
@Secured(['ROLE_ANONYMOUS','ROLE_ADMIN','ROLE_MINISTERIO','ROLE_INVESTIGADOR','ROLE_ADMINISTRADOR','ROLE_EMPRENDEDOR'])
class ExcelExportController{

    def index() {
        List<Emprendimiento> emprendimientos = Emprendimiento.findAllByValidado(true)
        def headers = ['nombre', 'local','celular','direccion','rubro', 'ambito', 'sector']
        def withProperties = ['usuario', 'nombre', 'telefono','direccion', 'rubro.nombre', 'ambito.nombre', 'rubro.sector.nombre']

        new WebXlsxExporter().with {
            setResponseHeaders(response)
            fillHeader(headers)
            add(emprendimientos, withProperties)
            save(response.outputStream)
        }

    }

    def filtro(String filt) {
        print(filt.replace("[", '').replace(']', '').split(',').toList())

        /* def intList=params.filt.toList()
        for(String s : params.filt.toList()){
            intList.add(Integer.valueOf(s))};
        print(intList);*/
        try {
            List<Emprendimiento> emprendimientos = Emprendimiento.getAll(filt.replace("[", '').replace(']', '').split(',').toList())

            emprendimientos = emprendimientos.findAll { it.validado }


        def headers = ['nombre', 'local', 'celular', 'direccion', 'rubro', 'ambito', 'sector']
        def withProperties = ['usuario', 'nombre', 'telefono', 'direccion', 'rubro.nombre', 'ambito.nombre', 'rubro.sector.nombre']

        new WebXlsxExporter().with {
            setResponseHeaders(response)
            fillHeader(headers)
            add(emprendimientos, withProperties)
            save(response.outputStream)
        }
    }catch(Exception ex){ flash.message = "no se puede generar un excel vacio"
            redirect controller:"main"}
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

