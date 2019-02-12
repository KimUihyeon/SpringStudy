<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

	<c:forEach   var="test" items="${testList}">
		<div>${test.name}</div>
	</c:forEach>
	
	<div>${testObj}</div>
</body>
</html>
