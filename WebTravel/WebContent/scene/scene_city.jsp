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

</head>
  <body style="padding:71px;">
<div class="s" id="${loginOk.memberId}"></div>  
<div class="row">
<!--   <div class="col-sm-6 col-md-3"> -->
<!--     <div class="thumbnail"> -->
<!--       <img data-src="holder.js/300x200" alt="..."> -->
<!--       <div class="caption"> -->
<!--         <h3>台北101</h3> -->
<!--         <p>台北101是位於中華民國台灣臺北市信義區的摩天大樓，樓高509.2公尺，地上樓層共有101層、另有地下5層，總樓地板面積37萬4千平方公尺，由李祖原聯合建築師事務所設計、KTRT團隊建造，</p> -->
<!--         <p> -->
<!--            <button type="button" class="btn btn-primary btn-sm"> -->
<!-- 		   <span class="glyphicon glyphicon-align-left" aria-hidden="true"></span> 介紹 -->
<!-- 		   </button> -->
		   
<!--            <button type="button" class="btn btn-success btn-sm"> -->
<!-- 		   <span class="glyphicon glyphicon-star" aria-hidden="true"></span> 收藏 -->
<!-- 		   </button> -->
           
<!--            <button class="btn btn-warning btn joinSchedule btn-sm"> -->
<!--            <span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>  行程 -->
<!--            </button> -->
         
<!-- 		</p> -->
<!--         <div class="ratings"> -->
<!--            <p class="pull-right">15 reviews</p> -->
<!--            <p> -->
<!--            <span class="glyphicon glyphicon-star"></span> -->
<!--            <span class="glyphicon glyphicon-star"></span> -->
<!--            <span class="glyphicon glyphicon-star"></span> -->
<!--            <span class="glyphicon glyphicon-star"></span> -->
<!--            <span class="glyphicon glyphicon-star-empty"></span> -->
<!--            </p> -->
<!--         </div> -->
<!--       </div> -->
<!--     </div> -->
<!--   </div> -->
  <c:forEach var="sceneli" items="${listcity}">
   <div class="col-sm-6 col-md-3">
    <div class="thumbnail">
      <img style="width:300px;height:200px;" src="data:image/jpg;base64,${sceneli.scenePhoto}"/>
      <div class="caption">
        <h3>${sceneli.sceneName}</h3>
        <p>${sceneli.sceneContent}</p>
        
        <p>
           <button type="button" class="btn btn-primary btn-sm" value="${sceneli.sceneName}" onclick="self.location.href='<%=request.getContextPath()%>/SelectSceneContextServlet'">
		   <span class="glyphicon glyphicon-align-left" aria-hidden="true" ></span> 介紹
		   </button>
		   
           <button type="button" value="${sceneli.sceneId}" class="btn btn-success btn-sm">
		   <span class="glyphicon glyphicon-heart" aria-hidden="true"></span> 收藏
		   </button>
           
           <button class="btn btn-warning btn joinSchedule btn-sm">
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
			alert(mb);
			if (mb != null){
				$.ajax({
					  "type":"get",
					  "url":"<%=request.getContextPath()%>/SceneAddFavoriteServlet",
					  "data":{"sceneId": $(this).val()},
					  "datatype":"text",
					})
				alert("收藏成功");
			} else{
				alert("請登入會員");
			}//if
		})//btn-success
			
		
		//加入行程
		$(".btn-warning").on("click",function(){				
			
		
				$.ajax({
					  "type":"get",
					  "url":"<%=request.getContextPath()%>/AddScheduleServlet",
					  "data":{"scene": $(this).val()},
					 
					})
			
		})//btn-warning 
		//轉至景點介紹
// 			$(".btn-primary").on("click",function(){
// 				$.ajax({
// 				"type":"get",
<%-- 				"url":"<%=request.getContextPath()%>/SelectSceneContextServlet", --%>
// 				"data":{"sceneName": $(this).val()},
// 				"datatype":"text",
// 				});

// 			})	
		
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