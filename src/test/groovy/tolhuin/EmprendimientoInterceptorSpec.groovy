package tolhuin

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class EmprendimientoInterceptorSpec extends Specification implements InterceptorUnitTest<EmprendimientoInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test emprendimiento interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"emprendimiento")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
