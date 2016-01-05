<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
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

<link rel="stylesheet" href="css/justified-nav.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">

<!-- JavaScript -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/holder.js"></script>

</head>
  <body style="padding:71px;">

  
<div class="row">
<!--   <div class="col-sm-6 col-md-3"> -->
<!--     <div class="thumbnail"> -->
<!--       <img data-src="holder.js/300x200" alt="..."> -->
<!--       <div class="caption"> -->
<!--         <h3>台北101</h3> -->
<!--         <p>台北101是位於中華民國台灣臺北市信義區的摩天大樓，樓高509.2公尺，地上樓層共有101層、另有地下5層，總樓地板面積37萬4千平方公尺，由李祖原聯合建築師事務所設計、KTRT團隊建造，</p> -->
<!--         <p> -->
<!--            <button type="button" class="btn btn-primary btn-sm"> -->
<!-- 		   <span class="glyphicon glyphicon-align-left" aria-hidden="true"></span> 介紹 -->
<!-- 		   </button> -->
		   
<!--            <button type="button" class="btn btn-success btn-sm"> -->
<!-- 		   <span class="glyphicon glyphicon-star" aria-hidden="true"></span> 收藏 -->
<!-- 		   </button> -->
           
<!--            <button class="btn btn-warning btn joinSchedule btn-sm"> -->
<!--            <span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>  行程 -->
<!--            </button> -->
         
<!-- 		</p> -->
<!--         <div class="ratings"> -->
<!--            <p class="pull-right">15 reviews</p> -->
<!--            <p> -->
<!--            <span class="glyphicon glyphicon-star"></span> -->
<!--            <span class="glyphicon glyphicon-star"></span> -->
<!--            <span class="glyphicon glyphicon-star"></span> -->
<!--            <span class="glyphicon glyphicon-star"></span> -->
<!--            <span class="glyphicon glyphicon-star-empty"></span> -->
<!--            </p> -->
<!--         </div> -->
<!--       </div> -->
<!--     </div> -->
<!--   </div> -->
  <c:forEach var="sceneli" items="${li}">
   <div class="col-sm-6 col-md-3">
    <div class="thumbnail">
      <img style="width:300px;height:200px;" src="data:image/jpg;base64,${sceneli.scenePhoto}"/>
      <div class="caption">
        <h3>${sceneli.sceneName}</h3>
        <p>${sceneli.sceneContent}</p> 
                <p>
           <button type="button" class="btn btn-primary btn-sm" value="${sceneli.sceneName}" onclick="self.location.href='<%=request.getContextPath()%>/SelectSceneContextServlet'">
		   <span class="glyphicon glyphicon-align-left" aria-hidden="true" ></span> 介紹
		   </button>
		   
           <button type="button" id="btnadd" class="btn btn-success btn-sm" onclick="addFavorite()">
		   <span class="glyphicon glyphicon-heart" aria-hidden="true"></span> 收藏
		   </button>
           
           <button class="btn btn-warning btn joinSchedule btn-sm">
           <span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>  行程
           </button>
         
		</p>
        
      </div>
    </div>
  </div>
  </c:forEach>

</div><!-- class="row" -->
<!-- JavaScript Ajax非同步 addFavorite -->
<script>
	   //找到要控制的元素   物件導向  物件.屬性  = ""   物件.方法();
	    var btn = document.getElementById("btnadd");
	    //綁訂事件
	    btn.addEventListener("click",load);
	    //btn.onclick = load;
	 
	    var xhr = null;
	    function load(){	
	    	//步驟一建立Ajax物件
	    	xhr = new XMLHttpRequest();
	    	
	    	if(xhr != null){
		    	//步驟二對Server端發出要求
		    	//當readyState屬性改變的時候會觸發readystatachange事件
		    	//readyState會從0->1->2->3->4 所以readystatechange事件會被觸發4次
		    	xhr.addEventListener("readystatechange",callback);
		    	xhr.open("get","/SceneAddFavoriteServlet",true); //true表示非同步
		    	xhr.send("memberId=${loginOk.memberId}&sceneId=${sceneli.sceneContent}&collectId=1");
		    	
		    	
	    	}else{
	    		alert("您的瀏覽器不支援Ajax功能!!");
	    	}

	    }
	    
	    function callback(){
	    	console.log("readyState : " + xhr.readyState);
	    	
	    	//readyState=4 表示資料已經回傳到client端了
	    	if(xhr.readyState == 4){
	    		//status=200表示Server端程式的執行沒有錯誤
	    		if(xhr.status == 200){
	    			//步驟三接收Server端回應的結果(string)
			    	var data = xhr.responseText;
			    	
			    	//將結果顯示到網頁上
			    	var myDiv = document.getElementById("div1");
			    	myDiv.innerHTML = "<h3>" + data + "</h3>";
	    		}else{
	    			alert(xhr.status + ":" + xhr.statusText);
	    		}    		
	    	}
	    	
	    	
	    	
	    }
	</script>

</body>
</html>