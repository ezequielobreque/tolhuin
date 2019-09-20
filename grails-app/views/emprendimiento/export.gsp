<%@ page import="tolhuin.Emprendimiento" %>
<!DOCTYPE html>
<html lang="en">
<head>

</head>
<body>

<div class="paginateButtons">
    <g:paginate total="${tolhuin.Emprendimiento.count()}" />
</div>
<export:formats formats="['csv', 'excel', 'ods', 'pdf', 'rtf', 'xml']" />

</body>
</html>