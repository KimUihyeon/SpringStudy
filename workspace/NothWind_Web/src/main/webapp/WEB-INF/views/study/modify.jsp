<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
	<section class="center-block" style="width: 800px">
		<form action="./modify"  method="post">
			<input type="hidden" value="${product.no}" name="no">
			<div>
				<label>상품명</label><input value="${product.title}" name="title">
			</div>
			<div>
				<label>가격</label><input value="${product.price}" name="price">
			</div>
			<div>
				<input id="ok" type="submit" value="확인">
				<input id="back" type="button" value="취소">
				<input id="goList" type="button" value="목록으로">
			</div>
			
		</form>
	</section>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
${pageNo}
<script type="text/javascript">
	let backUrl = "./detail?pageNo=${pageNo}&no=${product.no}";
	let listUrl = "./list?pageNo=${pageNo}";

	$('#back').on('click',function(){
		location.href = backUrl;
	});
	$('#goList').on('click',function(){
		location.href = listUrl;
	});
</script>
</body>
</html>