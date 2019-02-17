<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4>${error.getMessage()}</h4>
	
	<ul>
		<c:forEach var="err" items="${error.getStackTrace()}">
			<li>${err.toString()}</li>
		</c:forEach>
	</ul>
</body>
</html>