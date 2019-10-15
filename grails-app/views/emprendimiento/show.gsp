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


            doc.text(20, 45, 'direccion:');
            doc.text(50, 45, '${this.emprendimiento.direccion}');



            // Add new page
            doc.addPage();
            doc.text(20, 20, 'Visit CodexWorld.com');

            // Save the PDF
            doc.save('document.pdf')
        }

        </script>
    </head>
    <body>

        <a href="#show-emprendimiento" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>

        <div id="show-emprendimiento" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <div class="crear">
            <g:if test="${this.emprendimiento.featuredImageBytes}">
                <img src="<g:createLink controller="emprendimiento" action="featuredImage" id="${this.emprendimiento.id}"/>" width="400"/>
            </g:if>
            <f:display bean="emprendimiento" except="featuredImageBytes,featuredImageContentType" />

        </div>
            <g:form resource="${this.emprendimiento}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.emprendimiento}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                    <g:link class="fas fa-image" action="editFeaturedImage" resource="${this.emprendimiento}">agregar imagen del emprendimiento</g:link>

                </fieldset>

            </g:form>

        </div>




    <button onclick="generatePDF()">Generate PDF</button>
    </body>
</html>
