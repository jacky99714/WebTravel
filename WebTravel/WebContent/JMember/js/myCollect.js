

$(function(){	
	
	$.ajax({//載入的初始化
		  'type':'get', //post、delete、put
		  'url':'../GetJoinScheduleServlet',
		  'dataType':'json',  //json、script、html
		  'success':function(datas){
			$.each(datas,function(index,data){
					$("#s"+data.sceneId).removeClass("btn-warning")
	  				.removeClass("joinSchedule")
	  				.addClass("btn-info")
	  				.addClass("active")
	  				.addClass("removeSchedule")
	  				.text("  行程");
			$('<span class="glyphicon glyphicon-minus-sign" aria-hidden="true"></span>').prependTo($("#s"+data.sceneId));
			})
		  }
	  });
	 var flyer = $('<img class="u-flyer" src="/WebTravel/img/instagram16.png">'); 
	var ob ;
	var joinSchedule;
	$('.joinSchedule').on("click",function(w){//加入行程
		joinSchedule = $(this);
		 $.ajax({
			  'type':'get', //post、delete、put
			  'async':true,
			  'url':'../AddScheduleServlet',
			  'dataType':'json',  //json、script、html
			  'data':{"scene":$(this).val()},
			  'success':function(data){
				  if(data=="deletesuccess"){
					  joinSchedule.removeClass("btn-info")
					  .removeClass("active")
					  .removeClass("removeSchedule")
					  .addClass("btn-warning")
					  .addClass("joinSchedule")
					  .text("  行程");
					  $('<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>').prependTo(joinSchedule);
					  var scheduleSize = $("#scheduleSizeimg").attr("value");
//					  alert(scheduleSize)
					  var scheduleSizeR =  parseInt(scheduleSize)-1;
					  $("#scheduleSizeimg").attr("src","/WebTravel/img/number/number"+scheduleSizeR+".png").attr("value",scheduleSizeR);
				  }else{
//------------------------------------------------------------------------------------
					  var offset = $("#scheduleSizeimg").offset(); 
					  flyer = $('<img class="u-flyer" src="/WebTravel/img/instagram16.png">'); 
					  flyer.fly({ 
				            start: { 
				                left: w.pageX, //开始位置（必填）#fly元素会被设置成position: fixed 
				                top: w.pageY //开始位置（必填） 
				            }, 
				            end: { 
				                left: offset.left+10, //结束位置（必填） 
				                top: offset.top+10, //结束位置（必填） 
				                width: 0, //结束时宽度 
				                height: 0 //结束时高度 
				            }, 
				            onEnd: function(){ //结束回调 
				            } 
				        }); 
//-----------------------------------------------------------------------------------------
					  joinSchedule.removeClass("btn-warning")
					  .removeClass("joinSchedule")
					  .addClass("btn-info")
					  .addClass("active")
					  .addClass("removeSchedule")
					  .text("  行程");
					  $('<span class="glyphicon glyphicon-minus-sign" aria-hidden="true"></span>').prependTo(joinSchedule);
					  var scheduleSize = $("#scheduleSizeimg").attr("value");
//					  alert(scheduleSize)
					  var scheduleSizeR =  parseInt(scheduleSize)+1;
					  $("#scheduleSizeimg").attr("src","/WebTravel/img/number/number"+scheduleSizeR+".png").attr("value",scheduleSizeR);
				  }
//				  joinSchedule.text("以加入行程");
			  }
		 })
		 
	})
	$('.delete').on("click",function(){//刪除行程
		ob= $(this)
	})
    	$('#Closebtn').on("click",function(){
    		 $.ajax({
				  'type':'get', //post、delete、put
				  'url':'../DeleteCollectServlet',
				  'dataType':'xml',  //json、script、html
				  'data':{"scene":ob.val()}
//				  'success':function(data){
					//data 就是一個XML DOM 
//					  alert(data);
//					$(data).find("Category").each(function(){
						//$(this) -> 表示Category物件
//						console.log($(this).children("CategoryID").text());
//						console.log($(this).children("CategoryName").text());
//					})
//				  }
			  });
    		 ob.parents("tr").remove();
    		 $('#myModal001').modal('hide')
    	});
	// ----------------------------------------------------
	
	$('.image-popup-no-margins').magnificPopup({
		type : 'image',
		closeOnContentClick : true,
		closeBtnInside : false,
		fixedContentPos : true,
		mainClass : 'mfp-no-margins mfp-with-zoom', // class to remove default margin from left and right side
		image : {
			verticalFit : true
		},
		zoom : {
			enabled : true,
			duration : 300
		// don't foget to change the duration also in CSS
		}
	});
	
      });