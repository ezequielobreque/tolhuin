<%@ page import="tolhuin.Rubro" %>
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
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <div id="show-emprendimiento" class="contentShow" role="main">
    <form method="GET" action="/emprendimiento/FiltrosEspeciales">
        <div class="form-group">
            <label for="local">Buscar emprendimiento por nombre del establecimiento</label>
            <input type="text" class="form-control" name="local" id="local" placeholder="Buscar Emprendimientos..">
        </div>

        <div class="form-group">
            <label for="id">Buscar emprendimiento por el identificador del mismo</label>
            <input type="text" class="form-control" name="id" id="id" placeholder="Buscar Emprendimiento por id..">
        </div>
        <!--,String ambito,String sector ,String dni,Boolean sinDni,String direccion,Boolean sinDireccion,String local,Boolean sinLocal,String dueno,Boolean sinDueno,Boolean solo-->
        <div class="form-group">
            <label for="rubro">Rubro</label>
            <select class="form-control" id="rubro" name="rubro">
                <option disabled selected value>Rubro..</option>
                <g:each in="${Rubro.list()}">
                    <option value="${it.nombre}">${it.nombre}</option>
                </g:each>
            </select>
        </div>
        <div class="form-group">
            <label for="ambito">Ambito</label>
            <select class="form-control" id="ambito" name="ambito">
                <option disabled selected value>Ambito..</option>
                <option value="PRIVADO">Privado</option>
                <option value="ESTATAL">Estatal</option>
            </select>
        </div>
        <div class="form-group">
            <label for="sector" >Sector</label>
            <select class="form-control" id="sector" name="sector">
                <option disabled selected value>Sector..</option>
                <option value="PRIMARIO">Primario</option>
                <option value="SECUNDARIO">Secundario</option>
                <option value="TERCIARIO">Terciario</option>
            </select>
        </div>

        <div id="checkboxin">
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" name="sinDni" id="SinDni" value="true">
                <label class="form-check-label" for="sinDni">Emprendimientos sin dni</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" name="sinDireccion" id="sinDireccion" value="true">
                <label class="form-check-label" for="sinDireccion">sin direccion</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" name="sinDueno" id="sinDueno" value="true">
                <label class="form-check-label" for="sinDueno">sin dueño</label>
            </div>
        </div>

   <div>

       <button type="submit" class="btn btn-primary"onclick="myfunction()" name="solo" id="solo">Buscar</button>
   </div>
    </form>
    </div>
    <g:if test="${this.list.size()==0}">
        <h1 style="margin: auto;width: 70%;color:rgba(255,255,255,.8);font-family: 'Font Awesome 5 Free';background-color: #4e73df   ;background-size: contain;border-radius: 10px">Nose se encontro ningun emprendimiento con ese filtro<h1>
    </g:if>
    <g:else>
    <!--<h1><g:message code="default.list.label" args="[entityName]" /></h1>-->
    <h2 style="font-family: 'Font Awesome 5 Free';color:black">Lista de emprendimientos</h2>






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

<script>
    function myfunction() {
        var rubr=document.getElementById("rubro");
        var idx=document.getElementById("id");

        var ambit=document.getElementById("ambito");
        var secto=document.getElementById("sector");
        var loca=document.getElementById("local");
        var sol=document.getElementById("solo");
        if(loca.value===''&&idx.value===''&&rubr.value===''&&secto.value===''&&ambit.value===''){

            sol.value= "true";
        }else{

            sol.value= "false";
        }

    }



</script>
</body>


</html>