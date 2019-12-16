<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'usuario.label', default: 'Usuario')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
        <asset:stylesheet src="mycss.css"/>
    </head>
    <body>
        <a href="#create-usuario" class="skip" style="color: black" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
          <div class="contentShow">
            <g:form resource="${this.usuario}" method="POST">

                <fieldset class="form">
                    <f:all bean="usuario" except="tipo,contactos"/>
                    <div class="crear">
                    <sec:ifAnyGranted roles='ROLE_ADMIN,ROLE_ADMINISTRADOR'>
                    <label for="tipo">tipo
                        <span class="required-indicator">*</span>
                    </label>

                    <select name="tipo" id="tipo">

                    <option value="administrador">administrador</option>
                    <option value="municipalidad">municipalidad</option>



                        <option value="emprendedor">emprendedor</option>
                        <option value="investigador">investigador</option>
                    </select>
                </sec:ifAnyGranted>
                    <sec:ifAnyGranted roles="ROLE_ANONYMOUS">
                        <input value="emprendedor" type="hidden" name="tipo" id="tipo">
                    </sec:ifAnyGranted>


                    
                    <div class="fieldcontain required">
                        <label for="password">Contraseña
                            <span class="required-indicator">*</span>
                        </label><input type="password" name="password" id="password">
                    </div>

                </div>
                </fieldset>
                <fieldset class="buttons">

                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>

            </g:form>

    </body>
</html>
