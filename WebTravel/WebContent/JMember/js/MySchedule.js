$(function(){
//	$('.scheduleId').on('click',function(){
//		var scheduleId = $(this);
//		alert(scheduleId.attr('id'))
//	});
	    $( "#sortable" ).sortable({
	      revert: true
	    });
	    //附加小幫手
//	    $( "#draggable" ).draggable({
//	      connectToSortable: "#sortable",
//	      helper: "clone",
//	      revert: "invalid"
//	    });
//	    $( "ul, li" ).disableSelection();

	
	
	
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
					  var col = $("<div></div>").addClass("col-md-2");
					  col.attr("id",i+1);
					  col.attr("value",value.sceneId);
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
//					  var img2 = $("<img>").attr("src","data:image/png;base64,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")
//					  img2.css("width","50px");
//					  img2.css("height","203px");
//					  img2.addClass("di ui-state-disabled");
//					  var imgdiv = $("<div></div>").addClass("col-sm-1 di ui-state-disabled");
//					  imgdiv.prepend(img2);
//					  caption.prepend([h3,p]);
//					  thumbnail.prepend([img,caption]);
//					  col.prepend(thumbnail);
//					  row.prepend(col);
//					  td.prepend(row);
					  $("#sortable").append(col);
				  })

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