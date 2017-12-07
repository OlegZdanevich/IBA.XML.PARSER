<%--
  Created by IntelliJ IDEA.
  User: Зданевич Олег
  Date: 07.12.2017
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Download Your File</title>

  <link href="resources/css/bootstrap.css" rel="stylesheet"/>
  <link href="resources/css/style.css" rel="stylesheet"/>

</head>
<body>

<div id="uac">
  <form action="upload" method="POST" enctype="multipart/form-data">
    <input type="file" name="file" />
    <input type="submit" class="btn btn-primary"/>
  </form>
</div>

</body>
</html>
