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


        <section class="">
            <ul class="list-group content-list-box">
                <li class="list-group-item">
                    <div>
                        <form id="formTag" action="../directory/insert" method="POST" enctype="multipart/form-data" >
                            <div>
                                <img class="group-icon">
                                <div class="btn-group">
                                    <div class="colorpickerBox">
                                        <div class="colorResult colorSet"></div>
                                        <input type="text" class="form-control colorPicker" id="colorInput" name="color">
                                    </div>
                                    <input type="text" class="form-control" placeholder="title" id="title" name='title' aria-describedby="basic-addon2">
                                </div>
                            </div>
                            <hr>
                            <div style="margin-left: 60px">
                                <textarea type="text" class="form-control" placeholder="description" name='description' id='description' aria-describedby="basic-addon2"></textarea>
                            </div>
                            <div class="content-box">
                                <div class="input-group">
                                    <input type="text" class="form-control fileName" placeholder="Recipient's username" aria-describedby="basic-addon2" readonly>
                                    <span class="input-group-addon" id="basic-addon2">첨부파일</span>
                                </div>
                                <div class="content-item">
                                    <input type="button"  class="btn btn-default" value="저장" id="submitbtn" />
                                    <input type="file" id="file" name="file" >
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
            let $colorPicker = $('.colorPicker');
            let $colorFakeControl = $('.colorResult');
            let $fileAddButton = $('#basic-addon2');
            var _$form= $('#formTag');
            
            $colorPicker.colorpicker({
                format: "hex" 
            })
            .on('colorpickerChange colorpickerCreate', function (e) {
                    let _color =$colorPicker.val();
                    setColor(_color);
                    //$colorFakeControl.css('background', _color);
                }
            );

            $colorFakeControl.on('click',function(){
                $colorPicker.trigger('click');
                $colorPicker.focus();
            });

            $fileAddButton.on('click',function(){
                $('#file').trigger('click');
            });

            $('#file').change(function(e){
                $('.fileName').val($('#file').val());
                LoadImg($('#file')[0]);
            });

            function LoadImg(val){
                if(val.files && val.files[0]){
                    var reader = new FileReader();
                    reader.onload = function(e){
                        $('.group-icon').attr('src',e.target.result);
                    };
                    reader.readAsDataURL(val.files[0]);
                }
            }


            $("#submitbtn").on('click',function(e){
                let obj = {
                    color : $('#colorInput').val(),
                    description : $('#description').val(),
                    title : $('#title').val(),
                    description : $('#description').val(),
                    file : $('#file').val()
                }
                // Validation 필요
                
                _$form.submit();
                /* if(isValid(obj)== true){
                    console.log( _$formJEL);
                } */
            });

        })
    </script>
</body>
</html>