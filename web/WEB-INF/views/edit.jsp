<%--
  Created by IntelliJ IDEA.
  User: CatsUser
  Date: 08.12.2017
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <link href="resources/css/bootstrap.css" rel="stylesheet"/>
    <link href="resources/css/style.css" rel="stylesheet"/>
</head>
<body>
<div id="uac">
    <form action="changeElement" class="form-horizontal" role="form" method="POST">
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
            </div>
        </div>
    </form>
</div>

</body>
</html>
