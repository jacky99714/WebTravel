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
    
<!--圖片的滑出式說明 -->
<script src="js/jquery.min.js"></script>
<style type="text/css">
 .abgne_tip_gallery_block {
  margin: 0;
  padding: 0;
  width: 112px;
  height: 115px;
  overflow: hidden;
  position: relative;
 }
 .abgne_tip_gallery_block img {
  position: absolute;
  border: 0;
 }
 .abgne_tip_gallery_block .caption {
 position: absolute;
 top: 55px; /* .abgne_tip_gallery_block 的高 - 想顯示 title 的高(這邊是設 55) */
 width: 112px; /* .abgne_tip_gallery_block 的寬 - .caption 的左右 padding */
 padding: 15px 10px 20px;
 cursor: pointer;
 color: #fff;
 background: url(http://goo.gl/8nT7pc) repeat;opacity:0.6;
 }
 .abgne_tip_gallery_block .caption h2 {
  margin: 0;
  padding: 0px 0px 15px;
 }
 .abgne_tip_gallery_block .caption h2 a {
  text-decoration: none;
  color: #fc6; 
 }
 .abgne_tip_gallery_block .caption h2 a:hover {
  text-decoration: underline;
 }
</style>
<!--圖片的滑出式說明 -->
  </head>
  <body style="padding:71px;">
<!--   將top.jsp（首頁）加進頁面 -->
	<jsp:include page="/WEB-INF/top/top.jsp"></jsp:include>

<!--     ---------------------------- -->
    <div class="container">
    
	
 <div class="row">
  
  
  <div class="col-md-10">
	<table class="table">
		<!--  ===============北部===============  -->
		<tr>
			<td>			    
			    <div class="abgne_tip_gallery_block">
				<a class="city" href="<%=request.getContextPath()%>/SelectLocationServlet?location=北區">
					<img src="img/scene04.jpg" alt="北區" class="img-rounded"></a>
				<div class="caption">
				<h2>北部</h2>
					<div class="desc" style="padding-right: 10px;"><!--內容 --></div>
				</div>
				</div>						
			</td>
			<td>			    
			    <div class="abgne_tip_gallery_block">
				<a class="city" href="<%=request.getContextPath()%>/SelectCityServlet?city=台北市">
					<img src="img/scene01.jpg" alt="台北市" class="img-rounded"></a>
				<div class="caption">
				<h2>台北市</h2>
					<div class="desc" style="padding-right: 10px;"><!--內容 --></div>
				</div>
				</div>						
			</td>
			<td>			    
			    <div class="abgne_tip_gallery_block">
				<a class="city" href="<%=request.getContextPath()%>/SelectCityServlet?city=新北市">
					<img src="img/scene02.jpg" alt="新北市" class="img-rounded"></a>
				<div class="caption">
				<h2>新北市</h2>
					<div class="desc" style="padding-right: 10px;"><!--內容 --></div>
				</div>
				</div>						
			</td>
			<td>			    
			    <div class="abgne_tip_gallery_block">
				<a class="city" href="<%=request.getContextPath()%>/SelectCityServlet?city=基隆市">
					<img src="img/scene03.jpg" alt="基隆市" class="img-rounded"></a>
				<div class="caption">
				<h2>基隆市</h2>
					<div class="desc" style="padding-right: 10px;"><!--內容 --></div>
				</div>
				</div>						
			</td>
			<td>			    
			    <div class="abgne_tip_gallery_block">
				<a class="city" href="<%=request.getContextPath()%>/SelectCityServlet?city=桃園市">
					<img src="img/scene04.jpg" alt="桃園市" class="img-rounded"></a>
				<div class="caption">
				<h2>桃園市</h2>
					<div class="desc" style="padding-right: 10px;"><!--內容 --></div>
				</div>
				</div>						
			</td>
			<td>			    
			    <div class="abgne_tip_gallery_block">
				<a class="city" href="<%=request.getContextPath()%>/SelectCityServlet?city=新竹縣">
					<img src="img/scene05.jpg" alt="新竹縣" class="img-rounded"></a>
				<div class="caption">
				<h2>新竹縣</h2>
					<div class="desc" style="padding-right: 10px;"><!--內容 --></div>
				</div>
				</div>						
			</td>
			<td>			    
			    <div class="abgne_tip_gallery_block">
				<a class="city" href="<%=request.getContextPath()%>/SelectCityServlet?city=宜蘭縣">
					<img src="img/scene06.jpg" alt="宜蘭縣" class="img-rounded"></a>
				<div class="caption">
				<h2>宜蘭縣</h2>
					<div class="desc" style="padding-right: 10px;"><!--內容 --></div>
				</div>
				</div>						
			</td>		
		</tr>
		<!--  ===============中部===============  -->
		<tr>					
			<td>			    
			    <div class="abgne_tip_gallery_block">
				<a class="city" href="<%=request.getContextPath()%>/SelectLocationServlet?location=中區">
					<img src="img/scene04.jpg" alt="中區" class="img-rounded"></a>
				<div class="caption">
				<h2>中部</h2>
					<div class="desc" style="padding-right: 10px;"><!--內容 --></div>
				</div>
				</div>						
			</td>
			<td>			    
			    <div class="abgne_tip_gallery_block">
				<a class="city" href="<%=request.getContextPath()%>/SelectCityServlet?city=苗栗縣">
					<img src="img/scene07.jpg" alt="苗栗縣" class="img-rounded"></a>
				<div class="caption">
				<h2>苗栗縣</h2>
					<div class="desc" style="padding-right: 10px;"><!--內容 --></div>
				</div>
				</div>						
			</td>
			<td>			    
			    <div class="abgne_tip_gallery_block">
				<a class="city" href="<%=request.getContextPath()%>/SelectCityServlet?city=台中市">
					<img src="img/scene08.jpg" alt="台中市" class="img-rounded"></a>
				<div class="caption">
				<h2>台中市</h2>
					<div class="desc" style="padding-right: 10px;"><!--內容 --></div>
				</div>
				</div>						
			</td>
			<td>			    
			    <div class="abgne_tip_gallery_block">
				<a class="city" href="<%=request.getContextPath()%>/SelectCityServlet?city=彰化縣">
					<img src="img/scene09.jpg" alt="彰化縣" class="img-rounded"></a>
				<div class="caption">
				<h2>彰化縣</h2>
					<div class="desc" style="padding-right: 10px;"><!--內容 --></div>
				</div>
				</div>						
			</td>
			<td>			    
			    <div class="abgne_tip_gallery_block">
				<a class="city" href="<%=request.getContextPath()%>/SelectCityServlet?city=南投縣">
					<img src="img/scene10.jpg" alt="南投縣" class="img-rounded"></a>
				<div class="caption">
				<h2>南投縣</h2>
					<div class="desc" style="padding-right: 10px;"><!--內容 --></div>
				</div>
				</div>						
			</td>
			<td>			    
			    <div class="abgne_tip_gallery_block">
				<a class="city" href="<%=request.getContextPath()%>/SelectCityServlet?city=雲林縣">
					<img src="img/scene11.jpg" alt="雲林縣" class="img-rounded"></a>
				<div class="caption">
				<h2>雲林縣</h2>
					<div class="desc" style="padding-right: 10px;"><!--內容 --></div>
				</div>
				</div>						
			</td>						
		</tr>
		<!--  ===============南部===============  -->
		<tr>			
			<td>			    
			    <div class="abgne_tip_gallery_block">
				<a class="city" href="<%=request.getContextPath()%>/SelectLocationServlet?location=南區">
					<img src="img/scene04.jpg" alt="南區" class="img-rounded"></a>
				<div class="caption">
				<h2>南部</h2>
					<div class="desc" style="padding-right: 10px;"><!--內容 --></div>
				</div>
				</div>						
			</td>
			<td>			    
			    <div class="abgne_tip_gallery_block">
				<a class="city" href="<%=request.getContextPath()%>/SelectCityServlet?city=嘉義縣">
					<img src="img/scene12.jpg" alt="嘉義縣" class="img-rounded"></a>
				<div class="caption">
				<h2>嘉義縣</h2>
					<div class="desc" style="padding-right: 10px;"><!--內容 --></div>
				</div>
				</div>						
			</td>
			<td>			    
			    <div class="abgne_tip_gallery_block">
				<a class="city" href="<%=request.getContextPath()%>/SelectCityServlet?city=台南市">
					<img src="img/scene13.jpg" alt="台南市" class="img-rounded"></a>
				<div class="caption">
				<h2>台南市</h2>
					<div class="desc" style="padding-right: 10px;"><!--內容 --></div>
				</div>
				</div>						
			</td>
			<td>			    
			    <div class="abgne_tip_gallery_block">
				<a class="city" href="<%=request.getContextPath()%>/SelectCityServlet?city=高雄市">
					<img src="img/scene14.jpg" alt="高雄市" class="img-rounded"></a>
				<div class="caption">
				<h2>高雄市</h2>
					<div class="desc" style="padding-right: 10px;"><!--內容 --></div>
				</div>
				</div>						
			</td>
			<td>			    
			    <div class="abgne_tip_gallery_block">
				<a class="city" href="<%=request.getContextPath()%>/SelectCityServlet?city=屏東縣">
					<img src="img/scene15.jpg" alt="屏東縣" class="img-rounded"></a>
				<div class="caption">
				<h2>屏東縣</h2>
					<div class="desc" style="padding-right: 10px;"><!--內容 --></div>
				</div>
				</div>						
			</td>									
		</tr>
		<!--  ===============東部===============  -->
		<tr>
			<td>			    
			    <div class="abgne_tip_gallery_block">
				<a class="city" href="<%=request.getContextPath()%>/SelectLocationServlet?location=東區">
					<img src="img/scene04.jpg" alt="東區" class="img-rounded"></a>
				<div class="caption">
				<h2>東部</h2>
					<div class="desc" style="padding-right: 10px;"><!--內容 --></div>
				</div>
				</div>						
			</td>
			<td>			    
			    <div class="abgne_tip_gallery_block">
				<a class="city" href="<%=request.getContextPath()%>/SelectCityServlet?city=花蓮縣">
					<img src="img/scene16.jpg" alt="花蓮縣" class="img-rounded"></a>
				<div class="caption">
				<h2>花蓮縣</h2>
					<div class="desc" style="padding-right: 10px;"><!--內容 --></div>
				</div>
				</div>						
			</td>			
			<td>			    
			    <div class="abgne_tip_gallery_block">
				<a class="city" href="<%=request.getContextPath()%>/SelectCityServlet?city=台東縣">
					<img src="img/scene17.jpg" alt="台東縣" class="img-rounded"></a>
				<div class="caption">
				<h2>台東縣</h2>
					<div class="desc" style="padding-right: 10px;"><!--內容 --></div>
				</div>
				</div>						
			</td>						
	    </tr>
	</table>		
  </div>
 </div>
</div>  
<!--圖片的滑出式說明 JQ-->
<script type="text/javascript">
 $(function(){
  // 預設標題區塊 .abgne_tip_gallery_block .caption 的 top
  var _titleHeight = 60;
  $('.abgne_tip_gallery_block').each(function(){
   // 先取得區塊的高及標題區塊等資料
   var $this = $(this), 
    _height = $this.height(), 
    $caption = $('.caption', $this),
    _captionHeight = $caption.outerHeight(true),
    _speed = 200;
   
   //連結
   $this.click(function(){
	  var name = $(".city").attr("href");
	   window.location.href =name;
   })
   
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
 });
</script>
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