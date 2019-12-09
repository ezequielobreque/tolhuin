<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'emprendimiento.label', default: 'Emprendimiento')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<a href="#list-emprendimiento" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div style="text-align: center; margin: 3%">
    <g:if test="${this.list.size()==0}">
        <h1 style="margin: auto;width: 70%;color:rgba(255,255,255,.8);font-family: 'Font Awesome 5 Free';background-color: #4e73df   ;background-size: contain;border-radius: 10px">Nose se encontro ningun emprendimiento con ese filtro<h1>
    </g:if>
    <g:else>
    <!--<h1><g:message code="default.list.label" args="[entityName]" /></h1>-->
    <h2 style="font-family: 'Font Awesome 5 Free';color:black">Lista de emprendimientos</h2>

    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>





    <g:each in='${this.list}'>
        <g:if test="${it.validado==true}">
        <ul class="list-group" style="margin: 0.5rem">
            <li class="list-group-item active"><a href="../emprendimiento/show/${it.id}" style="color: white">Nombre: ${it.nombre}</a></li>
            <li class="list-group-item">Dueño: ${it.usuario}</li>
            <li class="list-group-item">Direccion: ${it.direccion}</li>
            <li class="list-group-item">Telefono: ${it.telefono}</li>
            <li class="list-group-item">Estado de habilitacion:${it.habilitado}</li>
            <li class="list-group-item">Descripcion: ${it.descripcion}</li>
            <li class="list-group-item">Rubro: ${it.rubro}</li>
            <li class="list-group-item">Ambito: ${it.ambito}</li>
        </ul>
        <br>
        </g:if>

        <g:else>
            <sec:ifAnyGranted roles="ROLE_MINISTERIO,ROLE_ADMIN,ROLE_ADMINISTRADOR">
            <ul class="list-group" style="margin: 0.5rem">
                <li class="list-group-item active" style="background-color: red"><a href="../emprendimiento/show/${it.id}" style="color: white">Nombre: ${it.nombre}</a></li>
                <li class="list-group-item">Dueño: ${it.usuario}</li>
                <li class="list-group-item">Direccion: ${it.direccion}</li>
                <li class="list-group-item">Telefono: ${it.telefono}</li>
                <li class="list-group-item">Estado de habilitacion:${it.habilitado}</li>
                <li class="list-group-item">Descripcion: ${it.descripcion}</li>
                <li class="list-group-item">Rubro: ${it.rubro}</li>
                <li class="list-group-item">Ambito: ${it.ambito}</li>
            </ul>
            <br>
            </sec:ifAnyGranted>
        </g:else>

    </g:each>



    <form class= method="POST" action="/excelExport/filtro">
                <button class="btn btn-primary" name="filt" id="filt" value="${this.list.id}"
                type="submit">

                    <i class="far fa-file-excel"> Generar Excel</i>
                </button>


    </form>

    </g:else>
</div>
</body>
</html>