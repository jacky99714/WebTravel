	var imgfinal;
	function loadImage(e) {

	    var image = new Image();
	    imgfinal=e.target.result;
		document.getElementById("img001").src = e.target.result;
	
	}
	function previewImage() {
	 var reader = new FileReader();
	 var file = document.getElementById("exampleInputFile").files[0];
	 reader.readAsDataURL(file);
	 reader.onload = loadImage;
	}


$(function(){
	
//	$.fn.datepicker.defaults.format = "yyyy-mm-dd";
	$('#birthday').datepicker({
		language: 'zh-TW'
	})
	$("#exampleInputFile").change(previewImage);
	
	$("#exampleInputFile1").on("click",function(w){
		w.preventDefault();
		$("#exampleInputFile").click();
	})
	//---------------------------------------------------------
//	<c:url value=""/>
	//----------------------------------------------------------
	$("#btn").on("click",function(){//一件輸入
		$("#useid").val("jacky0000");
		$("#password").val("000");
		$("#password2").val("000");
		$("#lastname").val("王");
		$("#firstname").val("小明");
		$("#nickname").val("叫我第一名");
		$("#birthday").val("1991-10-10");
		$("#cphone").val("0912323456");
		$("#hphone").val("02-22234x56");
		$("#email").val("jacky99714@gmail.com");
		$("#addr").val("台北市內湖路三段121巷七樓");
	})
	
	$('#password2').blur(function() {
	    var pass = $('#password').val();
	    var repass = $('#password2').val();
	    if((pass.length == 0) || (repass.length == 0)){
	        $('#pa1').addClass('has-error');
	    }
	    else if (pass != repass) {
	        $('#pa1').addClass('has-error');
	        $('#pa2').addClass('has-error');
	        $("#pass2").text("密碼不相同");
	    }
	    else {
	        $('#pa1').removeClass('has-error').addClass('has-success');
	        $('#pa2').removeClass('has-error').addClass('has-success');
	        $("#pass2").text("");
	    }
	});
	
	
	//----------------------------------------------------------
	
	
});




