package tolhuin

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EmprendimientoServiceSpec extends Specification {

    EmprendimientoService emprendimientoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Emprendimiento(...).save(flush: true, failOnError: true)
        //new Emprendimiento(...).save(flush: true, failOnError: true)
        //Emprendimiento emprendimiento = new Emprendimiento(...).save(flush: true, failOnError: true)
        //new Emprendimiento(...).save(flush: true, failOnError: true)
        //new Emprendimiento(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //emprendimiento.id
    }

    void "test get"() {
        setupData()

        expect:
        emprendimientoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Emprendimiento> emprendimientoList = emprendimientoService.list(max: 2, offset: 2)

        then:
        emprendimientoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        emprendimientoService.count() == 5
    }

    void "test delete"() {
        Long emprendimientoId = setupData()

        expect:
        emprendimientoService.count() == 5

        when:
        emprendimientoService.delete(emprendimientoId)
        sessionFactory.currentSession.flush()

        then:
        emprendimientoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Emprendimiento emprendimiento = new Emprendimiento()
        emprendimientoService.save(emprendimiento)

        then:
        emprendimiento.id != null
    }
}
