package tolhuin

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DetalleServiceSpec extends Specification {

    DetalleService detalleService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Detalle(...).save(flush: true, failOnError: true)
        //new Detalle(...).save(flush: true, failOnError: true)
        //Detalle detalle = new Detalle(...).save(flush: true, failOnError: true)
        //new Detalle(...).save(flush: true, failOnError: true)
        //new Detalle(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //detalle.id
    }

    void "test get"() {
        setupData()

        expect:
        detalleService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Detalle> detalleList = detalleService.list(max: 2, offset: 2)

        then:
        detalleList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        detalleService.count() == 5
    }

    void "test delete"() {
        Long detalleId = setupData()

        expect:
        detalleService.count() == 5

        when:
        detalleService.delete(detalleId)
        sessionFactory.currentSession.flush()

        then:
        detalleService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Detalle detalle = new Detalle()
        detalleService.save(detalle)

        then:
        detalle.id != null
    }
}
