package tolhuin

import grails.gorm.services.Service

@Service(Ambito)
interface AmbitoService {

    Ambito get(Serializable id)

    List<Ambito> list(Map args)

    Long count()

    void delete(Serializable id)

    Ambito save(Ambito ambito)

}