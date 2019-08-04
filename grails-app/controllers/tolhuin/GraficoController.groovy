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

        /*def dataRubro=new ArrayList()
        String consultaRubro=("from Emprendimiento as e where e.rubro.sector.nombre='Hortícola'")
        data.add(Emprendimiento.findAll(consultaRubro).size())

        consultaRubro=("from Emprendimiento as e where e.rubro.sector.nombre='Forestal'")
        data.add(Emprendimiento.findAll(consultaRubro).size())

        consultaRubro=("from Emprendimiento as e where e.rubro.sector.nombre='Ganadero'")
        data.add(Emprendimiento.findAll(consultaRubro).size())

        consultaRubro=("from Emprendimiento as e where e.rubro.sector.nombre='Turbero'")
        data.add(Emprendimiento.findAll(consultaRubro).size())

        consultaRubro=("from Emprendimiento as e where e.rubro.sector.nombre='Gimnacio'")
        data.add(Emprendimiento.findAll(consultaRubro).size())

        consultaRubro=("from Emprendimiento as e where e.rubro.sector.nombre='Alojamiento'")
        data.add(Emprendimiento.findAll(consultaRubro).size())

        consultaRubro=("from Emprendimiento as e where e.rubro.sector.nombre='Agencia de viajes'")
        data.add(Emprendimiento.findAll(consultaRubro).size())

        consultaRubro=("from Emprendimiento as e where e.rubro.sector.nombre='Taller mecanico'")
        data.add(Emprendimiento.findAll(consultaRubro).size())

        consultaRubro=("from Emprendimiento as e where e.rubro.sector.nombre='Reciclaje'")
        data.add(Emprendimiento.findAll(consultaRubro).size())


        consultaRubro=("from Emprendimiento as e where e.rubro.sector.nombre='Telefonia mobil e informatica'")
        data.add(Emprendimiento.findAll(consultaRubro).size())

        consultaRubro=("from Emprendimiento as e where e.rubro.sector.nombre='Inmobiliaria'")
        data.add(Emprendimiento.findAll(consultaRubro).size())

        consultaRubro=("from Emprendimiento as e where e.rubro.sector.nombre='Polirubro'")
        data.add(Emprendimiento.findAll(consultaRubro).size())

        consultaRubro=("from Emprendimiento as e where e.rubro.sector.nombre='Gastronomico'")
        data.add(Emprendimiento.findAll(consultaRubro).size())

        consultaRubro=("from Emprendimiento as e where e.rubro.sector.nombre='Comercio'")
        data.add(Emprendimiento.findAll(consultaRubro).size())

        consultaRubro=("from Emprendimiento as e where e.rubro.sector.nombre='Vidrieria'")
        data.add(Emprendimiento.findAll(consultaRubro).size())

        consultaRubro=("from Emprendimiento as e where e.rubro.sector.nombre='Gomeria'")
        data.add(Emprendimiento.findAll(consultaRubro).size())

        consultaRubro=("from Emprendimiento as e where e.rubro.sector.nombre='Transporte'")
        data.add(Emprendimiento.findAll(consultaRubro).size())

        consultaRubro=("from Emprendimiento as e where e.rubro.sector.nombre='Vivero'")
        data.add(Emprendimiento.findAll(consultaRubro).size())

        consultaRubro=("from Emprendimiento as e where e.rubro.sector.nombre='terciario'")
        data.add(Emprendimiento.findAll(consultaRubro).size())

        consultaRubro=("from Emprendimiento as e where e.rubro.sector.nombre='terciario'")
        data.add(Emprendimiento.findAll(consultaRubro).size())
        def labels2=['Hortícola','Forestal','Ganadero','Turbero','Gimnacio','Alojamiento','Agencia de viajes','Taller mecanico','Reciclaje','Telefonia mobil e informatica','Inmobiliaria','Polirubro','Gastronomico','Comercio','Vidrieria','Gomeria','Transporte','Vivero','Mercado','Salon','Bar','Distribuidora']
        def backgroundcolor2= ['rgba(255, 99, 132, 0.2)',
                              'rgba(54, 162, 235, 0.2)',
                              'rgba(255, 206, 86, 0.2)']
        def objetoRubro=[datasets:[[label:'emprendimientos por sector',data: dataRubro,backgroundColor:backgroundcolor2]],labels:labels2]
        def jsonRubro = JsonOutput.toJson(objetoRubro)
        [data: jsonRubro]*/


    }
}

