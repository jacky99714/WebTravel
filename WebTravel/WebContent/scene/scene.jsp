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

<!--     ---------------------------- -->
    <div class="container">
    
	
 <div class="row">
  
  
  <div class="col-md-10">
	<table class="table">
		<!--  ===============北部===============  -->
		<tr>
			<td><a href="<%=request.getContextPath()%>/SelectLocationServlet?location=北區" target="_self"><img src="img/scene01.jpg" alt="北區" class="img-rounded"></a></td>
			<td><a href="<%=request.getContextPath()%>/SelectCityServlet?city=台北市"><img src="img/scene01.jpg" alt="台北市" class="img-rounded"></a></td>
			<td><a href="<%=request.getContextPath()%>/SelectCityServlet?city=新北市"><img src="img/scene01.jpg" alt="新北市" class="img-rounded"></a></td>
			<td><a href="<%=request.getContextPath()%>/SelectCityServlet?city=基隆市"><img src="img/scene01.jpg" alt="基隆市" class="img-rounded"></a></td>
			<td><a href="<%=request.getContextPath()%>/SelectCityServlet?city=桃園市"><img src="img/scene01.jpg" alt="桃園市" class="img-rounded"></a></td>
			<td><a href="<%=request.getContextPath()%>/SelectCityServlet?city=新竹縣"><img src="img/scene01.jpg" alt="新竹縣" class="img-rounded"></a></td>
			<td><a href="<%=request.getContextPath()%>/SelectCityServlet?cityn=宜蘭縣"><img src="img/scene01.jpg" alt="宜蘭縣" class="img-rounded"></a></td>		
		</tr>
		<!--  ===============中部===============  -->
		<tr>		
			<td><a href="<%=request.getContextPath()%>/SelectLocationServlet?location=中區"><img src="img/scene02.jpg" alt="中區" class="img-rounded"></a></td>
			<td><a href="<%=request.getContextPath()%>/SelectCityServlet?city=苗栗縣"><img src="img/scene02.jpg" alt="苗栗縣" class="img-rounded"></a></td>
			<td><a href="<%=request.getContextPath()%>/SelectCityServlet?city=台中市"><img src="img/scene02.jpg" alt="台中市" class="img-rounded"></a></td>
			<td><a href="<%=request.getContextPath()%>/SelectCityServlet?city=彰化縣"><img src="img/scene02.jpg" alt="彰化縣" class="img-rounded"></a></td>
			<td><a href="<%=request.getContextPath()%>/SelectCityServlet?city=南投縣"><img src="img/scene02.jpg" alt="南投縣" class="img-rounded"></a></td>
			<td><a href="<%=request.getContextPath()%>/SelectCityServlet?city=雲林縣"><img src="img/scene02.jpg" alt="雲林縣" class="img-rounded"></a></td>						
		</tr>
		<!--  ===============南部===============  -->
		<tr>
			<td><a href="<%=request.getContextPath()%>/SelectLocationServlet?location=南區"><img src="img/scene03.jpg" alt="南區" class="img-rounded"></a></td>
			<td><a href="<%=request.getContextPath()%>/SelectCityServlet?city=嘉義縣"><img src="img/scene03.jpg" alt="嘉義縣" class="img-rounded"></a></td>
			<td><a href="<%=request.getContextPath()%>/SelectCityServlet?city=台南市"><img src="img/scene03.jpg" alt="台南市" class="img-rounded"></a></td>
			<td><a href="<%=request.getContextPath()%>/SelectCityServlet?city=高雄市"><img src="img/scene03.jpg" alt="高雄市" class="img-rounded"></a></td>
			<td><a href="<%=request.getContextPath()%>/SelectCityServlet?city=屏東縣"><img src="img/scene03.jpg" alt="屏東縣" class="img-rounded"></a></td>
			<td><a href="<%=request.getContextPath()%>/SelectCityServlet?city=澎湖縣"><img src="img/scene03.jpg" alt="澎湖縣" class="img-rounded"></a></td>		
			<td><a href="<%=request.getContextPath()%>/SelectCityServlet?city=金門縣"><img src="img/scene03.jpg" alt="金門縣" class="img-rounded"></a></td>		
		</tr>
		<!--  ===============東部===============  -->
		<tr>
			<td><a href="<%=request.getContextPath()%>/SelectLocationServlet?location=東區"><img src="img/scene04.jpg" alt="東區" class="img-rounded"></a></td>
			<td><a href="<%=request.getContextPath()%>/SelectCityServlet?city=花蓮縣"><img src="img/scene04.jpg" alt="花蓮縣" class="img-rounded"></a></td>
			<td><a href="<%=request.getContextPath()%>/SelectCityServlet?city=台東縣"><img src="img/scene04.jpg" alt="台東縣" class="img-rounded"></a></td>				
		</tr>
	</table>		
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