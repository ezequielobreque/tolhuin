<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Excel Importer</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<asset:javascript src="jspdf.min.js"/>
<script>
    function generatePDF() {
        var doc = new jsPDF();
        doc.setFontSize(16);
        doc.text(20, 35, 'Nombre:');
        doc.text(50, 35, '${this.text}');

        // Save the PDF
        doc.save('document.pdf')
    }

</script>

<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h2>Excel Importer</h2>
        <g:if test="${flash.message}">
            <div class="message" role="alert">
                ${flash.message}
            </div>
        </g:if>
        <g:uploadForm action="uploadFile" >
            <fieldset>
                <div class="fieldcontain">
                    <input type="file" name="excelFile" />
                </div>
            </fieldset>
            <fieldset>
                <g:submitButton name="uploadbutton" class="save" value="Upload" />
            </fieldset>
        </g:uploadForm>
    </section>

       <!-- <input type="text" name="dueno" hidden="true" id="dueno" value="${dueno}">
        <input type="text" name="dni" hidden="true" id="dni" value="${dni}">
        <input type="text" name="direccion" hidden="true" id="dirreccion" value="${direccion}">
        <input type="text" name="nombre" hidden="true" id="nombre" value="${nombre}">
        <input type="text" name="si" hidden="true" id="si" value=${true}>-->

        <button class="btn btn-primary" onclick="generatePDF()"><i class=""> Generar Log</i></button>




</div>

</body>