<%@page import="model.bean.SceneBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.sun.corba.se.impl.javax.rmi.CORBA.Util"%>
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
<%ArrayList<SceneBean> list =(ArrayList<SceneBean>)session.getAttribute("sceneList"); 
	int a = 0;
	
%>


<!--     我是內容---------------------------- -->
    <div class="container-fluid">
    <table id="simpleTable" class="table table-hover">
  		<thead>
  			<th>景點編號</th>
  			<th>圖片</th>
<!--   			<th>區域</th> -->
  			<th>縣市</th>
  			<th>景點名稱</th>
  			<th>內容</th>
  			<th>開始時間</th>
  			<th>結束時間</th>
  			<th></th>
  		</thead>
  		<tbody>
   		 <c:forEach var="scene" items="${sceneList}">
   			<tr>
	  			<td>${scene.sceneId}</td>
	  			<td><a href="data:image/png;base64,<%=TypeConveter.EncodeBase64(list.get(a).getScenePhoto())%>" class="image-popup-no-margins"><img class="imglist" src="data:image/png;base64,<%=TypeConveter.EncodeBase64(list.get(a).getScenePhoto())%>"/></a></td>
<%-- 	  			<td>${scene.location}</td> --%>
	  			<td>${scene.city}</td>
	  			<td>${scene.sceneName}</td>
	  			<td></td>${scene.sceneContent}
	  			<td>${scene.timeStart}</td>
	  			<td>${scene.timeEnd}</td>
	  			<td><button id="s${scene.sceneId}" value="${scene.sceneId}" class="btn btn-warning btn joinSchedule" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>  加入行程</button>  <button value="${scene.sceneId}" class="btn btn-danger btn delete" data-toggle="modal" data-target=".bs-example-modal-sm"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>  刪除</button></td>
<%-- 	  			<td>${scene.memberId}</td> --%>
  			</tr>
  			<%a++;%>
		   </c:forEach>
  		</tbody>
	 </table>
    
</div>

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