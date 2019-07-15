package tolhuin

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AmbitoServiceSpec extends Specification {

    AmbitoService ambitoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Ambito(...).save(flush: true, failOnError: true)
        //new Ambito(...).save(flush: true, failOnError: true)
        //Ambito ambito = new Ambito(...).save(flush: true, failOnError: true)
        //new Ambito(...).save(flush: true, failOnError: true)
        //new Ambito(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //ambito.id
    }

    void "test get"() {
        setupData()

        expect:
        ambitoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Ambito> ambitoList = ambitoService.list(max: 2, offset: 2)

        then:
        ambitoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        ambitoService.count() == 5
    }

    void "test delete"() {
        Long ambitoId = setupData()

        expect:
        ambitoService.count() == 5

        when:
        ambitoService.delete(ambitoId)
        sessionFactory.currentSession.flush()

        then:
        ambitoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Ambito ambito = new Ambito()
        ambitoService.save(ambito)

        then:
        ambito.id != null
    }
}
