<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
	<div class="modalConfirm fade modal" id="modalConfirm">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h4 class="modal-title" id="confirm-modal-title">Modal title</h4>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	      </div>
	      <div class="modal-body">
	        <p id="confirm-modal-context">One fine body&hellip;</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary" id="confirm-modal-ok">Save changes</button>
	        <button type="button" class="btn btn-default" data-dismiss="modal" id="confirm-modal-close">Close</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
        
    
	<input type="hidden" id="modalBtn" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm"/>
	
	<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
		    <div class="modal-content">
		    ...
		    </div>
		</div>
	</div>

    <script src="../resources/Asset/Js/common/common.js"></script>
    <script src="../resources/Asset/Js/lib/Jquery3.3.1min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    <script src="../resources/Asset/Js/lib/bootstrap-colorpicker.js"></script>
    <script src="../resources/Asset/Js/lib/bootstrap-colorpicker.min.js"></script>
</body>
</html>