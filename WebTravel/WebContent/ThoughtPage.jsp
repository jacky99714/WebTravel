<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>輸入你的標題！</title>
<link rel="shortcut icon" href="<c:url value="/img/icon.ico"/>">  

    <!-- Bootstrap -->
     
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
	
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body style="padding:71px;">
  <jsp:include page="/WEB-INF/top/top.jsp"/>

<!--     我是內容---------------------------- -->
	<div class="container">
		<form action="#" method="post" accept-charset="UTF-8">
			<div>
				<label>類型:</label> <select name="add1">
					<option value="Restaurant">餐廳</option>
					<option value="Scence">景點</option>
					<option value="Both">綜合</option>
				</select>
				<button id="button1" class="btn btn-primary">Search</button>
			</div>
			<div id="div1"></div>
			
		</form>


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
   
    <script src=" <c:url value="/js/bootstrap.min.js"/>"></script>
    <script src="js/jquery-2.1.4.min.js"></script>
    
    <script type="text/javascript">
    	
    </script>
    
    
    
    
  </body>
</html>