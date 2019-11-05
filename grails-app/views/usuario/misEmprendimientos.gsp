<%--
  Created by IntelliJ IDEA.
  User: ezequiel PC
  Date: 5/11/2019
  Time: 00:07
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
    <asset:stylesheet src="mycss.css"/>
    <title></title>
</head>

<body>
<div class="row" style="margin-top: 1rem">
    <g:each in="${lista}">


        <div class="col-sm-12 col-xl-3 col-md-6 col-lg-4 ">
            <div class="card" style="width: 100%;">
                <g:if test="${it.featuredImageBytes}">
                    <img  class="card-img-top" src="<g:createLink controller="emprendimiento" action="featuredImage" id="${it.id}"/>" alt="Card image cap" style="height: 12REM"/>
                </g:if>
                <g:else>
                    <img src="/assets/no imagen.png" style="height: 12rem"/>

                </g:else>

                <div class="card-body">

                    <h1 style="text-align: center" ><a href="../emprendimiento/show/${it.id}"style="color:red;">${it.nombre}</a></h1>
                    <br>
                    <a style="color: black;font-size:1.2em">${it.descripcion} </a>
                    <br>
                    <p>Direccion: ${it.direccion}</p>
                    <p>Ambito: ${it.ambito.nombre} </p>

                    <p>Rubro: ${it.rubro.nombre} </p>
                    <div class="row">
                        <div class="col-4">
                            <form action="../map/mapa">
                                <button type="submit" name="id" value="${it.id}"     class="btn btn-success" style="align-content:center ">
                                    <i class="fas fa-map"> mapa</i>
                                </button>
                            </form>
                        </div>
                        <div class="col-4">
                            <form action="../emprendimiento/show/${it.id}">
                                <button type="submit"  class="btn btn-primary" style="align-content:center ">
                                    <i class="fas fa-sign-in-alt"> visitar</i>
                                </button>
                            </form>

                        </div>
                        <div class="col-4">
                            <form action="../emprendimiento/edit/${it.id}">
                                <button type="submit"  class="btn btn-primary" style="align-content:center ">
                                    <i class="fas fa-edit"> editar</i>
                                </button>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>

    </g:each>
</div>
</body>
</html>