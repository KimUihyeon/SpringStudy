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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link rel="stylesheet" href="../resources/Asset/Css/bootstrap-colorpicker.css">
    <link rel="stylesheet" href="../resources/Asset/Css/bootstrap-colorpicker.min.css">
    <link rel="stylesheet" href="../resources/Asset/Css/common.css">
    <style>
    </style>
    <div id="wrap">
        <div class="pos-f-t menu">
            <div class="collapse" id="navbarToggleExternalContent">
                <div class="bg-dark p-4">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <a class="a-box" href="#">리스트로 보기</a>
                        </li>
                        <li class="list-group-item">
                            <a class="a-box" href="#">그룹별로 보기</a>
                        </li>
                        <li class="list-group-item">
                            <a class="a-box" href="#">추가</a>
                        </li>
                        <li class="list-group-item">
                            <a class="a-box" href="#">관리</a>
                        </li>
                        <li class="list-group-item">
                            <a class="a-box" href="#">로그아웃</a>
                        </li>
                    </ul>
                </div>
            </div>
            <nav class="navbar navbar-dark bg-dark">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </nav>
        </div>

        <section class="">
            <ul class="list-group content-list-box">
                <li class="list-group-item">
                    <div>
                        <form id="formTag" action="/test.html" method="POST" >
                            <div>
                                <img class="group-icon">
                                <div class="btn-group">
                                    <div class="colorpickerBox">
                                        <div class="colorResult colorSet"></div>
                                        <input type="text" class="form-control colorPicker" name="bgColor">
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
                                    <input type="submit"  class="btn btn-default" value="저장" id="submit" />
                                    <input type="file" id="file" >
                                </div>
                            </div>
                        </form>
                    </div>
                </li>
            </ul>
        </section>
    </div>
    
    <script src="../resources/Asset/Js/common/common.js"></script>
    <script src="../resources/Asset/Js/lib/Jquery3.3.1min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    <script src="../resources/Asset/Js/lib/bootstrap-colorpicker.js"></script>
    <script src="../resources/Asset/Js/lib/bootstrap-colorpicker.min.js"></script>
    <script>
        $(function(){
            let $colorPicker = $('.colorPicker');
            let $colorFakeControl = $('.colorResult');
            let $fileAddButton = $('#basic-addon2');

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


            $('#submit').on('click',function(e){

                let obj = {
                    group : $('#groupId').val(),
                    description : $('#description').val(),
                    id : $('#id').val(),
                    pw : $('#pw').val(),
                    etc : $('#etc').val()
                }
                $('#formTag').submit();
                if(isValid(obj)== true){
                    let _$formJEL= $('#formTag');
                    console.log( _$formJEL);
                    _$formJEL.submit();
                }
            });

        })
    </script>
</body>
</html>