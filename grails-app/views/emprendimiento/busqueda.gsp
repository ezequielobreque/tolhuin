<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'emprendimiento.label', default: 'Emprendimiento')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<a href="#list-emprendimiento" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
    </ul>
</div>
<div id="list-emprendimiento" class="content scaffold-list" role="main">
    <!--<h1><g:message code="default.list.label" args="[entityName]" /></h1>-->
    <h1>Lista de emprendimientos</h1>

    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>


    <f:table collection="${this.list}" except="featuredImageBytes,featuredImageContentType" />

    <form class= method="POST" action="/excelExport/filtro">
                <button class="btn btn-primary" name="filt" id="filt" value="${this.list.id}"
                type="submit">

                    <i class="far fa-file-excel"></i>
                </button>


    </form>


</div>
</body>
</html>