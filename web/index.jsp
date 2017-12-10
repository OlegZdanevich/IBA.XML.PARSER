<%--
  Created by IntelliJ IDEA.
  User: Зданевич Олег
  Date: 07.12.2017
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Download Your File</title>

    <link href="resources/css/bootstrap.css" rel="stylesheet"/>
    <link href="resources/css/style.css" rel="stylesheet"/>

</head>
<body>

<div id="uac">
    <c:if test="${requestScope.status==-1}">
        <h3>You Should Download Only XML files</h3>
    </c:if>

    <c:if test="${requestScope.status==-2}">
        <h3>Cannot Download File</h3>
    </c:if>

    <form action="upload" method="POST" enctype="multipart/form-data">
        <input type="file" name="file"/>
        <input type="submit" class="btn btn-primary" value="Send File"/>
    </form>
</div>

</body>
</html>
