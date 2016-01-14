function map(){
		  var arrayFrom =[];
		  var arrayTo = [];
		  var arrayWaypoint = [];
		  var fromText;
		  var toText;
		  var count =$(".ScheduleContent").size()-1;//總數
//		  	alert(count)
		  $(".ScheduleContent").each(function(i,data){
			  if(i==0){
				  arrayFrom[0]=$(data).attr("lat");
				  arrayFrom[1]=$(data).attr("lng");
				  fromText=$(data).attr("sceneName");
			  }else if(i==count){
				  arrayTo[0]=$(data).attr("lat");
				  arrayTo[1]=$(data).attr("lng");
				  toText=$(data).attr("sceneName");
			  }else{
				  a=i+1;
				  var arraylocal=[];
				  var objectWaypoint=new Object();
				  arraylocal[0]=$(data).attr("lat");
				  arraylocal[1]=$(data).attr("lng");
				  objectWaypoint['location']=arraylocal;
				  objectWaypoint['text']=$(data).attr("sceneName");
				  objectWaypoint['icon']="images/"+a+".png";
				  arrayWaypoint.push(objectWaypoint);
			  }
//			  console.log(i,objectWaypoint.text,objectWaypoint.location)
		  })
//		  console.log("arrayFrom:"+arrayFrom+fromText);
//		  console.log("arrayTo:"+arrayTo+toText);
//		  console.log(arrayWaypoint);
		  $('.map').tinyMap('destroy');

		  $('.map').tinyMap({
			    'zoom'  : 14,
			    'direction': [
			              	{
			              	    'from':arrayFrom,
			              	    'fromText':fromText,
		                        'travel': 'driving',
		            	        'waypoint': arrayWaypoint,
		            	        'to':arrayTo,
		            	        'toText':toText,
			                     'icon': {
			                         'from': 'images/1.png',
			                         'to': 'images/'+$(".ScheduleContent").size()+'.png'
			                     },
			                     'event': {
			                         directions_changed: {
			                             'func': function(){
			                            	 var info = this.getDirections();
//			                            	 console.log("info:"+info)
			                            	 console.log(info)
//			                            	 alert(info.routes[0].legs[0].distance.text)
			                            	 $.each(info.routes[0].legs,function(i,datas){
			                            		 console.log(i,datas.distance.text)
			                            		 console.log(i,datas.duration.text)
			                            		 e=i+1;
			                            		 $(".p_duration:eq("+e+")").text("預計花費"+datas.duration.text).css("color","#8B864E");
//			                            		 $(".p_distance:last").text("結束完美的旅程");
			                            		 $(".p_duration:first").text("旅程開始").css("color","black");
//			                            		 $("#p"+i).text(datas.distance.text);
			                            		 $("p_distance:first").text("");
//			                            		 $("#pp"+i).text("到下一個時間"+datas.duration.text);
//			                            		 $("#pp"+e).text("結束");
			                            		 
			                            		 
//			                            		 $.each(datas,function(j,jdatas){
//			                            		 console.log(j,jdatas)
//			                            		 })
			                            	 })
			                             }
			                         }
			                     }

			              	}
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
					  col.attr("sceneName",value.sceneName);
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
					  var p = $("<p></p>").text("");
					  p.attr("idd","p"+i);
					  p.addClass("p_distance");
					  var p1 = $("<p></p>").text("");
					  p1.attr("idd","pp"+i);
					  p1.addClass("p_duration");
					  caption.prepend([p,p1]);
					  thumbnail.prepend([abgne,caption]);
					  col.prepend(thumbnail);
					  $("#sortable").append(col);
					 
					  $( "#sortable" ).sortable({update: map});
				  });

			  },
			  'complete':function(){
				  map();
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
	  //-----------------------------------刪除行程-------------------------------------------------
	  var ob;
	  $('.delete').on("click",function(){//刪除行程
			ob= $(this)
		})
	    	$('#Closebtn').on("click",function(){
	    		 $.ajax({
					  'type':'get', //post、delete、put
					  'url':'../DeleteScheduleServlet',
					  'dataType':'xml',  //json、script、html
					  'data':{"schedule":ob.val()}
//					  'success':function(data){
						//data 就是一個XML DOM 
//						  alert(data);
//						$(data).find("Category").each(function(){
							//$(this) -> 表示Category物件
//							console.log($(this).children("CategoryID").text());
//							console.log($(this).children("CategoryName").text());
//						})
//					  }
				  });
	    		 ob.parents("tr").remove();
	    		 $('#myModal001').modal('hide')
	    	});
	  
	  //-----------------------------------猛甲茶到-------------------------------------------------
	  $('.map-marker-01').tinyMap({
		    'center': ['25.039065815333753', '121.56097412109375'],
		    zoom:15
	  });
	  
	  
//	  var div1 = $("<div></div>").addClass("col-md-4");
//	  var div2 = $("<div></div>").addClass("map-marker-01");
//	  div2.attr("style","height:300px");
		$(".scheduleId").on("click",function(){
			$(".loadingimg").remove();
			$(this).next(".td2").children(".delete").after('<img style="width:20px;height:20px;display:inline;" class="loadingimg" alt="" src="images/loader_gif.jpg">');
			$.ajax({
				  'type':'get', //post、delete、put
				  'url':'../MyScheduleContentServlet',
				  'dataType':'json',  //json、script、html
				  'data':{"Schedule":$(this).attr("value")},
				  'success':function(data){
//					  col.attr("lng",value.timeStart);
//					  col.attr("lat",value.timeEnd);
					  var arrayFrom =[];
					  var arrayTo = [];
					  var arrayWaypoint = [];
					  var fromText;
					  var toText;
					  var count =$(data).size()-1;//總數
//					  alert(count)
					  $.each(data,function(i,value){

							  if(i==0){
								  arrayFrom[0]=value.timeEnd;
								  arrayFrom[1]=value.timeStart;
								  fromText=value.sceneName;
							  }else if(i==count){
								  arrayTo[0]=value.timeEnd;
								  arrayTo[1]=value.timeStart;
								  toText=value.sceneName;
							  }else{
								  a=i+1;
								  var arraylocal=[];
								  var objectWaypoint=new Object();
								  arraylocal[0]=value.timeEnd;
								  arraylocal[1]=value.timeStart;
								  objectWaypoint['location']=arraylocal;
								  objectWaypoint['text']=value.sceneName;
								  objectWaypoint['icon']="images/"+a+".png";
								  arrayWaypoint.push(objectWaypoint);
//								  console.log(arrayWaypoint)
							  }
//							  alert(i)
					  });
					  console.log(fromText,arrayFrom,arrayWaypoint,arrayTo,toText)
					  $('.map-marker-01').tinyMap('destroy');
					  
					  $('.map-marker-01').tinyMap({
						  //--------------------direction
						    'direction': [
							              	{
							              	    'from':arrayFrom,
							              	    'fromText':fromText,
						                        'travel': 'driving',
						            	        'waypoint': arrayWaypoint,
						            	        'to':arrayTo,
						            	        'toText':toText,
							                     'icon': {
							                         'from': 'images/1.png',
							                         'to': 'images/'+$(data).size()+'.png'
							                     }
							              	}
							              ],
					  //-------------------directionEnd
					  event: {
					        'click': function () {
//					        	$('.map-marker-01').tinyMap('destroy');
//					        	$('.map-marker-01').tinyMap({
//					        	    'center': ['25.034516521123315','121.56496524810791'],
//					        	    'zoom': 14,
//					        	    // 啟用 MarkerWithLabel
//					        	    'markerWithLabel': true,
//					        	    'marker': [
//					        	        {
//					        	            'addr': ['25.034516521123315','121.56496524810791'],
//					        	            'labelContent': '<strong>Hello World</strong><div><img src="data:image/png;base64,'+data[0].scenePhoto+'" style="height:80px;width:80px; alt=""  /></div>',
//					        	            'labelClass'  : 'box',
//					        	            'icon': {
//					        	                'path': 'M 0 0'
//					        	            }
//					        	        }
//					        	    ]
//					        	});
					        }
					  }
					  
					  });
				  },
				  'complete':function(){
					  $(".loadingimg").remove();
				  }
			});//ajax
		});
	  
	  
	  
	  
	  
	  
	  
});//$end