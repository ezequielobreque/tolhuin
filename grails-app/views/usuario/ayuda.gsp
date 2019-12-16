<%--
  Created by IntelliJ IDEA.
  User: ezequiel PC
  Date: 14/12/2019
  Time: 13:02
--%>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'usuario.label', default: 'Usuario')}" />
    <title><g:message code="default.create.label" args="[entityName]" /></title>
    <asset:javascript src="jquery-2.2.0.min.js"/>
    <asset:stylesheet src="mycss.css"/>

</head>
<body>
<div id="show-emprendimiento" class="contentShow" style="background-color: white;color:blue;text-align: initial" role="main">


    <!--<p><a style="text-decoration: underline" href="#" id="alternar-respuesta-ej1">Iniciar session</a></p>

    <div id="respuesta-ej1" style="display:none">Respuesta...</div>-->
    <sec:ifAnyGranted roles="ROLE_ANONYMOUS">
        <p><a   style="text-decoration: underline" href="#" class="alternar-respuesta">¿Cómo me registro en la pagina?</a></p>
        <p class="respuesta" style="display:none;color: black">
        1. selecciona la pestaña usuarios<br>
        2. selecciona registrarse<br>
        3. ingresa sus datos para la nueva cuenta<br>
        </p>
        <br>
        <p><a   style="text-decoration: underline" href="#" class="alternar-respuesta">¿Cómo inicio sesion?</a></p>
        <p class="respuesta" style="display:none;color: black">
            Nota: es necesario estar registrado primero<br>
        1. seleccionar usuarios<br>
        2. seleccionar iniciar sesión<br>
        3. ingresar sus datos<br>
        </p>
        <br>
    </sec:ifAnyGranted>
    <sec:ifAnyGranted roles="ROLE_EMPRENDEDOR,ROLE_INVESTIGADOR,ROLE_ADMIN,ROLE_MINISTERIO">
        <p><a   style="text-decoration: underline" href="#" class="alternar-respuesta">¿Cómo registro un emprendimiento?</a></p>
        <p class="respuesta" style="display:none;color: black">
            1. seleccionar la pestaña de  emprendimientos<br>
        2. seleccionar crear nuevo emprendimiento<br>
        3. rellenar todos los datos del emprendimiento<br>
        3. crear emprendimiento<br>
        4. esperar validación(en caso de ser administrador o municipal este emprendimiento ya está validado<br>
        </p>
        <br>
        <p><a   style="text-decoration: underline" href="#" class="alternar-respuesta">¿Cómo actualizo un emprendimiento?</a></p>
        <p class="respuesta" style="display:none;color: black">1. Ingresar a la vista del emprendimiento<br>
        2.Seleccionar editar<br>
        3.Modificar el emprendimiento<br>
        4.Aceptar la edición<br>
        </p>
        <br>
    </sec:ifAnyGranted>


    <p><a   style="text-decoration: underline" href="#" class="alternar-respuesta">¿Cómo hago una busqueda especifica de un emprendimiento?</a></p>
    <p class="respuesta" style="display:none;color: black">
        <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/RrORG8UVcA0" allowfullscreen></iframe>
        </p>
    <br>
    <p><a   style="text-decoration: underline" href="#" class="alternar-respuesta">¿Cómo utilizar las capas del mapa?</a></p>
    <p class="respuesta" style="display:none;color: black;">


        <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/i1vq0Q2OOA8" allowfullscreen></iframe>

    </p>
    <br>

    <p><a   style="text-decoration: underline" href="#" class="alternar-respuesta">¿Cómo descargo la información que busqué?</a></p>
    <p class="respuesta" style="display:none;color: black"><iframe class="embed-responsive-item" src="https://www.youtube.com/embed/iymjPyLQ0x8" allowfullscreen></iframe></p>
    <br>
    <p><a   style="text-decoration: underline" href="#" class="alternar-respuesta">¿Como puedo descargar la información de un emprendimiento?</a></p>
    <p class="respuesta" style="display:none;color: black"><iframe class="embed-responsive-item" src="https://www.youtube.com/embed/SL2LjWlmiFU" allowfullscreen></iframe></p>
    <br>
    <p><a   style="text-decoration: underline" href="#" class="alternar-respuesta">Perdi la contraseña! ¿qué hago?</a></p>
    <p class="respuesta" style="display:none;color: black">Contacte al administrador a travez de este email</p>
    <br>



<sec:ifAnyGranted roles="ROLE_MINISTERIO,ROLE_ADMIN">
    <p><a   style="text-decoration: underline" href="#" class="alternar-respuesta">¿Cómo importar emprendimiento mediante excel?</a></p>
    <p class="respuesta" style="display:none"><iframe class="embed-responsive-item" src="https://www.youtube.com/embed/pfNOih_0q2w" allowfullscreen></iframe></p>
</sec:ifAnyGranted>


    <a href="#" hidden id="alternar-todo">Mostrar y ocultar todas las respuestas</a>
</div>



<sec:ifAnyGranted roles="'ROLE_ANONYMOUS','ROLE_ADMIN','ROLE_MINISTERIO','ROLE_ADMINISTRADOR','ROLE_EMPRENDEDOR','ROLE_INVESTIGADOR'">
</sec:ifAnyGranted>



<script>

    $(document).ready(function(){
        $('.alternar-respuesta').on('click',function(e){
            $(this).parent().next().toggle('fast');
            e.preventDefault();
        });
        $('#alternar-todo').on('click',function(e){
            $('.respuesta').toggle('slow');
            e.preventDefault();
        });
    });

</script>
</body>
</html>