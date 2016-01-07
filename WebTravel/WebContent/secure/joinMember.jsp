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
    <link href="<c:url value="/secure/css/datepicker.css" />" rel="stylesheet">
 
    
	
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body style="padding:71px;">
  <jsp:include page="/WEB-INF/top/top.jsp"/>

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
		 			 <div id="pa1" class="form-group">
		   				 <label class="col-sm-3 control-label" for="password">密碼：</label>
		   				 <div class="col-sm-5">
		   				 <input type="password" class="form-control" name="password" id="password" placeholder="密碼" ><p id="pass1" class="text-danger">${errorMap.password}</p>
		   				 </div>
		  			</div>
		  			<div id="pa2" class="form-group">
		   				 <label class="col-sm-3 control-label" for="password">再次確認密碼：</label>
		   				 <div class="col-sm-5">
		   				 <input type="password" class="form-control" name="password2" id="password2" placeholder="再次輸入密碼"><p id="pass2" class="text-danger">${errorMap.password2}</p>
		   				 
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
					    <button type="button" class="btn btn-default" id="exampleInputFile1" name="photo1">上傳大頭貼</button>
		   				 <img id="img001" style="width:100px;height:100px" src="data:image/png;base64,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">
					    <input style="display:none" type="file" id="exampleInputFile" name="photo">
					    </div>
					  </div>
					  
		 			 <button id="btn" type="button" class="btn btn-default col-md-3 col-md-offset-3">一鍵輸入</button>
		 			 <button type="submit" class="btn btn-default col-md-3">加入會員</button>
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
    <script src="<c:url value="/secure/js/bootstrap-datepicker.js" />" charset="UTF-8"></script>
    <script src="<c:url value="/secure/js/joinMember.js" />"></script>
    <script src=" <c:url value="/secure/js/locales/bootstrap-datepicker.zh-TW.js" />" charset="UTF-8"></script>

  </body>
</html>