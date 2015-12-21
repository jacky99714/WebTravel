<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>加入會員</title>

	<link rel="shortcut icon" href="<c:url value="/img/icon.ico"/>">  

    <!-- Bootstrap -->
   
    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
	
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body style="padding:71px;">
  <jsp:include page="/top/top.jsp"/>

<!--     我是內容---------------------------- -->
<!-- <div class="jumbotron" style="background:#FFFFFF"> -->

    <div class="container">
    	<form class="form-horizontal" id="formLogin" action="<c:url value="/JoinMemberServlet"/>" method="post" enctype="multipart/form-data">
		  			<div class="form-group">
		   				 <label class="col-sm-3 control-label" for="useid">帳號：</label>
		   				 <div class="col-sm-5">
		   				 <input type="text" class="form-control" name="useid" id="useid" placeholder="帳號" value="${param.useid}"><p class="text-danger">${errorMap.useid}</p>
		   				 </div>
		  			</div>
		 			 <div class="form-group">
		   				 <label class="col-sm-3 control-label" for="password">密碼：</label>
		   				 <div class="col-sm-5">
		   				 <input type="password" class="form-control" name="password" id="password" placeholder="密碼" ><p class="text-danger">${errorMap.password}</p>
		   				 </div>
		  			</div>
		  			<div class="form-group">
		   				 <label class="col-sm-3 control-label" for="password">再次確認密碼：</label>
		   				 <div class="col-sm-5">
		   				 <input type="password" class="form-control" name="password2" id="password2" placeholder="再次輸入密碼" >
		   				 </div>
		  			</div>
		  			<div class="form-group">
		   				 <label class="col-sm-3 control-label" for="lastname">姓氏：</label>
		   				 <div class="col-sm-5">
		   				 <input type="text" class="form-control" name="lastname" id="lastname" placeholder="王" value="${param.lastname}"><p class="text-danger">${errorMap.lastname}</p>
		   				 </div>
		  			</div>
		  			<div class="form-group">
		   				 <label class="col-sm-3 control-label" for="firstname">姓名：</label>
		   				 <div class="col-sm-5">
		   				 <input type="text" class="form-control" name="firstname" id="firstname" placeholder="小明" value="${param.firstname}">
		   				 </div>
		  			</div>
		  			<div class="form-group">
		   				 <label class="col-sm-3 control-label" for="nickname">暱稱：</label>
		   				 <div class="col-sm-5">
		   				 <input type="text" class="form-control" name="nickname" id="nickname" placeholder="阿明" value="${param.nickname}">
		   				 </div>
		  			</div>
		  			<div class="form-group">
		   				 <label class="col-sm-3 control-label" for="birthday">生日：</label>
		   				 <div class="col-sm-5">
		   				 <input type="text" class="form-control" name="birthday" id="birthday" placeholder="1991-11-11" value="${param.birthday}"><p class="text-danger">${errorMap.birthday}</p>
		   				 </div>
		  			</div>
		  			<div class="form-group">
		   				 <label class="col-sm-3 control-label" for="cphone">手機電話：</label>
		   				 <div class="col-sm-5">
		   				 <input type="text" class="form-control" name="cphone" id="cphone" placeholder="0919191919" value="${param.cphone}"><p class="text-danger">${errorMap.cphone}</p>
		   				 </div>
		  			</div>
		  			<div class="form-group">
		   				 <label class="col-sm-3 control-label" for="hphone">家用電話：</label>
		   				 <div class="col-sm-5">
		   				 <input type="text" class="form-control" name="hphone" id="hphone" placeholder="02-22222222" value="${param.hphone}">
		   				 </div>
		  			</div>
		  			<div class="form-group">
		   				 <label class="col-sm-3 control-label"  for="email">E-mail：</label>
		   				 <div class="col-sm-5">
		   				 <input type="email" class="form-control" name="email" id="email" placeholder="Json@gmail.com" value="${param.email}"><p class="text-danger">${errorMap.email}</p>
		   				 </div>
		  			</div>
		  			<div class="form-group">
		   				 <label class="col-sm-3 control-label"  for="addr">地址：</label>
		   				 <div class="col-sm-5">
		   				 <input type="text" class="form-control" name="addr" id="addr" placeholder="台北市大安區..." value="${param.addr}">
		   				 </div>
		  			</div>
		  			 <div class="form-group">
					    <label class="col-sm-3 control-label"  for="exampleInputFile">上傳大頭貼:</label>
		   				 <div class="col-sm-5">
					    <input type="file" id="exampleInputFile" name="photo">
					    </div>
					  </div>
		 			 <button type="submit" class="btn btn-default col-md-3 col-md-offset-3">加入會員</button>
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
    <script src="<c:url value="/js/bootstrap.min.js" />"></script>
    
  </body>
</html>