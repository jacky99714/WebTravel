<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
	
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body style="padding:71px;">

     <div class="navbar-wrapper navbar-fixed-top">
      <div class="container">
        <nav class="navbar navbar-inverse navbar-static-top">
          <div class="container">
            <div class="navbar-header">
            <div class="btn-group btn-info">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              </div>
              <a class="navbar-brand" href="#">旅行微革命</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav ">
                <li class="active"><a href="#">Home</a></li>
				<!-- class=active<li>當前頁面 -->
                 <li class="dropdown ">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">景點 <span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="#">景點介紹</a></li>
                    <li><a href="#">新增景點</a></li>
					</ul>
                </li>
                
                
                 <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">美食 <span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="#">美食介紹</a></li>
                    <li><a href="#">新增美食</a></li>
                  </ul>
                </li>
                
                
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">行程規劃 <span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="#">新增行程</a></li>
                    <li><a href="#">行程管理</a></li>
                  </ul>
                </li>
                
                 <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">休閒時光 </a>
                </li>
                
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">會員管理<span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="#">我的帳號</a></li>
                    <li><a href="#">我的收藏</a></li>
                    <li><a href="#">我的行程規劃</a></li>
<!--                     <li role="separator" class="divider"></li> -->
<!--                     <li class="dropdown-header">Nav header</li> -->
<!--                     <li><a href="#">Separated link</a></li> -->
<!--                     <li><a href="#">One more separated link</a></li> -->
                  </ul>
                </li>
                
              </ul>
            </div>
          </div>
        </nav>

      </div>
    </div>
 
<!--     ---------------------------- -->
   <div class="jumbotron" style="background:#FFFFFF">
   <div class="row">
   		<div class="col-md-8">
   			<h2>歡迎來到旅行微革命<small>讓旅行更美麗</small></h2>
   			<hr class="featurette-divider">
   			<div class="row">
   				<div class="col-md-4">
   						<img src="../img/travelview.jpg" alt="..." class="img-thumbnail">
   				</div>
   				<div class="col-md-8">
		   			<p class="lead">在步調快速的生活裡，想要去玩卻不知道怎麼玩，還在為規劃行程煩惱嗎？這時候就需要一個好的旅遊網站來引導你；能讓你的行程更加豐富，還沒加入我們快點加入我們吧！！！
		   			</p>
   				</div>
   			</div>
   		</div>
   		<div class="col-md-4">
<!--   		登入表單 -->
		   	<div class="container">
		   		<h3>會員中心<small>登入你的帳號</small></h3>
		   		<form class="form-inline" id="formLogin" action="/WebTravel/LoginServlet" method="get">
		  			<div class="form-group">
		   				 <label class="sr-only" for="useid">帳號：</label>
		   				 <input type="text" class="form-control" name="useid" id="useid" placeholder="帳號" value="${param.useid}">
		  			</div><br>
		 			 <div class="form-group">
		   				 <label class="sr-only" for="password">密碼：</label>
		   				 <input type="password" class="form-control" name="password" id="password" placeholder="密碼" value="${param.password}">
		  			</div><br>
		 			 <button type="submit" class="btn btn-default">登入</button>
				</form>
	   		</div>
<!--    		form表單的結尾 -->
   		</div>
   </div>

    </div>
<!--     ------------------------------------- -->
    <hr class="featurette-divider">
    <footer>
    <p class="pull-right"><a href="#">Back to top</a></p>
    <p> 2015 Travel, Inc. &middot; <a href="#">聯絡我們</a>
    </footer>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../js/bootstrap.min.js"></script>
  </body>
</html>