<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
    <div id="wrap">
		<%@ include file="/WEB-INF/views/common/menu.jsp" %>

        <section>
            <ul class="list-group content-list-box">
            	
            	<c:forEach var="directory" items="${directories}">
            	
	                <li class="list-group-item" style="border-color: ${directory.color}">
		                    <div>
		                        <div>
            						<a href="../main/list?type=${directory.id}">
		                            <img class="group-icon" src="../${directory.icon}">
		                            <strong>${directory.title}</strong>
		                            </a>
		                        </div>
		                        <div class="detailControlBttonBox smallIcon">
		                        	<a href="../directory/modify?id=${directory.id}">		                        		<i class="fas fa-edit"></i>
		                        	</a>
		                            <i class="fas fa-trash-alt" id="deleteDirectory"></i>
		                        </div>
		                    </div>
	                </li>
            	
            	</c:forEach>
            </ul>
        </section>

    </div>
    
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	<script>
		$(function(){
			$('#deleteDirectory').on('click',function(){
				alert('삭제로직');
			});
		})
    </script>
</body>
</html>