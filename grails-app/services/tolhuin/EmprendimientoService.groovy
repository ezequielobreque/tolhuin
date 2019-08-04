package tolhuin

import grails.gorm.services.Service


@Service(Emprendimiento)
interface EmprendimientoService {

    Emprendimiento get(Serializable id)

    List<Emprendimiento> list(Map args)

    Long count()

    void delete(Serializable id)

    Emprendimiento update(Serializable id, Long version, String nombre)
    Emprendimiento update(Serializable id, Long version, byte[] featuredImageBytes, String featuredImageContentType)

    Emprendimiento save(Emprendimiento emprendimiento)

}