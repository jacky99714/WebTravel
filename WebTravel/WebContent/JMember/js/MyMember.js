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
			$("#exampleInputFile").change(previewImage);
			$('#img001').attr('src',$('#saImg').attr('src'));
//
//			$('#formIMG').on("submit",function(event){
//				event.preventDefault();
//
//	    		 $.ajax({
//					  'type':'post', //post、delete、put
//					  'url':'../UpdataMemberImgServlet',
//					  'dataType':'json',  //json、script、html
//					  'contentType': false,
//					  'contentType':'multipart/form-data',
//					  'processData': false,
//					  'data':{'photo':$("#exampleInputFile").val()},
//					  'success':function(data){
//						  $('#myModal01').modal('hide')
//					  }
//	    		 	});
//				
//			});
			
			
			
			
			
    	$('#formLogin').on("submit",function(event){
    		event.preventDefault();
//    			alert($('#formLogin').serialize())
    		 $.ajax({
				  'type':'get', //post、delete、put
				  'url':'../UpdataMemberServlet?'+$('#formLogin').serialize(),
				  'dataType':'json',  //json、script、html
				  'success':function(data){
//					  alert(data[0].telephone)
					  $('#firstName').empty().append(data[0].firstName);
					  $('#lastName').empty().append(data[0].lastName);
					  $('#nickName').empty().append(data[0].nickName);
					  $('#address').empty().append(data[0].address);
					  $('#cellphone').empty().append(data[0].cellphone);
					  $('#telephone').empty().append(data[0].telephone);
					  $('#email').empty().append(data[0].email);
					  
					  
					  $('#myModal').modal('hide')
				  },
    		 	  'error':function(){
    		 		 $('#myModal').modal('hide')
    		 	  }
    		 	});
			  });
    	});
