function map(){
		  var arrayFrom =[];
		  var arrayTo = [];
		  var arrayWaypoint = [];
		  var arraylocal=[];
		  var count =$(".ScheduleContent").size()-1;//總數
//		  	alert(count)
		  $(".ScheduleContent").each(function(i,data){
			  if(i==0){
				  arrayFrom[0]=$(data).attr("lat");
				  arrayFrom[1]=$(data).attr("lng");
			  }else if(i==count){
				  arrayTo[0]=$(data).attr("lat");
				  arrayTo[1]=$(data).attr("lng");
			  }else{
				  arraylocal[0]=$(data).attr("lat");
				  arraylocal[1]=$(data).attr("lng");
				  arrayWaypoint.push(arraylocal);
			  }
			  console.log(i,$(data).attr("lng"),$(data).attr("lat"))
		  })
		  console.log("arrayFrom:"+arrayFrom);
		  console.log("arrayTo:"+arrayTo);
		  console.dir(arrayWaypoint);
		  $('.map').tinyMap('destroy');

		  $('.map').tinyMap({
			    'zoom'  : 14,
			    'direction': [
			              	{
			              	    'from':arrayFrom,
			              	    'to':arrayTo,
		                        'travel': 'driving',
		            	        'waypoint': arrayWaypoint
			              	},
			        ]
			});

	}


$(function(){
    $( "#sortable" ).sortable({
      revert: true
    });

	var ob;
	$('.scheduleSelect').on("click",function(){//刪除行程
		ob= $(this)
	})
	$('#myModal').on('shown.bs.modal',function(){
		map();
	})
	$('#myModal').on('show.bs.modal',function(){
		$.ajax({
			  'type':'get', //post、delete、put
			  'url':'../MyScheduleContentServlet',
			  'dataType':'json',  //json、script、html
			  'data':{"Schedule":ob.val()},
			  'success':function(data){
				  $("#sortable").empty();
				  $.each(data,function(i,value){
					  var col = $("<div></div>").addClass("col-md-2").addClass("ScheduleContent");
					  col.attr("id",i+1);
					  col.attr("value",value.sceneId);
					  col.attr("lng",value.timeStart);
					  col.attr("lat",value.timeEnd);
					  var thumbnail = $("<div></div>").addClass("thumbnail");
					  var abgne = $("<div></div>").addClass("abgne_tip_gallery_block");
					  var img = $("<img/>").attr("src","data:image/png;base64,"+value.scenePhoto)
					  var caption_grall = $("<div></div>").addClass("caption_grall");
					  var h3 = $("<h7></h7>").text("d");
					  var desc = $("<div></div>").addClass("desc").text("d");
					  var desc1 = $("<div></div>").addClass("desc").text("222");
					  var desc2 = $("<div></div>").addClass("desc").text("222");
					  var desc3 = $("<div></div>").addClass("desc").text(value.sceneName);
					  caption_grall.prepend([h3,desc,desc1,desc2,desc3]);
					  desc.css("padding-right","10px");
					  img.css("width","109.656px");
					  img.css("height","120px");
					  abgne.prepend([img,caption_grall]);
					  
					  var caption = $("<div></div>").addClass("caption");
					  var iii = i+1;
					  var p = $("<p></p>").text("第"+iii+"景點");
					  var p1 = $("<p></p>").text("下一個景點->");
					  caption.prepend([p,p1]);
					  thumbnail.prepend([abgne,caption]);
					  col.prepend(thumbnail);
					  $("#sortable").append(col);
					 
					  $( "#sortable" ).sortable({update: map});
				  });

			  }

		});//ajax

	})
	$('#Upbtn').on('click',function(){
		var a=new Array();
		$(".col-md-2").each(function(i,data){
			console.log(i,$(data).attr("value"))
			a[i]=$(data).attr("value");
		})
//		alert(JSON.stringify(a))
		$.ajax({
			  'type':'post', //post、delete、put
			  'url':'../UpdataScheduleContentServlet',
			  'dataType':'json',  //json、script、html
			  'data':{"a":JSON.stringify(a)}
		})
		$('#myModal').modal('hide')
	})//'#Upbtn''click'end

	//-----------------------------------猛甲茶到-------------------------------------------------
	 // 預設標題區塊 .abgne_tip_gallery_block .caption_grall 的 top
	  var _titleHeight =0;
	  $('.abgne_tip_gallery_block').each(function(){
	   // 先取得區塊的高及標題區塊等資料
	   var $this = $(this), 
	    _height = $this.height(), 
	    $caption = $('.caption_grall', $this),
	    _captionHeight = $caption.outerHeight(true),
	    _speed = 200;
	   
	   // 當滑鼠移動到區塊上時
	   $this.hover(function(){
	    // 讓 $caption 往上移動
	    $caption.stop().animate({
	     top: _height - _captionHeight
	    }, _speed);
	   }, function(){
	    // 讓 $caption 移回原位
	    $caption.stop().animate({
	     top: _height - _titleHeight
	    }, _speed);
	   });
	  });
	//-----------------------------------猛甲茶到-------------------------------------------------
});//$end