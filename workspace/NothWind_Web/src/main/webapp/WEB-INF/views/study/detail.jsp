<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
	<div>
		${product.title}
	</div>
	<div>
		${product.price}.0 $
	</div>
	
	<button id="goList"   class="btn btn-success">목록으로</button>
	<button id="goModify" class="btn btn-info">수정하기</button>
 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
	let listUrl = "./list?pageNo=${listPageNo}";
	let modifyurl = "./modify?pageNo=${listPageNo}&no=${product.no}";
	$('#goList').on('click',function(){
		location.href= listUrl;
	});
	
	
	$('#goModify').on('click',function(){
		location.href= modifyurl;
	});
	
</script>
</body>
</html>