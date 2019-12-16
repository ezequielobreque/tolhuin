package tolhuin

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ANONYMOUS','ROLE_ADMIN','ROLE_MINISTERIO','ROLE_INVESTIGADOR','ROLE_ADMINISTRADOR','ROLE_EMPRENDEDOR'])
class PublicController {

    def index() {}
}
