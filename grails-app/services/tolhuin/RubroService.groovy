package tolhuin

import grails.gorm.services.Service

@Service(Rubro)
interface RubroService {

    Rubro get(Serializable id)

    List<Rubro> list(Map args)

    Long count()

    void delete(Serializable id)

    Rubro save(Rubro rubro)

}