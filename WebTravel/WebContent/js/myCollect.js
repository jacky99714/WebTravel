$(function(){	
	var ob ;
	$('.delete').on("click",function(){
		ob= $(this)
	})
    	$('#Closebtn').on("click",function(){
    		 $.ajax({
				  'type':'get', //post、delete、put
				  'url':'../DeleteCollectServlet',
				  'dataType':'xml',  //json、script、html
				  'data':{"scene":ob.val()}
				  'success':function(data){
					//data 就是一個XML DOM 
					  alert(data);
					$(data).find("Category").each(function(){
						//$(this) -> 表示Category物件
						console.log($(this).children("CategoryID").text());
						console.log($(this).children("CategoryName").text());
					})
				  }
			  });
    		 ob.parents("tr").remove();
    		 $('#myModal001').modal('hide')
    	});
      });