<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'emprendimiento.label', default: 'Emprendimiento')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>

    <div id="show-emprendimiento" class="contentShow" role="main">
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
            <g:uploadForm name="uploadFeaturedImage" action="uploadFeaturedImage">
                <g:hiddenField name="id" value="${this.emprendimiento?.id}" />
                <g:hiddenField name="version" value="${this.emprendimiento?.version}" />
                <input class="btn btn-outline-primary" style="background-color:#f1c40f;color: black" type="file" name="featuredImageFile" />
                <fieldset class="botonesDelShow">
                    <i class="fas fa-upload"></i><input class="btn btn-secondary" type="submit" value="${message(code: 'emprendimiento.featuredImage.upload.label', default: 'Upload')}" />
                </fieldset>
            </g:uploadForm>
        </div>
    </body>
</html>
