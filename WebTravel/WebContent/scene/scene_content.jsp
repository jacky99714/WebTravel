<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="css/bootstrap.css" >
<link rel="stylesheet" href="css/justified-nav.css" >
<link rel="stylesheet" href="css/bootstrap-theme.min.css" >

<!-- JavaScript -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</head>
<body style="padding:71px;">

<!-- 版面左右分割 --> 
<div class="row">
  
  <!-- 版面左邊 --> 
  <div class="col-md-7">
 <!-- 圖片輪播start --> 
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="slide-image" w  src="img/1011.jpg" >
                                </div>
                                <div class="item">
                                    <img class="slide-image"  src="img/1012.jpg" >
                                </div>
                                <div class="item">
                                    <img class="slide-image"  src="img/1013.jpg" >
                                </div>
                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                   </div>         
                                          
 <!-- 圖片輪播end -->
                <hr>

                <!-- 景點內容 -->
                <p class="lead" id="${namebean.sceneId}">${namebean.sceneName}</p>                             
                <p><font color="#AA0000">景點介紹：</font></p>
                <p>${namebean.sceneContent}</p>
                
                <hr>

                <!-- 留言 Form -->
                <div class="well">
                    <h4>留言:</h4>
                    <form role="form">
                        <div class="form-group">
                            <textarea class="form-control" rows="3" name="${loginOk.memberId}"></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>

                <hr>
                
                 <!-- Comment 回覆-->
                <div class="media"><!-- 會員頭像-->
                    <a class="pull-left" href="#">
                        <img class="media-object" src="http://placehold.it/64x64" alt="">
                    </a>
                    <div class="media-body"><!-- 回覆內容 -->
                        <h4 class="media-heading">Start Bootstrap
                            <small>${listmessage.memberMessageContent}</small>
                        </h4>
                        ${listmessage}
                    </div>
                </div>
                
                

     <hr><br>
  </div>
  
  
  <!-- 版面左邊 --> 
  <div class="col-md-5">.col-md-4
  	
  
  
  
  
  </div>
</div>



<script type="text/javascript">
	
	
	$(function(){	
		//送出景點留言
		$(".btn-primary").on("click",function(event){
			event.preventDefault();
			var mid = $(".form-control").attr("name");
			alert(mid)
			if(mid != null && mid.length > 0 && mid !=''){
				$.ajax({
					  "type":"post",
					  "url":"<%=request.getContextPath()%>/SceneMessage",
					  "data":{"sceneId": $(".lead").attr("id"), "message":$(".form-control").val()},
					  "datatype":"text",
					})
					alert("留言新增成功")
			} else {
				alert("error")
				location.href = "../secure/login.jsp";

				
			}//if
		})//btn-primary
				
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