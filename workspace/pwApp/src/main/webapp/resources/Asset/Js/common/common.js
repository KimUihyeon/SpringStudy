function setColor(colorStr){
    $('.colorSet').css('background',colorStr);
    $('.content-list-box > .list-group-item').css('border-left','5px solid'+colorStr);
    console.log(colorStr);
}

/* Modal */
/* Modal */
/* Modal */
function modalPopup(txt){
    $('.modal-content').html(txt);
    $('#modalBtn').trigger('click');
}

var modalSet = function (){
	this.title =0;
	this.context =0;
	this.okFunction =0;
	this.closeFunction =0;
	
	this.init = function (){
		var _this = this;
		$('#confirm-modal-ok').on('click',function(){
			_this.okFunction();
		});
		$('#confirm-modal-close').on('click',function(){
			_this.closeFunction();
		});
	}
	
	this.popup = function(){
		$('#confirm-modal-title').html(this.title);
		$('#confirm-modal-context').html(this.context);
		$('#modalConfirm').modal();
	}
}

/* Ajax */
/* Ajax */
/* Ajax */
function ajaxPostCall(data , url){
	var ajaxReturnData = {};
	$.ajax({
		method: 'POST',
		url : url,
		data : data,
        async   : false,
        success:function(data){
        	ajaxReturnData = data;
        },
        error: function (error) {
        	ajaxReturnData  = error;
        }
        
	});
	return ajaxReturnData;
}


/* form */

function createForm(type , url){
    var form = document.createElement("form");
    form.setAttribute('method',type );
    form.setAttribute("action", url); 
    return form;
}


function createInputData(name, value){
    var input = document.createElement("input");
    input.setAttribute("type", "hidden");
    input.setAttribute("name", name);
    input.setAttribute("value",value);
    return input;
}