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

	<table>
		
		<c:forEach   var="test" items="${testList}">
			<tr>
				<td>${test.no}</td>
				<td>${test.title}</td>
			</tr>
		</c:forEach>
		
		
		<form action="fileUpload" method="post" id="form1" enctype="multipart/form-data" >
			<input type="file" name="file">
			<input type="submit">
		</form>

	</table>	
	<div>${testObj}</div>
</body>
</html>
