<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>scene_location</title>
<link rel="shortcut icon" href="<c:url value="/img/icon.ico"/>">  

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
	
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->


<!--   將top.jsp（首頁）加進頁面 -->
	<jsp:include page="/WEB-INF/top/top.jsp"></jsp:include>
<!-- CSS -->

<link rel="stylesheet" href="css/justified-nav.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<!-- JavaScript -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/holder.js"></script>
<script type="text/javascript" src=" <c:url value="/JMember/js/jquery.fly.min.js"/>"></script>

</head>
  <body style="padding:71px;">
<div class="s" id="${loginOk.memberId}"></div>  
<div class="row">

  <c:forEach var="sceneli" items="${li}">
   <div class="col-sm-6 col-md-3">
    <div class="thumbnail">
      <img style="width:300px;height:200px;" src="<%=request.getContextPath()%>/SceneImgServletq?sceneName=${sceneli.sceneName}"/>
      <div class="caption">
        <h3>${sceneli.sceneName}</h3>
        <p>${sceneli.sceneContent}</p>
        
        <p><!-- 介紹 button -->
           <button  class="btn btn-primary btn-sm" value="${sceneli.sceneName}" onclick="location.href='<%=request.getContextPath()%>/SelectSceneContextServlet?sceneName=${sceneli.sceneName}'">
		   <span class="glyphicon glyphicon-align-left" aria-hidden="true" ></span> 介紹
		   </button>
		   <!-- 收藏 button -->
           <button  id="f${sceneli.sceneId}" value="${sceneli.sceneId}" class="btn btn-success btn-sm">
		   <span class="glyphicon glyphicon-heart" aria-hidden="true"></span> 收藏
		   </button>
           <!-- 行程  button-->
           <button id="s${sceneli.sceneId}" class="btn btn-warning btn joinSchedule btn-sm" value="${sceneli.sceneId}">
           <span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>  行程
           </button>
         
		</p>
        
      </div>
    </div>
  </div>
  </c:forEach>
 
</div><!-- class="row" -->
<!-- JavaScript Jquery Ajax非同步 addFavorite -->
<script type="text/javascript">
	$(function(){
		//選當前button
		var btn;
		$(":button").on("click",function(){
			btn = $(this)
		})//butten
		
		//加入收藏
		$(".btn-success").on("click",function(){				
			var mb = $(".s").attr("id");
			addfav = $(this)
			if (mb != null && mb.length > 0 && mb !=''){
				$.ajax({
					  "type":"get",
					  "url":"<%=request.getContextPath()%>/SceneAddFavoriteServlet",
					  "data":{"sceneId": $(this).val()},
					  "datatype":"text",
					  "success":function(){
 						//收藏成功更換button顏色 
						addfav.removeClass("btn-success").addClass("btn-danger").text("  收藏");
						$('<span class="glyphicon glyphicon-heart-empty" aria-hidden="true"></span>').prependTo(addfav)	 							
					  }
					})
// 				alert("收藏成功");
			} else{
// 				alert("請登入會員");
				location.href = "../secure/login.jsp";
			}//if
		})//btn-success
		
		//景點收藏初始化
		var mb = $(".s").attr("id");
		if (mb != null && mb.length > 0 && mb !=''){
			$.ajax({
				  "type":"get",
				  "url":"<%=request.getContextPath()%>/SceneSelectFavorite",
// 				  "data":{"sceneId": $(this).val()},
				  'dataType':'json',
				  "success":function(listfavs){
// 					  alert(listfavs);
					$.each(listfavs,function(index,listfav){
						$("#f"+listfav.sceneId).removeClass("btn-success")
		  				.addClass("btn-danger")
		                .text("  景點");
						$('<span class="glyphicon glyphicon-heart-empty" aria-hidden="true"></span>').prependTo($("#f"+listfav.sceneId));
					})	
					
				  }
				});		
		}//if
		
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
		

		//加入行程
		$(".btn-warning").on("click",function(w){				
// 				$.ajax({
// 					  "type":"get",
<%-- 					  "url":"<%=request.getContextPath()%>/plan/AddScheduleServlet", --%>
// 					  "data":{"sceneId": $(this).val()},
// 					  "datatype":"text",
// 					})
// 				alert("加入成功");
				var flyer = $('<img class="u-flyer" src="/WebTravel/img/instagram16.png">'); 
				joinSchedule = $(this)
				$.ajax({
					  "type":"get",
					  "url":"<%=request.getContextPath()%>/AddScheduleServlet",
					  "data":{"scene": $(this).val()},
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
//							  alert(scheduleSize)
							  var scheduleSizeR =  parseInt(scheduleSize)-1;
							  $("#scheduleSizeimg").attr("src","/WebTravel/img/number/number"+scheduleSizeR+".png").attr("value",scheduleSizeR);
						  }else{
							  //---
							  	  var offset = $("#scheduleSizeimg").offset(); 
									  flyer.fly({ 
								            start: { 
								                left: w.pageX, //开始位置（必填）#fly元素会被设置成position: fixed 
 								                top: w.pageY //开始位置（必填） 
								            }, 
								            end: { 
								                left: 900, //结束位置（必填） 
								                top: 0, //结束位置（必填） 
								                width: 0, //结束时宽度 
								                height: 0 //结束时高度 
								            }, 
								            onEnd: function(){ //结束回调 
								            } 
								        }); 
							  //---
							  
							  joinSchedule.removeClass("btn-warning")
							  .removeClass("joinSchedule")
							  .addClass("btn-info")
							  .addClass("active")
							  .addClass("removeSchedule")
							  .text("  行程");
							  $('<span class="glyphicon glyphicon-minus-sign" aria-hidden="true"></span>').prependTo(joinSchedule);
							  var scheduleSize = $("#scheduleSizeimg").attr("value");
//							  alert(scheduleSize)
							  var scheduleSizeR =  parseInt(scheduleSize)+1;
							  $("#scheduleSizeimg").attr("src","/WebTravel/img/number/number"+scheduleSizeR+".png").attr("value",scheduleSizeR);
						  }
					  }
					})
			
		})//btn-warning 

		
	});//jquery

	
	
	
</script>
<!--  -->

    <hr class="featurette-divider">
    <footer>
    <p class="pull-right"><a href="#">Back to top</a></p>
    <p> 2015 Travel, Inc. &middot; <a href="#">聯絡我們</a>
    </footer>
</body>
</html>