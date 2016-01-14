<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的收藏</title>
<link rel="shortcut icon" href="<c:url value="/img/icon.ico"/>">  
    <!-- Bootstrap -->
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/JMember/css/magnific-popup.css"/>">
	<script src="js/jquery.magnific-popup.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
 <style type="text/css">
 .ss{
 	padding:71px;
 }
 .delete{}
 .joinSchedule{}
 .removeSchedule{}
 .imglist{width:120px;height:100px}
 </style>
  </head>
  <body class="ss">
  <jsp:include page="/WEB-INF/top/top.jsp"/>
<%@ page import="model.util.*"%>
<%
	int a = 0;
	int rowCount = (Integer)session.getAttribute("rowCount");
	int pageSize = (Integer)session.getAttribute("pageSize");
	int pageq = (Integer)session.getAttribute("pageq");
	int start = (Integer)session.getAttribute("start");
	int end = (Integer)session.getAttribute("end");
	
	int startN = start;
	int endN = end;
	
%>
<!--     我是內容---------------------------- -->
    <div class="container-fluid">
    <table id="simpleTable" class="table table-hover" style="background-color: 	#E8E8E8;border-radius:10px;">
  		<thead>
<!--   			<th>景點編號</th> -->
  			<th>圖片</th>
<!--   			<th>區域</th> -->
  			<th></th>
  			<th>景點</th>
  			<th>內容</th>
<!--   			<th>開始時間</th> -->
<!--   			<th>結束時間</th> -->
  			<th></th>
  		</thead>
  		<tbody>
   		 <c:forEach var="scene" begin="${start}" end="${end-1}" items="${sceneList}" varStatus="s">
   			<tr>
<%-- 	  			<td>${scene.sceneId}</td> --%>
	  			<td><a href="data:image/png;base64,${scene.scenePhoto}" class="image-popup-no-margins"><img class="imglist" src="data:image/png;base64,${scene.scenePhoto}"/></a></td>
<%-- 	  			<td>${scene.location}</td> --%>
	  			<td>${scene.city}</td>
	  			<td>${scene.sceneName}</td>
	  			<td>${scene.sceneContent}</td>
<%-- 	  			<td>${scene.timeStart}</td> --%>
<%-- 	  			<td>${scene.timeEnd}</td> --%>
	  			<td><button id="s${scene.sceneId}" value="${scene.sceneId}" class="btn btn-warning btn joinSchedule" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>  加入行程</button>  <button value="${scene.sceneId}" class="btn btn-danger btn delete" data-toggle="modal" data-target=".bs-example-modal-sm"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>  刪除</button></td>
<%-- 	  			<td>${scene.memberId}</td> --%>
  			</tr>
  			<%a++;%>
		   </c:forEach>
  		</tbody>
	 </table>
    
</div>



  <ul class="pagination">
    <li>
    <%
    int startn =start-pageSize;
    int endn = end-pageSize;
    if(startn<0){startn=0; endn=pageSize;}
          //組你showdata.jsp的路徑從webapp開始
    //如果你是放在webapp/test/showdata.jsp
    String strPre ="/MyCollectServlet?start="+startn+"&end="+endn;
    %>
      <a href="<%=request.getContextPath()%><%=strPre %>" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
<%
for(int i= 0; i< pageq;i++){
  start = pageSize *i;
  end = start+pageSize;
  if(end>rowCount){end = rowCount;}
        //組你showdata.jsp的路徑從webapp開始
  //如果你是放在webapp/test/showdata.jsp
  String str ="/MyCollectServlet?start="+start+"&end="+end;
%>
<li><a href=<%=request.getContextPath()%><%=str %>><font>第<%=i+1%>頁　</font></b></a></li>
<% }%>  
    <li>
   	<%
    int starte =startN+pageSize;
    int ende = endN+pageSize;
    if(ende>rowCount){
    	ende = rowCount;
    	if(starte>=rowCount){
    		starte=starte-pageSize;
    	}
    }
          //組你showdata.jsp的路徑從webapp開始
    //如果你是放在webapp/test/showdata.jsp
    String strNa ="/MyCollectServlet?start="+starte+"&end="+ende;
    %>
      <a href="<%=request.getContextPath()%><%=strNa %>" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>





<!-- Modal -->
<div id="myModal001" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">你確定?</h4>
      </div>
      <div class="modal-body">
        		你確定要刪除嗎?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" id="Closebtn" class="btn btn-danger">確定刪除</button>
      </div>
    </div>
  </div>
</div>
<!--  -->

<!--  Modal -->
<!-- <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"> -->
<!--   <div class="modal-dialog" role="document"> -->
<!--     <div class="modal-content"> -->
<!--       <div class="modal-header"> -->
<!--         <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button> -->
<!--         <h4 class="modal-title" id="myModalLabel">修改</h4> -->
<!--       </div> -->
<!--       <div class="modal-body"> -->
<!-- 修改內容 -->

<!-- 內容結束 -->
<!--       </div> -->
<!--       <div class="modal-footer"> -->
<!--         <button type="button" class="btn btn-default" data-dismiss="modal">修改</button> -->
<!--         <button type="button" class="btn btn-primary">取消</button> -->
<!--       </div> -->
<!--     </div> -->
<!--   </div> -->
<!-- </div> -->
<!--     -->
    <hr class="featurette-divider">
    <footer>
    <p class="pull-right"><a href="#">Back to top</a></p>
    <p> 2015 Travel, Inc. &middot; <a href="#">聯絡我們</a>
    </footer>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src=" <c:url value="/js/bootstrap.min.js"/>"></script>
   
    <script type="text/javascript" src=" <c:url value="/JMember/js/myCollect.js"/>"></script>
    </script>
  </body>
</html>