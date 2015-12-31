$(function(){	
    	$('#formLogin').on("submit",function(event){
    		event.preventDefault();
//    			alert($('#formLogin').serialize())
    		 $.ajax({
				  'type':'get', //post、delete、put
				  'url':'../UpdataMemberServlet?'+$('#formLogin').serialize(),
				  'dataType':'json',  //json、script、html
				  'success':function(data){
					  $('#myModal').modal('hide')
					  
				  },
    		 	  'error':function(){
    		 		 $('#myModal').modal('hide')
    		 	  }
    		 	});
			  });
    	});
