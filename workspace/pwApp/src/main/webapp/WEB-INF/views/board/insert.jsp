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

        <section class="">
            <ul class="list-group content-list-box">
                <li class="list-group-item">
                    <div>
                        <form id="formTag" action="../main/insert" method="POST" >
                            <div>
                                <img class="group-icon" id="iconImg">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default dropdown-toggle colorSet" id="groupBox" data-toggle="dropdown" aria-expanded="false" name='group'>
                                    </button>
                                <input type="hidden" id="groupId" name="groupId" >
                                <ul class="dropdown-menu" role="menu" >
                                	<c:forEach var="directory" items="${directories}">
                                    	<li data-key='${directory.id}' data-color="${directory.color}" data-img="${directory.icon}">${directory.title}</li>
                                	</c:forEach>
                                </ul>
                                </div>
                            </div>
                            <hr>
                            <div style="margin-left: 60px">
                                <textarea type="text" class="form-control" placeholder="description" name='context' id='description' aria-describedby="basic-addon2"></textarea>
                            </div>
                            <div class="content-box">
                                <div class="content-item">
                                    <input type="text" class="form-control" placeholder="id" id="id" name='contextId' aria-describedby="basic-addon2">
                                </div>
                                <div class="content-item">
                                    <input type="text" class="form-control" placeholder="pw" id="pw" name='contextPw' aria-describedby="basic-addon2">
                                </div>
                                <div class="content-item">
                                    <input type="text" class="form-control" placeholder="etc" id="etc" name='etc' aria-describedby="basic-addon2">
                                </div>
                                <div class="content-item">
                                    <input type="button"  class="btn btn-default" value="저장" id="submitbtn" />
                                </div>
                            </div>
                        </form>
                    </div>
                </li>
            </ul>
        </section>
    </div>
    
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	<script>
        $(function(){
        	
        	
        	
            $('.dropdown-menu > li').on('click',function(){
                let _$this = $(this);
                let _val = _$this.html();
                let _key = _$this.attr('data-key');
                let _color = _$this.attr('data-color');
                let _imgpath = "../" + _$this.attr('data-img');
                let _context = _val +"<span class='caret></span>";

                $('#groupId').val(_key);
                $('#groupBox').html(_context);
                $('#iconImg').attr('src',_imgpath)
                setColor(_color);
            });

            $('#submitbtn').on('click',function(e){
                let obj = {
                    groupId : Number($('#groupId').val()),
                    description : $('#description').val(),
                    id : $('#id').val(),
                    pw : $('#pw').val(),
                    etc : $('#etc').val()
                }
                console.log(obj);
                
                if(isValid(obj)== true){
                    let _$form= $('#formTag');
                    _$form.submit();
                }
            });

            function isValid(v){
            	 
                if(v.group == -1){
                    modalPopup('그룹명을 지정해주세요');
                    return false;
                }
                if(v.id.length == 0){
                    modalPopup('아이디를 입력해주세요');
                    return false;
                }
                if(v.pw.length == 0){
                    modalPopup('패스워드를 입력해주세요');
                    return false;
                }
                return true;
            }
        })
    </script>
</body>
</html>