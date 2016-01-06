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
 
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="slide-image" src="http://placehold.it/800x300" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="http://placehold.it/800x300" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="http://placehold.it/800x300" alt="">
                                </div>
                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                   </div>         
                                          

                <hr>

                <!-- Post Content -->
                <p class="lead">台北101大樓</p>
                <p>台北101（TAIPEI 101[2]）是位於中華民國台灣臺北市信義區的摩天大樓，樓高509.2公尺（1,671英尺），地上樓層共有101層、另有地下5層，總樓地板面積37萬4千平方公尺，由李祖原聯合建築師事務所設計、KTRT團隊建造，於1999年動工，2004年12月31日完工啟用；最初名稱為台北國際金融中心（Taipei World Financial Center），2003年改為現名，亦俗稱為101大樓[3]。興建與經營機構為台北金融大樓公司。其為臺灣第一高樓，曾於2004年12月31日至2010年1月4日間擁有世界第一高樓的紀錄，目前為世界第9高樓[2]，同時也是全球最高綠建築及環地震帶最高建築物，完工以來即成為臺北重要地標之一。此外，大樓內擁有全球最大的阻尼器、以及全球起降速度次快的電梯(僅次於東京晴空塔)。</p>
                <p>台北101座落於臺北市的中心商業區——信義計畫區，最初是為了配合中華民國政府的亞太營運中心政策而籌建的金融服務設施，而後轉變成綜合性的商業建築。原本計畫興建5棟建築，後來改為合併成一座摩天大廈，建築高度最終則提升至508公尺，以成為當時之世界第一高樓為目標。至於「101」這個名稱，是由林鴻明、李祖原等參與大樓籌建的股東和建築團隊共同構思出來的，除了點出大樓的樓層總數，更有超越頂尖的涵義</p>
                <p>台北101採用設定地上權開發，以宏國建設等民間企業發起的台北金融大樓公司，於1997年7月從臺北市政府取得此公有土地的開發權（土地所有權仍歸政府），成為整個大樓的籌建與經營單位。1998年1月由時任臺北市長陳水扁主持動土儀式，主體工程於1999年7月開工。2003年7月1日進行上樑儀式，時任總統陳水扁和臺北市長馬英九連袂受邀出席，[5] 同年10月17日完成塔尖定位正式封頂，使台北101在建築結構上較吉隆坡雙峰塔高57.3公尺。</p>

                <hr>

                <!-- Comments Form -->
                <div class="well">
                    <h4>Leave a Comment:</h4>
                    <form role="form">
                        <div class="form-group">
                            <textarea class="form-control" rows="3"></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>

                <hr>
                
                 <!-- Comment -->
                <div class="media">
                    <a class="pull-left" href="#">
                        <img class="media-object" src="http://placehold.it/64x64" alt="">
                    </a>
                    <div class="media-body">
                        <h4 class="media-heading">Start Bootstrap
                            <small>August 25, 2014 at 9:30 PM</small>
                        </h4>
                        Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
                    </div>
                </div>
                
                <!-- Comment -->
                <div class="media">
                    <a class="pull-left" href="#">
                        <img class="media-object" src="http://placehold.it/64x64" alt="">
                    </a>
                    <div class="media-body">
                        <h4 class="media-heading">Start Bootstrap
                            <small>August 25, 2014 at 9:30 PM</small>
                        </h4>
                        Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
                    </div>
                </div>

     <hr><br>
  </div>
  
  
  <!-- 版面左邊 --> 
  <div class="col-md-5">.col-md-4
  	
  
  
  
  
  </div>
</div>





<!--  -->

    <hr class="featurette-divider">
    <footer>
    <p class="pull-right"><a href="#">Back to top</a></p>
    <p> 2015 Travel, Inc. &middot; <a href="#">聯絡我們</a>
    </footer>

   
   
  </body>
</html>