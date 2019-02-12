var appConfig = {
    pageState : {
        list : 'list',
        view : 'view',
        search: 'search'
    },
}


var $cAjax = function (requestUrl, dataObj) {
	var returnObj = { value : [] };
	$.ajax({
	    type:"post",
	    url: '../'+requestUrl,
	    data : dataObj,
        async: false,
	    dataType:"JSON",
	    success : function(data) {
	    	returnObj.value=data;
	    	console.log(returnObj);
	    	return returnObj ;
	    },
	    error : function(xhr, status, error) {
	    	returnObj.value=error;
	    	return returnObj;
	    }
	    
	}); 
	return returnObj;
}









var msgArray = [
	{ key : 'e1', msg :"패스워드가 잘못되었습니다."},	
	{ key : 's1', msg :"로그인 되었습니다."}
];


function alertErrorMsg (errkey){
	if (errkey != '' && errkey != null){
    	msgArray.forEach(function(item){
    		if(errkey==item.key){
    			alert(item.msg);
    		}
    	});	        		
	}
}
		