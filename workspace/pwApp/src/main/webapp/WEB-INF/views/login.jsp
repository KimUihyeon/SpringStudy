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
        <section class="loginBox">
            <div class="well">
                <form action="login" method="post">
                    <div class="input-group">
                        <input type="text" class="form-control" name="id" placeholder="email" aria-describedby="basic-addon2">
                    </div>
                    <div class="input-group">
                        <input type="password" class="form-control" name="pw" placeholder="password" aria-describedby="basic-addon2">
                    </div>
                    <div class="contentCenter font11 loginHelperBox">
                        <span><a href="#">회원가입</a></span>
                        <span>||</span>
                        <span><a href="#">아이디 비밀번호 찾기</a></span>
                    </div>
                    <div class="contentCenter">
                        <button type="submit" class="btn btn-default btn-success">로그인</button>
                    </div>
                </form>
            </div>
        </section>
    </div>
    
    <script src="./resources/Asset/Js/common/common.js"></script>
    <script src="./resources/Asset/Js/lib/Jquery3.3.1min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    <script>
    </script>
</body>
</html>