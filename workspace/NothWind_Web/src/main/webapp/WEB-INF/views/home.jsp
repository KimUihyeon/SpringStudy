<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<body>


	<section>
		<table class="table">
			<thead>
				<tr>
					<th>1</th>
					<th>2</th>
				</tr>
			</thead>
		
			<c:forEach   var="test" items="${testList}">
				<tr>
					<td>${test.no}</td>
					<td>${test.title}</td>
				</tr>
			</c:forEach>
			
		</table>	
		
	
		<form action="fileUpload" method="post" id="form1" enctype="multipart/form-data" >
			<div class="form-group">
				<label for="exampleInputFile">파일 업로드</label>
				<input type="file" id="exampleInputFile">
			</div>
			<input type="submit">
		</form>

		<div>${testObj}</div>
	</section>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>
