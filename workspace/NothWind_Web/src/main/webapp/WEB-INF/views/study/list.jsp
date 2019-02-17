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
		<button id="addProduct">상품 추가</button>
		<table class="table">
			<thead>
				<tr>
					<th>no</th>
					<th>상품명</th>
					<th>가격($)</th>
					<th></th>
				</tr>
			</thead>
		
			<c:forEach var="product" items="${products}">
				<tr>
					<td>${product.no}</td>
					<td>
						<a href="./detail?pageNo=${listPageNo}&no=${product.no}">${product.title}</a>
					</td>
					<td>${product.price}.0$</td>
					<td>
						<a href="./delete?pageNo=${listPageNo}&no=${product.no}">삭제</a>
					</td>
				</tr>
			</c:forEach>
			
		</table>	
				
		<nav>
		  <ul class="pagination">
		    <li>
		      <span>
		        <span>&laquo;</span>
		      </span>
		    </li>
		    <li class="active">
		      <span>1 <span class="sr-only">(current)</span></span>
		    </li>
		    
		    <li>
		      <span>
		        <span>»</span>
		      </span>
		    </li>		    
		  </ul>
		</nav>
		
		<div>${testObj}</div>
	</section>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<Script>
	$('#addProduct').on('click',function(){
		location.href = "../study/register?pageNo=${listPageNo}";
	});
</Script>
</body>
</html>