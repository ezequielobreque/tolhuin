<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'emprendimiento.label', default: 'Emprendimiento')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
        <asset:stylesheet href="mycss.css"></asset:stylesheet>
    </head>
    <body>
        <a href="#edit-emprendimiento" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div id="edit-emprendimiento" class="contentShow"  role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
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
            <g:form resource="${this.emprendimiento}" method="PUT">
                <g:hiddenField name="version" value="${this.emprendimiento?.version}" />
                <fieldset class="form" style="text-align: initial">
                    <f:all bean="emprendimiento" except="featuredImageBytes,featuredImageContentType"/>
                <sec:ifAnyGranted roles="ROLE_MINISTERIO,ROLE_ADMIN,ROLE_ADMINISTRADOR">
                    <div class="fieldcontain"><label for="validado">validado</label><input type="hidden" name="_validado"><input type="checkbox"
                        <g:if test="${this.emprendimiento.validado==true}">
                            checked="checked"
                        </g:if>
                                                                                                                                 name="validado" id="validado">

                    </div>
                </sec:ifAnyGranted>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
