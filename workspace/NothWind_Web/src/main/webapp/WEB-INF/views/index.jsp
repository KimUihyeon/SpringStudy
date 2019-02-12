<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="https://unpkg.com/element-ui@1.4/lib/theme-default/index.css">
  <link rel="stylesheet" href="../resources/Asset/Css/bulma.min.css">
  <title></title>
</head>
<body>
    
<div id="mainApp">
    <el-row>
        <el-col :span="8" :offset="8">
        <div class="grid-content bg-purple-dark"  v-on:keyup.13="Login">
        	<form action="../test/Account" id='form'>
            	<el-input placeholder="Please input" v-model="input" type="password" name="pw" autoFocus ></el-input>
        	</form>
        </div>
        </el-col>
    </el-row>
</div>
    


    <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue"></script>
    <script src="https://unpkg.com/element-ui@1.4/lib/index.js"></script>
    <script src="../resources/Asset/Js/common.js"></script>

    <script>
    	var err = '${msg}';
    	
        var vm = new Vue({
        	el: '#mainApp',  

        	/*데이터 선언부 */
	        data: { 
	            input: '',
	            errMsg : err
	        },

        	/* Mounted */
	        mounted: function (){
	        	alertErrorMsg(this.errMsg);
	        },
	        

        	/* Event */
	        methods:{
	        	Login : function () {
	        		$('#form').submit();
	        	}
	        },
        }); //--Vue Object End
        
    </script>
</body>
</html>