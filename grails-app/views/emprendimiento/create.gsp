<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'emprendimiento.label', default: 'Emprendimiento')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
    <g:form resource="${this.emprendimiento}" method="POST">
    <div id="show-emprendimiento" class="contentShow" role="main">

            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.emprendimiento}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.emprendimiento}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>

                <div class="creacion">
                    <div class="fieldcontain">
                        <label for="nombre">Nombre del emprendimiento </label><input type="text" name="nombre" value="" id="nombre">
                    </div>
                    <div class="fieldcontain">
                        <label for="usuario">Nombre del dueño </label><input type="text" name="usuario" value="" id="usuario">
                    </div>
                    <f:all bean="emprendimiento" except="featuredImageBytes,habilitado,featuredImageContentType,usuario,nombre"/>

                    <div class="crear">
                        <label for="habilitado">Emprendimiento habilitado</label>
                    <input type="hidden" name="_habilitado"><input type="checkbox" name="habilitado" id="habilitado">
                    </div>

                </div>
    <fieldset class="botonesDelShow">

       <g:submitButton name="create" class="btn btn-success" value="${message(code: 'default.button.create.label', default: 'Create')}" />


    </fieldset>
        </div>
        </g:form>
    </body>
</html>
