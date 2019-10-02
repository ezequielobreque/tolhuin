<%--
  Created by IntelliJ IDEA.
  User: ezequielobreque
  Date: 27/9/19
  Time: 17:45
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>

<script>


    var formData = new FormData();
    formData.append('File', $('#file_input')[0].files[0], 'my_file.xlsx');

    $.ajax({
        url: 'https://v2.convertapi.com/convert/xlsx/to/pdf?Secret=Z8SzzeVrYkpoeXve',
        data: formData,
        processData: false,
        contentType: false,
        method: 'POST',
        success: function(data) {
            console.log(data);
        }
    })


</script>

</body>




</html>