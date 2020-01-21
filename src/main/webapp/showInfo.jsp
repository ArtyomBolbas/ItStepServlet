<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1px">
		<tr>
			<th>Name</th>
			<th>Age</th>
		</tr>
		<c:forEach var="person" items="${persons}">
			<tr>
				<td><c:out value="${person.key}"/></td>
				<td><c:out value="${person.value}"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
