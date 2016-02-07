<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>旅行微革命-心得</title>
<link rel="shortcut icon" href="<c:url value="/img/icon.ico"/>">  
<h3 style="text-align: center">日記分享</h3>

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
 
 <c:if test="${empty loginOk}">
	<%
			session.setAttribute("page", "thought/Thought.jsp");
		%>
    	<c:redirect url="/secure/login.jsp"></c:redirect>
 </c:if>
 
  </head>
  <body style="padding:71px;">
  <jsp:include page="/WEB-INF/top/top.jsp"/>

<!--     我是內容---------------------------- -->
    <div class="container-fluid">
    <div class="float">
    <form action="<c:url value="/ThoughtServlet" />" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
			<div>
				<div>
					<label>日記名稱</label>
				</div>
				<div>
					<input type="text" size="50" placeholder="台北一日遊" name="thoughtName"><p color='red'  size="-3">${errors.thoughtName}</p>
				</div>
			</div>
			<div>
				<div>
					<label>標題</label>
				</div>
				<div>
					<input type="text" size="70" placeholder="一座繁華的城市" name="thoughtSubtitle"><p color='red'  size="-3">${errors.thoughtSubtitle}</p>
				</div> 
			</div>
			<div>
				<div>
		    		<label>照片</label><span>-選一張到表此篇新的的美照吧</span><p color='red'  size="-3">${errors.thoughtPhoto}</p><input type="file" name="thoughtPhoto" multiple>
		    	</div>
			</div>
			<div>
				<label>日記內容</label><span> - 內容需100字以上</span><p color='red'  size="-3">${errors.thoughtContent}</p>
			</div>
			<div >
				 <textarea id="textarea" style="width: 50%; height: 452px" ></textarea>
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
//      alert(thoughtContent);
	$('#aaa').val(thoughtContent);
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
<!--     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> -->
    <!-- Include all compiled plugins (below), or include individual files as needed -->
   
<%--     <script src=" <c:url value="/js/bootstrap.min.js"/>"></script> --%>
  </body>
</html>