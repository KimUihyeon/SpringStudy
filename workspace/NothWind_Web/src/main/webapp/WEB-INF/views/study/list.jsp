<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style>
	.input_l{
		max-width: 120px;
	}
	.input_s{
		max-width: 50px;
	}
</style>
</head>
<body>
	<section class="center-block" style="width: 800px">
		<form action="../study/list" method="get">
			<input type="hidden" value="1" name="pageNo">
			<label>상품번호</label>
			<input class="input_l" name="productNo" value="${sreach.productNo}">
			<label>상품명</label>
			<input class="input_l" name="keyword" value="${sreach.keyword}">
			<label>가격</label>
			<input class="input_s" name="minPrice" value="${sreach.minPrice}">~<input class="input_s" name="maxPrice" value="${sreach.maxPrice}">
			<button type="submit">검색</button>
		</form>
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
						<a href="./detail?pageNo=${pageNo}&no=${product.no}">${product.title}</a>
					</td>
					<td>${product.price}.0$</td>
					<td>
						<a href="./delete?pageNo=${pageNo}&no=${product.no}">삭제</a>
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
		  	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="idx">
		  		<c:if test="${paging.page == idx}">
				    <li class="active  listCtrl">
				      <span>${idx}</span>
				    </li>
		  		</c:if>
		  		
		  		<c:if test="${paging.page != idx}">
				    <li class="listCtrl">
				      <span>${idx}</span>
				    </li>
		  		</c:if>
		  	</c:forEach>
	    
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
		location.href = "../study/register?pageNo=${pageNo}";
	});
	
	let listMove = function (idx){
		location.href = "../study/list?pageNo="+idx+
										"&productNo=${sreach.productNo}"+
										"&keyword=${sreach.keyword}"+
										"&minPrice=${sreach.minPrice}"+
										"&maxPrice=${sreach.maxPrice}";
	}
	
	$('.listCtrl').each(function(idx){
		let _$this = $(this);
		_$this.on('click',function(){
			var pageNumber = _$this.find(' > span').text();
			console.log(_$this.find(' > span'));
			listMove(pageNumber);
		});
	})
</Script>
</body>
</html>