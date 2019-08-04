<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />

        <title>Página principal</title>
    </head>
<body>

		%{--<f:table collection="${emprendimientoList}" />--}%


<div class="row">
<g:each in="${emprendimientoList}">

        <div class="col-sm-6">
            <div class="card text-white bg-success mb-3" style="max-width: 25rem;">
                <g:if test="${it.featuredImageBytes}">
                    <img  class="card-img-top" src="<g:createLink controller="emprendimiento" action="featuredImage" id="${it.id}"/>" alt="Card image cap" style="height: 300px"/>
                </g:if>
                <g:else>

                    <g:img dir="images" file="no imagen.png" height="250"/>
                </g:else>

        <div class="card-body">

            <h1><a href="emprendimiento/show/${it.id}">${it.nombre}</a></h1>

            <p>Direccion: ${it.direccion}</p>
            <a>Ambito:${it.ambito.nombre} </a>
            <br>
            <a>Rubro:${it.rubro.nombre} </a>
        </div>
    </div>
        </div>

</g:each>
</div>

</body>

</html>