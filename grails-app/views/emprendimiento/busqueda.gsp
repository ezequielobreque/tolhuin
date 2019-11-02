<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'emprendimiento.label', default: 'Emprendimiento')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<a href="#list-emprendimiento" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div style="text-align: center">
    <!--<h1><g:message code="default.list.label" args="[entityName]" /></h1>-->
    <h2 style="font-family: 'Font Awesome 5 Free';color:black">Lista de emprendimientos</h2>

    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>


    <g:each in='${this.list}'>
        <ul class="list-group" style="margin: 0.5rem">
            <li class="list-group-item active">Nombre: ${it.nombre}</li>
            <li class="list-group-item">Dueño: ${it.usuario}</li>
            <li class="list-group-item">Direccion: ${it.direccion}</li>
            <li class="list-group-item">Telefono: ${it.telefono}</li>
            <li class="list-group-item">Estado de habilitacion:${it.habilitado}</li>
            <li class="list-group-item">Descripcion: ${it.descripcion}</li>
            <li class="list-group-item">Rubro: ${it.rubro}</li>
            <li class="list-group-item">Ambito: ${it.ambito}</li>
        </ul>
        <br>
    </g:each>
    <form class= method="POST" action="/excelExport/filtro">
                <button class="btn btn-primary" name="filt" id="filt" value="${this.list.id}"
                type="submit">

                    <i class="far fa-file-excel"> Generar Excel</i>
                </button>


    </form>


</div>
</body>
</html>