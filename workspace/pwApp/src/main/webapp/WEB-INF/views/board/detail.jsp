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
                    	<input type="hidden" id="boardId" value="${board.id}" >
                        <div>
                            <img class="group-icon" src="../${board.icon}">
                            <strong>${board.title}</strong>
                        </div>
                        <div class="detailControlBttonBox">
                        	<a href="../main/modify?id=${board.id}">
                        		<i class="fas fa-edit"></i>
                        	</a>
                            <i class="fas fa-trash-alt deleteIcon" data-key="${board.id}" data-title="${board.title}"></i>
                        </div>
                        <hr>
                        <div style="margin-left: 60px">
                            <i>${board.description}</i>
                        </div>
                        <div class="content-box">
                            <div class="content-item">
                                <button type="button" class="btn btn-primary btn-lg btn-block" data-changed="false" id="id">id</button>
                            </div>
                            <div class="content-item">
                                <button type="button" class="btn btn-primary btn-lg btn-block" data-changed="false" id="pw">password</button>
                            </div>
                            <div class="content-item">
                                <button type="button" class="btn btn-primary btn-lg btn-block" data-changed="false" id="etc">ETC</button>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </section>
    </div>
    
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	<script>
		var color = '${board.color}';
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
        		var form = createForm('POST','../main/delete');
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
        		
        		modalSetting.context = "["+ title + "] 게시물을 삭제하시겠습니까?";
        		modalSetting.popup();        		
        	});
			

        	/* 버튼이벤트 */
        	/* 버튼이벤트 */
            $('.content-item').each(function(index){
                let _idx = index;
                $(this).find('button').on('click',function(){
                	
                    let _$button = $(this);
                    let _buttonId = $(this).attr('id');
                    let _IsDataChange = $(this).attr('data-changed');
                    
                    if(_IsDataChange == 'false'){
                    	var ajaxData = getBoardInfo();
                    	var data = "";

                    	if(_buttonId== 'id'){
                    		data = ajaxData.contextId;
                    	}
                    	else if(_buttonId== 'pw'){
                    		data = ajaxData.contextPw;
                    	}
                    	else {
                    		data = ajaxData.etc;
                    	}
                    	data =  securityDataTagFactory(data);
                    	
                        _$button.html(data);
                        _$button.attr('data-changed','ture'); 
                        _$button.removeClass('btn-primary');
                        _$button.css({'background':'white'
                                    ,'border':'1px solid'});
                    }
                });
            });


            /* getData */
            /* getData */
            function getBoardInfo(){ // Ajax 데이터
            	let data = { 'id' : parseInt($('#boardId').val())};
            	let url = '../main/selectOne';            	
            	let ajaxData = ajaxPostCall(data,url);
            	return ajaxData; 
            }
            
            function securityDataTagFactory(txt){ // 태그 랩핑
                let tag = "";
                for(var i=0; i<txt.length;i++){
                    var chart = txt[i];
                    if(isNaN(chart)){ // 문자
                        tag += "<s class='securityStr'>"+chart+"</s>";
                    }
                    else { // 숫자
                        tag += "<n class='securityNo'>"+chart+"</n>";
                    }
                }
                return tag;
            }

            function getData(){
                let data = getBoardInfo(); // ('애러처리 필요');
                let dataWrappingHtml = securityDataTagFactory(data);
                return dataWrappingHtml;
            }



        	/* Init */
        	/* Init */
        	setColor(color);
        });
    </script>
</body>
</html>