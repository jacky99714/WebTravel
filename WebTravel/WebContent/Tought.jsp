<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>旅行微革命-心得</title>
<link rel="shortcut icon" href="<c:url value="/img/icon.ico"/>">  

    <!-- Bootstrap -->
     
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
	
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/editor.css" type="text/css" rel="stylesheet"/>
<script src="js/editor.js"></script>
 
  </head>
  <body style="padding:71px;">
  <jsp:include page="/top/top.jsp"/>

<!--     我是內容---------------------------- -->
    <div class="container">
    <div class="float">
    <form action="/pages/thought.controller" method="get">
			<div>
				<div>
					<span>心得名稱</span>
				</div>
				<div>
					<input type="text" sixe="70" placeholder="請勿超過40個字">
				</div>
			</div>
			<div>
				<label>種類</label> <select>
					<option>餐廳</option>
					<option>景點</option>
					<option>綜合</option>
				</select>
			</div>
			<div>
				<div>
					<span>旅行日期</span> <span>-此旅行心得是何時去的？</span>
				</div>
				<input type="text" placeholder="請選擇日期">
			</div>
			<div>
				<span>心得內容</span><span> - 內容需100字以上</span>
			</div>
			<div >
				<textarea id="textarea"  style="width: 50%; height: 452px" ></textarea>
			</div>
			
			<div>
				<input id="sb" type="submit" value="送出">
			</div>
		</form>
			</div>
		
<!-- 		<form action="#"> -->
<!-- 				<textarea  id="textarea" name="ss" style="width: 50%; height: 452px" ></textarea> -->
<!-- 			<input id="sb" type="submit" value="送出"> -->
<!-- 		</form> -->
	</div>

<script >

$(document).ready( function() {
    $("#textarea").Editor();                    
  });
  


// $(document).ready( function() {
// 	addEventListener("submit", function(){
//     var i = $("#textarea").Editor("getText"); 
//      alert(i);
		
// 	})
	
//   });
  
</script>
    
    
    
    
    
<!--  -->

    <hr class="featurette-divider">
    <footer>
    <p class="pull-right"><a href="#">Back to top</a></p>
    <p> 2015 Travel, Inc. &middot; <a href="#">聯絡我們</a>
    </footer>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!--     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> -->
    <!-- Include all compiled plugins (below), or include individual files as needed -->
   
<%--     <script src=" <c:url value="/js/bootstrap.min.js"/>"></script> --%>
  </body>
</html>