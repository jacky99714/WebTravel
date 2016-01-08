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
 <style type="text/css">
 .d{width:200px;height:200px}
 </style>
  </head>
  <body style="padding:71px;">
  <jsp:include page="/WEB-INF/top/top.jsp"/>

<!--     我是內容---------------------------- -->
    <div class="container-fluid">
    <div class="float">
    <form action="ThoughtServlet" method="post" accept-charset="UTF-8">
			<div>
				<div>
					<span>心得名稱</span>
				</div>
				<div>
					<input type="text" size="70" placeholder="台北一日遊" name="thoughtName"><p color='red'  size="-3">${errors.thoughtName}</p>
				</div>
			</div>
			<div>
				<div>
					<label>標題</label>
				</div>
				<div>
					<input type="text" size="70" placeholder="一座繁華的城市" name="thoughtSubtitle">
				</div> 
			</div>
<!-- 			<div> -->
<!-- 				<div> -->
<!-- 					<span>旅行日期</span> <span>-此旅行心得是何時去的？</span> -->
<!-- 				</div> -->
<!-- 				<input type="text" placeholder="請選擇日期"> -->
<!-- 			</div> -->
			<div>
				<span>心得內容</span><span> - 內容需100字以上</span><p color='red'  size="-3">${errors.thoughtContent}</p>
			</div>
			<div >
				 <textarea id="textarea" rows="25" cols="95"  ></textarea>
				 <input id="aaa" name="thoughtContent" type="hidden">
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


$(document).ready( function() {
	addEventListener("submit", function(){
    var thoughtContent = $("#textarea").Editor("getText"); 
     alert(thoughtContent);
	$('#aaa').val(thoughtContent)
	
	
// 	  $.ajax({
// 		  'type':'get', //post、delete、put
// 		  'url':'XMLServlet',
// 		  'dataType':'xml',  //json、script、html
// 		  'data':{"thoughtContent":thoughtContent},
// 		  'success':function(data){
// 			//data 就是一個XML DOM 
// 			$(data).find("Category").each(function(){
// 				//$(this) -> 表示Category物件
// 				console.log($(this).children("CategoryID").text());
// 				console.log($(this).children("CategoryName").text());
// 			})
// 		  }
// 	  });
	})
  });
  
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