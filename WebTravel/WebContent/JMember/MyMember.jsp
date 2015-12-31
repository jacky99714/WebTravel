<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>基本資料</title>
<link rel="shortcut icon" href="<c:url value="/img/icon.ico"/>">  

    <!-- Bootstrap -->
     
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
	
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
 <style type="text/css">
 .table>tbody>tr>td{
 	border-top:0px !important;
 }

 </style>
  </head>
  <body style="padding:71px;">
  <jsp:include page="/WEB-INF/top/top.jsp"/>

<!--     我是內容---------------------------- -->
<!--     <div class="container-fluid"> -->
    <div class="jumbotron">
    	<div class="row">
    		<div class="col-md-3 col-md-offset-1">
	    		<c:if test="${not empty memberimg}">
					<img style="width:210px;height:210px;" src="data:image/png;base64,${memberimg}" class="img-circle">
				</c:if>
	    		<c:if test="${empty memberimg}">
					<img style="width:210px;height:210px;" src="data:image/png;base64,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" class="img-circle">
				</c:if>
    		</div>
    		<div class="col-md-8">
    			<table class="table">
    				<tbody>
    					<tr>
    						<td><h2>名字:</h2></td>
    						<td><h2>${loginOk.firstName}</h2></td>
    					</tr>
    					<tr>
    						<td><h2>姓氏:</h2></td>
    						<td><h2>${loginOk.lastName}</h2>
		    			</td>
    					</tr>
    					<tr>
    						<td><h2>暱稱:</h2></td>
    						<td><h2>${loginOk.nickName}</h2>
		    			</td>
    					</tr>
    					<tr>
    						<td><h2>生日:</h2></td>
    						<td><h2>${loginOk.birthDay}</h2>
		    			</td>
    					</tr>
    					<tr>
    						<td><h2>住址:</h2></td>
    						<td><h2>${loginOk.address}</h2>
		    			</td>
    					</tr>
    					<tr>
    						<td><h2>手機電話:</h2></td>
    						<td><h2>${loginOk.cellphone}</h2>
		    			</td>
    					</tr>
    					<tr>
    						<td><h2>家裡電話:</h2></td>
    						<td><h2>${loginOk.telephone}</h2>
		    			</td>
    					</tr>
    					<tr>
    						<td><h2>E-mail:</h2></td>
    						<td><h2>${loginOk.email}</h2></td>
    					</tr>
    					<tr>
    						<td><button></button></td>
    						<td><button></button></td>
    					</tr>
    				</tbody>
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
   
    <script src=" <c:url value="/js/bootstrap.min.js"/>"></script>
  </body>
</html>