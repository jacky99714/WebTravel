<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    
    
     <div class="navbar-wrapper navbar-fixed-top">
      <div class="container">
        <nav class="navbar navbar-inverse navbar-static-top">
          <div class="container-fluid">
<!-- 		      <div class="row"> -->
<!-- 			<div class="col-md-8"> -->
            <div class="navbar-header">
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
              </ul>
<!--                 登入 -->
			<c:if test="${empty loginOk}">
				<ul class="nav navbar-nav navbar-right ">
                <li class="dropdown"><a href="<c:url value="/secure/login.jsp" />">登入</a></li>
              	</ul>
              </c:if>
              <c:if test="${not empty loginOk}">
              <ul class="nav navbar-nav navbar-right ">
               <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">會員管理<span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="#">我的帳號</a></li>
                    <li><a href="#">我的收藏</a></li>
                    <li><a href="#">我的行程規劃</a></li>
<!--                     <li role="separator" class="divider"></li> -->
<!--                     <li class="dropdown-header">Nav header</li> -->
                    <li><a href="<c:url value="/LogoutServlet" />">登出</a></li>
<!--                     <li><a href="#">One more separated link</a></li> -->
                  </ul>
                </li>
              	</ul>
              <ul class="nav navbar-nav navbar-right">
               <li><a href="#">${loginOk.userName},你好</a></li>
              </ul>
              </c:if>
<!--               登入 -->
              </div>
            </div><!--container -->
          </div>
        </nav>

      </div>
    </div>
    

   