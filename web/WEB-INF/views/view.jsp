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

    <c:if test="${requestScope.answer==-1}">
        <h3>There some problems with editing</h3>
    </c:if>
    <table class="table table-striped">
        <tr>
            <td>Author Name</td>
            <td>Author LastName</td>
            <td>Name</td>
            <td>Price</td>
            <td>Sort by:</td>
            <td>
                <form action="changeElement" method="Post">
                    <input type="hidden" name="action" value="Sort">
                    <select name="elements">
                        <option>Author Name</option>
                        <option>Author LastName</option>
                        <option>Name</option>
                        <option>Price</option>
                    </select>
                    <input type="submit" class="btn btn-success btn-sm" value="Sort">
                </form>
            </td>
        </tr>
        <c:forEach var="elem" items="${sessionScope.xmlTable}" varStatus="status">
            <tr>
                <td><c:out value="${ elem.auther.name }"/></td>
                <td><c:out value="${ elem.auther.lastName }"/></td>
                <td><c:out value="${ elem.name }"/></td>
                <td><c:out value="${ elem.price }"/></td>

                <td>
                <form action="changeElement" method="Post">
                    <input type="hidden" name="id" value="${ status.count-1 }">
                    <input type="hidden" name="action" value="Edit">
                    <input type="submit" class="btn btn-primary btn-sm" value="Edit">
                </form>
                </td>

                <td>
                <form action="changeElement" method="Post">
                    <input type="hidden" name="id" value="${ status.count-1 }">
                    <input type="hidden" name="action" value="Delete">
                    <input type="submit" class="btn btn-danger btn-sm" value="Delete">
                </form>
                </td>


            </tr>
        </c:forEach>


    </table>
    <form action="changeElement" method="Post">
        <input type="hidden" name="action" value="Create">
        <input type="submit" class="btn btn-primary btn-lg" value="Create">
    </form>
</div>

</body>
</html>
