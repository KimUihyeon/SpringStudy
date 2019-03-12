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

        <section class="loginBox">
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
    
    <script src="./resources/Asset/Js/common/common.js"></script>
    <script src="./resources/Asset/Js/lib/Jquery3.3.1min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    <script>
        $(function(){
            $('.content-item').each(function(index){
                let _idx = index;
                $(this).find('button').on('click',function(){
                    let _$button = $(this);
                    let _buttonId = $(this).attr('id');
                    let _IsDataChange = $(this).attr('data-changed');
                    if(_IsDataChange == 'false'){
                        _$button.html(getData());
                        _$button.attr('data-changed','ture'); 
                        _$button.removeClass('btn-primary');
                        _$button.css({'background':'white'
                                    ,'border':'1px solid'});
                    }
                });
            });

            function securityDataTagFactory(txt){
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

            function getSecurityDataService(){
                console.log('Service Call');
                let data = 'data123';
                
                return data;
            }
            function getData(){
                let data = getSecurityDataService(); // ('애러처리 필요');
                let dataWrappingHtml = securityDataTagFactory(data);
                return dataWrappingHtml;
            }
        });
    </script>
</body>
</html>