<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
<!-- Bootstrap CSS -->
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
		crossorigin="anonymous">
</head>
<body>
<div class="container mt-4">
    <form action="LoginController" method="POST">
        <div class="form-group row">
            <label class="col-sm-3 col-form-label" for="inputLogin">User Name:</label>
            <div class="col-sm-5">
                <input class="form-control" id="inputLogin" type="text" name="username" value='<%=request.getParameter("username")%>' placeholder="Login"/>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-3 col-form-label" for="inputPassword">Password:</label>
            <div class="col-sm-5">
                <input class="form-control" id="inputPassword" type="password" name="password" placeholder="Password"/>
            </div>
        </div>
        <div class="form-group row">
            <div class="col">
                <c:url value="/registration" var="registrationURL" />
                <a href="${registrationURL}" class="btn btn-warning" role="button">Add new USER</a>
            </div>
            <div class="col">
                <button type="submit" class="btn btn-primary">Login</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
