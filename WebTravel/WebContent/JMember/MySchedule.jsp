<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的行程</title>
<link rel="shortcut icon" href="<c:url value="/img/icon.ico"/>">  

    <!-- Bootstrap -->
     
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/JMember/css/schedule.css"/>" rel="stylesheet">
    <link href="<c:url value="/JMember/css/jquery-ui.css"/>" rel="stylesheet">
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	    <script src="<c:url value="/JMember/js/jquery-ui.js"/>"></script>
	    
	    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
   <style type="text/css">
   .scheduleId{}
   .scheduleSelect{}
   .table>tbody>tr>td{
 	border-top:0px !important;
 	}
   .strong1{
     font-size:larger;
   }
   .p_duration{
   	color:red;
   }
   .di{}
   .map {
    width: 870px;
    height: 300px;
}
   </style> 
    
    
  </head>
  
  <body style="padding:71px;">
  <jsp:include page="/WEB-INF/top/top.jsp"/>

<!--     我是內容---------------------------- -->
    <div class="container-fluid">
    	
    <h1 style="text-align:center;">我的行程</h1>
    <dir class="row">
    	<div class="col-md-8">
    	<table class="table table-hover">
    	<c:forEach items="${listSchedule}" var="Schedule">
    		<tr class="trheader" value="dddd">
    			<td value="${Schedule.scheduleId}" id="${Schedule.scheduleId}" class="scheduleId">
    				<strong class="strong1">${Schedule.scheduleName}</strong>
    			</td>
    			<td class="td2" style="width:200px;">
	    			<button value="${Schedule.scheduleId}" class="btn btn-warning btn scheduleSelect" data-toggle="modal" data-target=".bs-example-modal-lg">編輯行程</button> 
	    			 <button value="${Schedule.scheduleId}" class="btn btn-danger btn delete" data-toggle="modal" data-target=".bs-example-modal-sm">
	    				 <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>  刪除
	    			 </button>
    			 </td>
    		</tr>
    		<tr class="conte" value="ssss">
    			<td>
    			</td>
    			<td>
    			 </td>
    		</tr>
    	</c:forEach>
    	</table>
    	</div>
	    	<div class="col-md-4">
	    		<div class="map-marker-01" style="height:300px;width:350px;">
	    		</div>
	    	</div>
    </dir><!-- row END -->

<!-- <div class="abgne_tip_gallery_block"> -->
<!-- 	<a href="#"><img src="http://goo.gl/C4psy7"  width="450px" title="" alt="" /></a>  -->
<!-- 	<div class="caption_grall"> -->
<!-- 		<h2><a href="#" title="猛甲茶道">猛甲茶道</a></h2> -->
<!-- 		<div class="desc" style="padding-right:10px;">sssss</div> -->
<!-- 	</div> -->
<!-- </div> -->
   
   
<!-- <div class="col-md-2" id="1" value="53">    -->
<!-- 	<div class="thumbnail"> -->
<!-- 	    <div class="abgne_tip_gallery_block"> -->
<!-- 			<img src="http://goo.gl/C4psy7" style="width: 144.656px;height: 120px;"title="" alt="" /> -->
<!-- 			<div class="caption_grall"> -->
<!-- 				<h7>猛甲茶道</h7> -->
<!-- 				<div class="desc" style="padding-right:10px;">sssss</div> -->
<!-- 			</div> -->
<!-- 	</div> -->
<!-- 		    <div class="caption"> -->
<!-- 			    <h5>文化會館</h5> -->
<!-- 			    <p>第1景點</p> -->
<!-- 		    </div> -->
<!-- 	</div> -->
<!-- </div> -->
    
    
    
    
    <!--  Modal -->
<div class="modal fade bs-example-modal-lg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content" style="background-color:rgba(0,0,0,0.3);">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" style="text-align:center;font-weight:900;" id="myModalLabel">拖曳照片修改行程順序</h4>
        <div class="map"></div>

      </div>
      <div class="modal-body">

		<div class="row" id="sortable">
		
		</div>



      </div>
      <div class="modal-footer">
        <button type="button" id="Upbtn" class="btn btn-default">修改</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
      </div>
    </div>
  </div>
</div>


<!-- 你確定要刪除 -->
<div id="myModal001" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
  <div class="modal-dialog modal-sm">
    <div class="modal-content" >
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">你確定?</h4>
      </div>
      <div class="modal-body" >
        		你確定要刪除嗎?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" id="Closebtn" class="btn btn-danger">確定刪除</button>
      </div>
    </div>
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
   
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src=" <c:url value="/JMember/js/jquery.tinyMap.min.js"/>"></script>
    <script src=" <c:url value="/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/JMember/js/MySchedule.js"/>"></script>
    
  </body>
</html>