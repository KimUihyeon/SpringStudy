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
		                        	<a href="../directory/modify?id=${directory.id}">		                        		
		                        		<i class="fas fa-edit"></i>
		                        	</a>
		                        	<i class="fas fa-trash-alt icon deleteIcon" id="deleteDirectory"  data-key="${directory.id}" data-title="${directory.title}"></i>
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
			let key = -1;

			/* 팝업만들기 */
			/* 팝업만들기 */
        	var modalSetting = new modalSet();
        	modalSetting.title = "삭제";
        	modalSetting.context = "내용";
    		modalSetting.okFunction = function(){ deleteService() };
    		modalSetting.init();

        	function deleteService(){
        		var form = createForm('POST','../directory/delete');
        		var input = createInputData('id',key);
        		form.appendChild(input);
        		$(document.body).append(form);
        		form.submit();
        	}
        	
        	

			/* 팝업만들기 */
			/* 팝업만들기 */
        	$('.deleteIcon').on('click',function(){
        		let _$this = $(this);
        		
        		key = _$this.attr('data-key');
        		let title = _$this.attr('data-title');
        		
        		modalSetting.context = "["+ title + "] 게시물을 삭제하시겠습니까? <br> 하위 모든 게시물이 모두 삭제됩니다.";
        		modalSetting.popup();        		
        	});
        	
			
		})
    </script>
</body>
</html>