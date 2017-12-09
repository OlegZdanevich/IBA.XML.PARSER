<%--
  Created by IntelliJ IDEA.
  User: CatsUser
  Date: 08.12.2017
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
    <link href="resources/css/bootstrap.css" rel="stylesheet"/>
    <link href="resources/css/style.css" rel="stylesheet"/>
</head>
<body>
<div id="uac">
    <form action="changeElement" class="form-horizontal" role="form" method="POST">
        <input type="hidden" name="action" value="Update">

        <div class="form-group">
            <label for="inputNameAuthor" class="col-sm-2 control-label">Author Name</label>
            <div class="col-sm-10">
                <input name="inputNameAuthor" class="form-control" id="inputNameAuthor"
                       value="${sessionScope.book.auther.name}">
            </div>
        </div>

        <div class="form-group">
            <label for="inputLastNameAuthor" class="col-sm-2 control-label">Author LastName</label>
            <div class="col-sm-10">
                <input name="inputLastNameAuthor" class="form-control" id="inputLastNameAuthor"
                       value="${sessionScope.book.auther.lastName}">
            </div>
        </div>

        <div class="form-group">
            <label for="inputNameOfBook" class="col-sm-2 control-label">Name Of Book</label>
            <div class="col-sm-10">
                <input name="inputNameOfBook" class="form-control" id="inputNameOfBook"
                       value="${sessionScope.book.name}">
            </div>
        </div>

        <div class="form-group">
            <label for="inputPriceOfBook" class="col-sm-2 control-label">Price Of Book</label>
            <div class="col-sm-10">
                <input name="inputPriceOfBook" class="form-control" id="inputPriceOfBook"
                       value="${sessionScope.book.price}">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" class="btn btn-primary" value="Update"/>
            </div>
        </div>
    </form>
</div>

</body>
</html>
