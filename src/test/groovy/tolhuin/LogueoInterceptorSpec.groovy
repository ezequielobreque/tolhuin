package tolhuin

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class LogueoInterceptorSpec extends Specification implements InterceptorUnitTest<LogueoInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test logueo interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"logueo")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
