<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <li class="list-group-item">
                    <div>
                        <div>
                            <img class="group-icon">
                            <strong>GroupName</strong>
                        </div>
                        <hr>
                        <div style="margin-left: 60px">
                            <i>Description</i>
                        </div>
                    </div>
                </li>
            </ul>
        </section>

    </div>
    
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
    <script>
    </script>
</body>
</html>