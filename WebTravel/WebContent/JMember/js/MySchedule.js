$(function(){
//	$('.scheduleId').on('click',function(){
//		var scheduleId = $(this);
//		alert(scheduleId.attr('id'))
//	});
	var ob;
	$('.scheduleSelect').on("click",function(){//刪除行程
		ob= $(this)
	})
	$('#myModal').on('show.bs.modal',function(){
		$.ajax({
			  'type':'get', //post、delete、put
			  'url':'../MyScheduleContentServlet',
			  'dataType':'json',  //json、script、html
			  'data':{"Schedule":ob.val()},
			  'success':function(data){
				  $.each(data,function(i,value){
						  console.log(value.sceneId)
				  })

			  }
		});//ajax
	})
	
});//$end