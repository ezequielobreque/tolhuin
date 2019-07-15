package tolhuin
import groovy.json.* 
class GraficoController {

    def index() { 
    	def data=new ArrayList()
        String consulta=("from Emprendimiento as e where e.rubro.sector.nombre='primario'")
    	data.add(Emprendimiento.findAll(consulta).size())
        consulta=("from Emprendimiento as e where e.rubro.sector.nombre='secundario'")
        data.add(Emprendimiento.findAll(consulta).size())
        consulta=("from Emprendimiento as e where e.rubro.sector.nombre='terciario'")
        data.add(Emprendimiento.findAll(consulta).size())       
        def labels=['Primario','Secundario','Terciario']
    	def backgroundcolor= ['rgba(255, 99, 132, 0.2)',
                              'rgba(54, 162, 235, 0.2)',
                              'rgba(255, 206, 86, 0.2)']
        def objeto=[datasets:[[label:'emprendimientos por sector',data:data,backgroundColor:backgroundcolor]],labels:labels]
        def json = JsonOutput.toJson(objeto)
        [data: json]
    }
}

