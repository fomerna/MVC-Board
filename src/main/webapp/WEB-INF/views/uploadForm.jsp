<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        iframe {
            width: 0px;
            height: 0px;
            border: 0px
        }
    </style>
</head>
<body>
<form action="uploadForm" id='form1' method="post" enctype="multipart/form-data" target="zeroFrame">
    <input type='file' name='file'> <input type='submit'>
</form>

<iframe name="zeroFrame"></iframe>

</body>
<script type="text/javascript">
    function addFilePath(msg) {
        alert(msg);
        document.getElementById("form1").reset();
    }
</script>
</html>
