package tolhuin

import grails.gorm.services.Service

@Service(Detalle)
interface DetalleService {

    Detalle get(Serializable id)

    List<Detalle> list(Map args)

    Long count()

    void delete(Serializable id)

    Detalle save(Detalle detalle)

}