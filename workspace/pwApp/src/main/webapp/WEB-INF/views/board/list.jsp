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
            	<c:forEach var="board" items="${boards}">
	                <li class="list-group-item">
	               		<a href="../main/detail?id=${board.id}">
		                    <div>
		                        <div>${board.context}
		                            <img class="group-icon">
		                            <strong>${board.directoryDTO.title}</strong>
		                        </div>
		                        <hr>
		                        <div style="margin-left: 60px">
		                            <i>${board.directoryDTO.description}</i>
		                        </div>
		                    </div>
	               		</a>
	                </li>
            	</c:forEach>
            </ul>
        </section>

    </div>
    
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
    <script>
    </script>
</body>
</html>