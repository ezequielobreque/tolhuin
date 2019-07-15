package tolhuin

import grails.gorm.services.Service

@Service(Emprendimiento)
interface EmprendimientoService {

    Emprendimiento get(Serializable id)

    List<Emprendimiento> list(Map args)

    Long count()

    void delete(Serializable id)

    Emprendimiento save(Emprendimiento emprendimiento)

}