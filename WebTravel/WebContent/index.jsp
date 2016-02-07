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
	<jsp:include page="/WEB-INF/top/top.jsp"></jsp:include>

  <!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img class="first-slide" src="img/Carousel01.png" alt="First slide">
        </div>
        <div class="item">
          <img class="second-slide" src="img/Carousel02.jpg" alt="Second slide">
        </div>
        <div class="item">
          <img class="third-slide" src="img/Carousel03.jpg" alt="Third slide">
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div><!-- /.carousel -->

    
    
<!--     ---------------------------- -->
<!--     <div class="container"> -->
<!--     	<div class="row"> -->
<!--     		<div class="col-md-10"> -->
    		
<!--     		</div> -->
<!--     		<div class="col-md-2"> -->
    		
<!--     		</div> -->
<!--     	</div> -->
<!--     </div> -->

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">台北101<span class="text-muted">Taipei 101</span></h2>
          <p class="lead">台北101景點位於信義區，籌建時原定為金融服務設施，而後轉變成綜合性的商業建築。台北101不僅是台北著名地標，更是時尚流行的指標，地上樓層共有101層、另有地下5層，商城除了有琳瑯滿目的精品櫃外，還有許多的道地美食也設櫃於此。於2004年12月31日至2010年1月4日間擁有世界第一高樓的紀錄，目前為世界第9高樓。</p>
        </div>
        <div class="col-md-5">
          <img class="featurette-image img-responsive center-block" src="http://www.taipei-101.com.tw/images/fbshare.jpg" alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7 col-md-push-5">
          <h2 class="featurette-heading">Taroko Gorge<span class="text-muted">Tunnel of Nine Turns</span></h2>
          <p class="lead">九曲洞位在花蓮縣秀林鄉、中橫公路174.5公里之處，是太魯閣國家公園中景觀最美的一段路程。原是中橫公路的舊道，後來改建為可供遊客行走的景觀步道，沿途常可見壯麗的山崖峭壁美景。</p>
        </div>
        <div class="col-md-5 col-md-pull-7">
          <img class="featurette-image img-responsive center-block" src="http://www.easttour.com.tw/img/Schedule/Taroko%20Gorge%20in%20Hualien,%20Taiwan(3).jpg" alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">平溪 <span class="text-muted">Train</span></h2>
          <p class="lead">平溪車站位於平溪區嶺腳里內，早年稱為「石底驛」，若往菁桐站開去，會經過一座鐵橋，鐵橋橫跨三坑溪，向下俯瞰可看到平溪與石底聚落。車站一出來就是中華街，沿著緩坡向下走，與平溪街交叉處，這一帶就是老街。車站地理位置介於平溪與嶺腳間，居高臨下，下方是基隆河。門口老樹樹枝停滿覓食的鳥群，運氣好的時候，還能看見牠們俯衝獵食輕巧的飛行動作。</p>
        </div>
        <div class="col-md-5">
          <img class="featurette-image img-responsive center-block" src="http://pic.pimg.tw/banbi217/1403716125-3963927038.jpg" alt="Generic placeholder image">
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