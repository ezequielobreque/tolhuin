<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'emprendimiento.label', default: 'Emprendimiento')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
        <style>
        #mapaid { height: 100px;
            width:100px;


        }

        </style>
        <!-- Bootstrap assets -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

        <!-- Leaflet assets -->
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.3.1/dist/leaflet.css" integrity="sha512-Rksm5RenBEKSKFjgI3a41vrjkw4EVPlJ3+OiI65vTjIdo9brlAacEuKOiQ5OFh7cOI1bkDwLqdLw3Zg0cRJAAQ==" crossorigin="" />
        <script src="https://unpkg.com/leaflet@1.3.1/dist/leaflet-src.js" integrity="sha512-IkGU/uDhB9u9F8k+2OsA6XXoowIhOuQL1NTgNZHY1nkURnqEGlDZq3GsfmdJdKFe1k1zOc6YU2K7qY+hF9AodA==" crossorigin=""></script>

    </head>
    <body>


    <div id="show-emprendimiento" class="contentShow" role="main">
    <g:form resource="${this.emprendimiento}" method="POST">

            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
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

                <div class="creacion">
                    <div class="fieldcontain">
                        <label for="nombre">Nombre del emprendimiento </label><input type="text" name="nombre" value="" id="nombre">
                    </div>
                    <div class="fieldcontain">
                        <label for="usuario">Nombre del dueño </label><input type="text" name="usuario" value="" id="usuario">
                    </div>
                    <f:all bean="emprendimiento" except="longitud,latitud,featuredImageBytes,habilitado,featuredImageContentType,usuario,nombre"/>

                    <div class="crear">
                        <label for="habilitado">Emprendimiento habilitado</label>
                    <input type="hidden" name="_habilitado"><input type="checkbox" name="habilitado" id="habilitado">
                    </div>
                    <div class="fieldcontain">
                        <label for="longitud">longitud </label><input type="text" id="longitud" name="longitud" />
                    </div>
                    <div class="fieldcontain">
                        <label for="latitud">latitud </label><input type="text" id="latitud" name="latitud" />
                    </div>

        <div class="fieldcontain" style="text-align: center">
                    <button  type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                        <i class="fas fa-map"> Elegir ubicacion en el mapa</i>
                    </button>
        </div>



                </div>

    <fieldset class="botonesDelShow">

       <g:submitButton name="create" class="btn btn-success" value="${message(code: 'default.button.create.label', default: 'Create')}" />


    </fieldset>
        </g:form>

    </div>

    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Ubicacion en el mapa</h4>
                </div>
                <div class="modal-body">

                    <!-- map container -->
                    <div id="map" style="height: 300px;width: 100%"></div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">Guardar</button>
                </div>
            </div>
        </div>
    </div>

    <script>


        /*mapa*/


        var map = L.map('map').setView([-54.5108299, -67.1955032], 13);

        L.marker([48.86, 2.35]).addTo(map);

        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
            attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
        }).addTo(map);


        // Comment out the below code to see the difference.
        $('#myModal').on('shown.bs.modal', function() {
            map.invalidateSize();
        });

        var popup = L.popup();

        function onMapClick(e) {
            popup
                .setLatLng(e.latlng)
                .setContent("este es tu lugar en el mapa? " + e.latlng.toString())
                .openOn(map);
            var latitud=e.latlng.lat.toFixed(6);

            var longitud=e.latlng.lng.toFixed(6);
            document.getElementById('latitud').value = latitud.replace(".",",");
            document.getElementById('longitud').value = longitud.replace(".",",");
        }

        map.on('click', onMapClick);






    </script>
    </body>
</html>
