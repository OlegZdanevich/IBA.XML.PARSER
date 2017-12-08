<%@ page import="com.iba.project.entity.book.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Зданевич Олег
  Date: 07.12.2017
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <title>XML view</title>

    <link href="resources/css/bootstrap.css" rel="stylesheet"/>
    <link href="resources/css/style.css" rel="stylesheet"/>
</head>
<body>

<div id="uac">
    <table class="table table-striped">
        <tr>
            <td>id</td>
            <td>Author Name</td>
            <td>Author LastName</td>
            <td>Name</td>
            <td>Price</td>
        </tr>
        <c:forEach var="elem" items="${sessionScope.xmlTable}" varStatus="status">
            <tr>

                <td><c:out value="${ status.count }"/></td>
                <td><c:out value="${ elem.auther.name }"/></td>
                <td><c:out value="${ elem.auther.lastName }"/></td>
                <td><c:out value="${ elem.name }"/></td>
                <td><c:out value="${ elem.price }"/></td>

                <td>
                <form action="changeElement" method="Post">
                    <input type="hidden" name="id" value="<c:out value="${ status.count-1 }"/>">
                    <input type="hidden" name="action" value="Edit">
                    <input type="submit" class="btn btn-primary btn-sm" value="Edit">
                </form>
                </td>

                <td>
                <form action="changeElement" method="Post">
                    <input type="hidden" name="id" value="<c:out value="${ status.count-1 }"/>">
                    <input type="hidden" name="action" value="Delete">
                    <input type="submit" class="btn btn-danger btn-sm" value="Delete">
                </form>
                </td>


            </tr>
        </c:forEach>


    </table>
</div>

</body>
</html>
