<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main" />
    <style>
    .cartaIndex {
        align-items: center;
        overflow: hidden;
        margin: 5%;
        text-align: center;
        border-radius: 2rem;

    }

    </style>

    <title>Página principal</title>
</head>
<body style="text-align: -webkit-center">
<div class="row">
<div class="col-sm-12 col-lg-6">
<div class="cartaIndex">
    <asset:image class="card-img-top" src="mirador_1.jpg"/>
    <div class="card-body" style="background-color: #2c3e50">
        <p class="card-text" >
    <p>MUNICIPALIDAD DE TOLHUIN</p>
    <p>La Municipalidad de Tolhuin se encuentra a solo 100 Km de Ushuaia y 105 Km de Río Grande, volviéndolo a un paso obligado para todos los que transitan la Ruta Nacional Nº 3, que cruza toda la Provincia.</p>

        </p>
    </div>
</div>
</div>
    <div class="col-sm-12 col-lg-6">
<div class="row" style="margin-top: 5%;white-space: pre-line;font-family: 'Font Awesome 5 Free';color: black">
    <div class="col-sm-12 col-md-6">
    <div class="card "style="background-color: #00FFFF">
        <a>Si desea mirar los emprendimientos mas buscados de Tolhuin, clickee aqui!</a>
        <a href="../main/Emprendimientos" class="btn btn-primary"><i class="fas fa-industry"> Emprendimientos Populares</i></a>

    </div>
    </div>
    <div class="col-sm-12 col-md-6">
        <div class="card" style="background-color: #00FFFF">
            <a>Una vista completa de todos los empredimientos de la ciudad en el mapa </a>
            <a href="../map/mapa" class="btn btn-primary"><i class="fas fa-map-marked-alt"> Mirar mapa de Emprendimiento</i></a>

    </div>
    </div>
    <sec:ifAnyGranted roles="ROLE_ANONYMOUS">
    <div class="col-sm-12 col-md-6">
        <div class="card"style="background-color: #00FFFF">
            <a>Si quiere registrarse en la pagina para cargar sus emprendimientos,clickee aqui!</a>
            <a href="../usuario/create" class="btn btn-primary"><i class="fas fa-user"> Registrarse</i></a>
    </div>
    </div>
    <div class="col-sm-12 col-md-6">
        <div class="card"style="background-color: #00FFFF">
            <a>Si ya tiene una cuenta como emprendedor o invesitigador, Clickee aqui!</a>
            <a href="../login/auth" class="btn btn-primary"><i class="fas fa-sign-in-alt"> Iniciar Sesion</i></a>
    </div>
    </div>

    </sec:ifAnyGranted>
</div>
</div>
</div>
    </body>
</html>