<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>日記</title>
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
  <jsp:include page="/WEB-INF/top/top.jsp"></jsp:include>

<!--     我是內容---------------------------- -->
	<div class="container">
		<div class="row" id="div1">
<!-- 			<div  class="row"> -->
<%-- 				<c:forEach var="thoughtlist" items="${list}"> --%>
<!-- 					<div class="col-xs-6 col-md-3"> -->
<!-- 						<div class="thumbnail"> -->

<!-- 							<a href="https://www.google.com.tw" class="thumbnail"><img -->
<!-- 								src="/img/Carousel01.jpg" alt="a"></a> -->
<!-- 							<div class="caption"> -->
<!-- 								<div> -->
<%-- 									<h3>${thoughtlist.thoughtName}</h3> --%>
<!-- 								</div> -->
<%-- 								<div>${thoughtlist.thoughtSubtitle}</div> --%>
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<%-- 				</c:forEach> --%>
<!-- 			</div> -->
<!-- 			<div class="col-xs-6 col-md-3"> -->
<!-- 				<div class="thumbnail"> -->
<!-- 					<a href="https://www.google.com.tw" class="thumbnail"> -->
<!-- 						<img alt="a" src="../img/Carousel01.jpg"></a> -->
<!-- 					<div id="div1" class="caption"> -->
						
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
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
   
<%--     <script src=" <c:url value="/js/bootstrap.min.js"/>"></script> --%>
<!--     <script src="js/jquery-2.1.4.min.js"></script> -->
<!--     <script type="text/javascript" src="http://masonry.desandro.com/jquery.masonry.min.js"></script> -->
    
    <script type="text/javascript">
// 	    var btn = document.getElementById("button1");
// 		btn.addEventListener("click",getType);
	
    	function getThought() {
// 			var select = document.getElementById("select").value;
			xhr = new XMLHttpRequest();
			if (xhr !== null) {
				xhr.addEventListener("readystatechange",callbackThought);
				xhr.open("get", "DisplayThoughtServlet", true);
				xhr.send();
			} else {
				alert("您的瀏覽器不支援Ajax功能!!");
			}
		}
	
		function callbackThought() {
			if (xhr.readyState === 4) {
				if (xhr.status === 200) {
					var data = JSON.parse(xhr.responseText);
					var myDiv = document.getElementById("div1");
					//appendScheduleContent(data);
					while(myDiv.hasChildNodes()){
						myDiv.removeChild(myDiv.lastChild);
					}
					for (var i=0;i<data.length;i++){
						console.log(data[i].thoughtId);
						console.log(data[i].thoughtName);
						console.log(data[i].thoughtSubtitle);
						console.log(data[i].thoughtPhoto);
						console.log(data[i].thoughtContent);
						console.log(data[i].thoughtTime);
						console.log(data[i].memberId);
	// 					alert(data[0]);
	// 					console.log(data);
						
						var name = data[i].thoughtName;
						var subtitle = data[i].thoughtSubtitle;
						var photo = data[i].thoughtPhoto;
						var id = data[i].thoughtId;
						
						var div2 = document.createElement("div");
						div2.className="col-xs-6 col-md-3";
						var div3 = document.createElement("div");
						div3.className="thumbnail";
						
						div2.appendChild(div3);
						div1.appendChild(div2);
						
						var a1 = document.createElement("a");
						var img = document.createElement("img");
						var div4 = document.createElement("div");
						
						div3.appendChild(a1);
						div3.appendChild(div4);
						a1.appendChild(img);
						
						var title = document.createElement("h3");
						var txtH3 = document.createTextNode(name);
						title.appendChild(txtH3);
						div4.appendChild(title);
						
						
						//抓出心得內容
						var contents = document.createElement("p");
// 						contents.className="col-md-8";
						contents.innerHTML = subtitle;
						div4.appendChild(contents);
// 						myDiv.innerHTML=data[i].thoughtSubtitle;
					}
// 			    		myDiv.innerHTML = "<h3>" + data + "</h3>";
				}else {
					alert(xhr.status + ":" + xhr.statusText);
				}
			}
		}
		 window.onload = function(){
			 getThought();
		 }
</script>
    
    
    
    
  </body>
</html>