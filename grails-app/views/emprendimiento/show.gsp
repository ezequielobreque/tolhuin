<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'emprendimiento.label', default: 'Emprendimiento')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
        <asset:javascript src="jspdf.min.js"/>
        <script>
        function generatePDF() {
            var doc = new jsPDF();
            doc.setFontSize(32);
            doc.text(70, 20, '${this.emprendimiento.nombre}');
            doc.setFontSize(16);
            doc.text(20, 35, 'Nombre:');
            doc.text(50, 35, '${this.emprendimiento.nombre}');


            doc.text(20, 45, 'Direccion:');
            doc.text(50, 45, '${this.emprendimiento.direccion}');

            doc.text(20, 55, 'Dueño:');
            doc.text(50, 55, '${this.emprendimiento.usuario}');

            doc.text(20, 65, 'Telefono:');
            doc.text(50, 65, '${this.emprendimiento.telefono}');

            doc.text(20, 75, 'Habilitado:');
            if('${this.emprendimiento.habilitado}' == 'true'){
            doc.text(50, 75, 'Si,esta habilitado');
            }else{
                doc.text(50, 75, 'No,no esta habilitado');
            }
            doc.text(20, 85, 'Validado:');
            if('${this.emprendimiento.validado}' == 'true'){
            doc.text(50, 85, 'Si,esta validado');
           }else{
            doc.text(50, 85, 'No, no esta validado');
           }

            doc.text(20, 95, 'Rubro:');
            doc.text(50, 95, '${this.emprendimiento.rubro.nombre}');

            doc.text(20, 105, 'Sector:');
            doc.text(50, 105, '${this.emprendimiento.rubro.sector.nombre}');

            doc.text(20, 115, 'Ambito:');
            doc.text(50, 115, '${this.emprendimiento.ambito.nombre}');

            doc.text(20, 125, 'Descripcion:');
            doc.text(52, 125, '${this.emprendimiento.descripcion}');





            // Add new page
            doc.addPage();
            doc.text(20, 20, 'Visit CodexWorld.com');

            // Save the PDF
            doc.save('document.pdf')
        }

        </script>
    </head>
    <body>



        <div id="show-emprendimiento" class="contentShow" role="main">
            <h1>${this.emprendimiento.nombre}</h1>

            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <div class="crear">
            <g:if test="${this.emprendimiento.featuredImageBytes}">
                <img src="<g:createLink controller="emprendimiento" action="featuredImage" id="${this.emprendimiento.id}"/>" width="100%" STYLE="margin:1rem"/>
            </g:if>
            <f:display bean="emprendimiento" except="featuredImageBytes,featuredImageContentType" />

        </div>
        <fieldset class="botonesDelShow">
        <sec:ifAnyGranted roles="ROLE_MINISTERIO,ROLE_ADMIN,ROLE_ADMINISTRADOR">

            <g:link type="button" class="btn btn-google" action="edit" resource="${this.emprendimiento}" style="background-color:#f39c12 "><i class="fas fa-edit"> <g:message code="default.button.edit.label" default="Edit" /></i></g:link>


            <button class="btn btn-facebook"><g:link action="editFeaturedImage" resource="${this.emprendimiento}" style="color: white"><i class="fas fa-image">  agregar imagen</i></g:link></button>



        <button class="btn btn-borrado"> <g:form resource="${this.emprendimiento}" method="DELETE">

                        <i class="fas fa-trash"><input class="delete" type="submit" style=" color: white;border: aliceblue;background-color: #e74c3c" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></i>

            </g:form> </button>

        </sec:ifAnyGranted>
            <sec:ifAnyGranted roles="ROLE_EMPRENDEDOR">

                <g:if test="${this.emprendimiento.user!=null}">
                <g:if test="${sec.username() == this.emprendimiento.user.user.getUsername()}">

                <g:link type="button" class="btn btn-google" action="edit" resource="${this.emprendimiento}" style="background-color:#f39c12 "><i class="fas fa-edit"> <g:message code="default.button.edit.label" default="Edit" /></i></g:link>




                    <button class="btn btn-facebook"><g:link action="editFeaturedImage" resource="${this.emprendimiento}" style="color: white"><i class="fas fa-image">  agregar imagen</i></g:link></button>


                <button class="btn btn-borrado"> <g:form resource="${this.emprendimiento}" method="DELETE">

                    <i class="fas fa-trash"><input class="delete" type="submit" style=" color: white;border: aliceblue;background-color: #e74c3c" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></i>
                </g:form> </button>
            </g:if>
                </g:if>



            </sec:ifAnyGranted>

                    <button onclick="generatePDF()" class="btn btn-danger" ><i class="fas fa-file-pdf"> Crear PDF</i></button>

                    <form action="/map/mapa">
                        <button type="submit" name="id" value="${this.emprendimiento.id}"     class="btn btn-success" style="align-content:center ">
                            <i class="fas fa-map"> mapa</i>
                        </button>
                    </form>


        </fieldset>
        </div>




    </body>
</html>
