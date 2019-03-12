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
    <link rel="stylesheet" href="./resources/Asset/Css/common.css">
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
                                    <button type="button" class="btn btn-default dropdown-toggle colorSet" id="groupBox" data-toggle="dropdown" aria-expanded="false" name='group'>
                                    </button>
                                <input type="hidden" id="groupId" name="groupId" >
                                <ul class="dropdown-menu" role="menu" >
                                    <li data-key='1' data-color="#f00fff">1</li>
                                    <li data-key='1' data-color="#ff00ff">2</li>
                                    <li data-key='1' data-color="#ff0f0f">3</li>
                                </ul>
                                </div>
                            </div>
                            <hr>
                            <div style="margin-left: 60px">
                                <textarea type="text" class="form-control" placeholder="description" name='description' id='description' aria-describedby="basic-addon2"></textarea>
                            </div>
                            <div class="content-box">
                                <div class="content-item">
                                    <input type="text" class="form-control" placeholder="id" id="id" name='id' aria-describedby="basic-addon2">
                                </div>
                                <div class="content-item">
                                    <input type="text" class="form-control" placeholder="pw" id="pw" name='pw' aria-describedby="basic-addon2">
                                </div>
                                <div class="content-item">
                                    <input type="text" class="form-control" placeholder="etc" id="etc" name='etc' aria-describedby="basic-addon2">
                                </div>
                                <div class="content-item">
                                    <input type="submit"  class="btn btn-default" value="저장" id="submit" />
                                </div>
                            </div>
                        </form>
                    </div>
                </li>
            </ul>
        </section>
        
    
        <input type="hidden" id="modalBtn" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm"/>

        <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
            ...
            </div>
        </div>
        </div>
    </div>
    
    <script src="./resources/Asset/Js/common/common.js"></script>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="./resources/Asset/Js/lib/Jquery3.3.1min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    <script>
        $(function(){
            $('.dropdown-menu > li').on('click',function(){
                let _$this = $(this);
                let _val = _$this.html();
                let _key = _$this.attr('data-key');
                let _color = _$this.attr('data-color');
                let _context = _val +"<span class='caret></span>";

                $('#groupId').val(_key);
                $('#groupBox').html(_context);
                setColor(_color);
            });

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