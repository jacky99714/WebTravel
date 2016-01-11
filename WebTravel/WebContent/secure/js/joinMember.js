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




