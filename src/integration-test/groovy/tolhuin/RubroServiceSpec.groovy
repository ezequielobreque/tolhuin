package tolhuin

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RubroServiceSpec extends Specification {

    RubroService rubroService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Rubro(...).save(flush: true, failOnError: true)
        //new Rubro(...).save(flush: true, failOnError: true)
        //Rubro rubro = new Rubro(...).save(flush: true, failOnError: true)
        //new Rubro(...).save(flush: true, failOnError: true)
        //new Rubro(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //rubro.id
    }

    void "test get"() {
        setupData()

        expect:
        rubroService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Rubro> rubroList = rubroService.list(max: 2, offset: 2)

        then:
        rubroList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        rubroService.count() == 5
    }

    void "test delete"() {
        Long rubroId = setupData()

        expect:
        rubroService.count() == 5

        when:
        rubroService.delete(rubroId)
        sessionFactory.currentSession.flush()

        then:
        rubroService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Rubro rubro = new Rubro()
        rubroService.save(rubro)

        then:
        rubro.id != null
    }
}
