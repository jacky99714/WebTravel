<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>旅行微革命</title>
<link rel="shortcut icon" href="<c:url value="/img/icon.ico"/>">  

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
	
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body style="padding:71px;">
<!--   將top.jsp（首頁）加進頁面 -->
	<jsp:include page="/top/top.jsp"></jsp:include>

<!--     ---------------------------- -->
    <div class="container">
    
	<!--  ===============北部===============  -->
 <div class="row">
  <div class="col-md-2">北部
  <img src="images/scene01.jpg" alt="..." class="img-rounded">
  </div>
  <div class="col-md-2">
    <a href="scene_location.html"><img src="images/scene01.jpg" alt="..." class="img-rounded"></a>
  </div>
  <div class="col-md-2">
   <img src="images/scene01.jpg" alt="..." class="img-rounded">
  </div>
  <div class="col-md-2">
   <img src="images/scene01.jpg" alt="..." class="img-rounded">
  </div>
  <div class="col-md-2">
   <img src="images/scene01.jpg" alt="..." class="img-rounded">
  </div>
  <div class="col-md-2">
   <img src="images/scene01.jpg" alt="..." class="img-rounded">
  </div>
 </div><br>
<!--  ===============中部===============  -->
  <div class="row">
  <div class="col-md-1">中部
  <img src="images/scene02.jpg" alt="..." class="img-rounded">
  </div>
  <div class="col-md-1">台中市
   <img src="images/scene02.jpg" alt="..." class="img-rounded">
  </div>
  <div class="col-md-1">彰化縣
   <img src="images/scene02.jpg" alt="..." class="img-rounded">
  </div>
  <div class="col-md-1">南投縣
   <img src="images/scene02.jpg" alt="..." class="img-rounded">
  </div>
  <div class="col-md-1">
  
  </div>
  <div class="col-md-1">
 
  </div>
 </div> <br>
<!--  ===============南部===============  -->
  <div class="row">
  <div class="col-md-1">南部
  <img src="images/scene03.jpg" alt="..." class="img-rounded">
  </div>
  <div class="col-md-1">雲林縣
   <img src="images/scene03.jpg" alt="..." class="img-rounded">
  </div>
  <div class="col-md-1">嘉義縣
   <img src="images/scene03.jpg" alt="..." class="img-rounded">
  </div>
  <div class="col-md-1">台南市
   <img src="images/scene03.jpg" alt="..." class="img-rounded">
  </div>
  <div class="col-md-1">高雄市
   <img src="images/scene03.jpg" alt="..." class="img-rounded">
  </div>
  <div class="col-md-1">屏東縣
   <img src="images/scene03.jpg" alt="..." class="img-rounded">
  </div>
 </div> <br>
<!--  ===============東部===============  -->
  <div class="row">
  <div class="col-md-1">東部
  <img src="images/scene04.jpg" alt="..." class="img-rounded">
  </div>
  <div class="col-md-1">宜蘭縣
   <img src="images/scene04.jpg" alt="..." class="img-rounded">
  </div>
  <div class="col-md-1">花蓮縣
   <img src="images/scene04.jpg" alt="..." class="img-rounded">
  </div>
  <div class="col-md-1">台東縣
   <img src="images/scene04.jpg" alt="..." class="img-rounded">
  </div>
  <div class="col-md-1">
 
  </div>
  <div class="col-md-1">
  
  </div>
 </div>

    
    </div>
    
    
<!--  -->

    <hr class="featurette-divider">
    <footer>
    <p class="pull-right"><a href="#">Back to top</a></p>
    <p> 2015 Travel, Inc. &middot; <a href="#">聯絡我們</a>
    </footer>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>