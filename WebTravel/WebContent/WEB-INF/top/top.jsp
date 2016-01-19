<%@page import="model.util.TypeConveter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet">
    
    
    
    
     <div class="navbar-wrapper navbar-fixed-top">
      <div class="container">
        <nav class="navbar navbar-inverse navbar-static-top">
          <div class="container-fluid">
<!-- 		      <div class="row"> -->
<!-- 			<div class="col-md-8"> -->
            <div class="navbar-header">
              <a class="navbar-brand"><img  style="width:40px;margin-top:-.7em" src="<c:url value="/img/logo3.png" />"></a>
              <a class="navbar-brand" href="<c:url value="/index.jsp" />">旅行微革命</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
            
              <ul class="nav navbar-nav ">
                <li class="dropdown"><a href="<c:url value="/index.jsp" />">Home</a></li>
				<!-- class=active<li>當前頁面 -->
				
<!-- 	------------------------景點------------------------ -->
                <li class="dropdown ">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">景點 <span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="<c:url value="/scene/scene.jsp" />">景點介紹</a></li>
                    <li><a href="#">新增景點</a></li>
					</ul>
                </li>
<!-- 	------------------------景點------------------------ -->
                
                
<!-- 	------------------------美食------------------------ -->
<!--                  <li class="dropdown"> -->
<!--                   <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">美食 <span class="caret"></span></a> -->
<!--                   <ul class="dropdown-menu"> -->
<!--                     <li><a href="#">美食介紹</a></li> -->
<!--                     <li><a href="#">新增美食</a></li> -->
<!--                   </ul> -->
<!--                 </li> -->
<!-- 	------------------------美食------------------------ -->
                
<!-- 	------------------------行程------------------------ -->

<!-- <!-- 	------------------------行程------------------------ -->
<!--                 <li class="dropdown"> -->
<!--                   <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">行程規劃 <span class="caret"></span></a> -->
<!--                   <ul class="dropdown-menu"> -->
                  
<%--                     <li><a href="<c:url value="/plan/plan.jsp" />">新增行程</a></li> --%>
<!--                     <li><a href="#">行程管理</a></li> -->
<!--                   </ul> -->
<!--                 </li> -->
<!-- <!-- 	------------------------行程------------------------ --> 
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">旅遊日記 <span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="<c:url value="/thought/ThoughtPage.jsp" />">日記</a></li>
                    <li><a href="<c:url value="/thought/Thought.jsp" />">日記分享</a></li>
                  </ul>
                </li>
<!-- 	------------------------行程------------------------ -->


<!-- 	------------------------休閒時光------------------------ -->

                 <li >
                  <a href="<c:url value="/game/game.jsp"/>">休閒時光 </a>
                </li>
              </ul>
<!-- 	------------------------休閒時光------------------------ -->



<!-- 	------------------------景點------------------------ -->
<!--                 登入 -->
			<c:if test="${empty loginOk}">
				<ul class="nav navbar-nav navbar-right ">
                <li class="dropdown"><a href="<c:url value="/secure/login.jsp" />">登入</a></li>
              	</ul>
              	              <!-- 	------------------------行程------------------------ -->
              <ul class="nav navbar-nav navbar-right">
                <li>
                	<c:if test="${not empty scheduleListFB.size()}">
                	  <a href="<c:url value="/plan/plan.jsp" />">已加入旅遊清單項目：<span id="scheduleSize"><img value="${scheduleListFB.size()}" id="scheduleSizeimg" style="width:20px;height:20px" src="/WebTravel/img/number/number${scheduleListFB.size()}.png"/></span></a>
                	</c:if>
                	<c:if test="${empty scheduleListFB.size()}">
                	  <a href="<c:url value="/plan/plan.jsp" />">已加入旅遊清單項目：<span id="scheduleSize"><img value="0" id="scheduleSizeimg" style="width:20px;height:20px" src="/WebTravel/img/number/number0.png"/></span></a>
                  </c:if>
<!--                   <ul class="dropdown-menu"> -->
<%--                     <li><a href="<c:url value="/plan/plan.jsp" />">已加入旅遊清單項目</a></li> --%>
<!--                   </ul> -->
                </li>
                </ul>
<!-- 	------------------------行程------------------------ -->
              </c:if>
              <c:if test="${not empty loginOk}">
              <ul class="nav navbar-nav navbar-right ">
               <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">會員管理<span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="<c:url value="/JMember/MyMember.jsp" />">我的帳號</a></li>
                    <li><a href="<c:url value="/MyCollectServlet" />">我的收藏</a></li>
                    <li><a href="<c:url value="/MyScheduleServlet" />">我的行程規劃</a></li>
<!--                     <li role="separator" class="divider"></li> -->
<!--                     <li class="dropdown-header">Nav header</li> -->
                    <li><a href="<c:url value="/LogoutServlet" />">登出</a></li>
<!--                     <li><a href="#">One more separated link</a></li> -->
                  </ul>
                </li>
              	</ul>
              <ul class="nav navbar-nav navbar-right">
				<c:if test="${not empty memberimg}">
					<li><img style="margin-top:5px" width="40px" height="40px" src="data:image/png;base64,${memberimg}" alt="..." class="imgtoptop"></li>
				</c:if>
               <li><a href="#">${loginOk.userName},你好
               <c:if test="${mbMessageCount!=0}">
               <span class="badge" style="background:#CC0000">${mbMessageCount}</span>
               </c:if>
               </a></li>
              </ul>
              
              <!-- 	------------------------行程------------------------ -->
              <ul class="nav navbar-nav navbar-right">
                <li>
                	<c:if test="${not empty scheduleListFB.size()}">
                	  <a href="<c:url value="/plan/plan.jsp" />">已加入旅遊清單項目：<span id="scheduleSize"><img value="${scheduleListFB.size()}" id="scheduleSizeimg" style="width:20px;height:20px" src="/WebTravel/img/number/number${scheduleListFB.size()}.png"/></span></a>
                	</c:if>
                	<c:if test="${empty scheduleListFB.size()}">
                	  <a href="<c:url value="/plan/plan.jsp" />">已加入旅遊清單項目：<span id="scheduleSize"><img value="0" id="scheduleSizeimg" style="width:20px;height:20px" src="/WebTravel/img/number/number0.png"/></span></a>
                  </c:if>
<!--                   <ul class="dropdown-menu"> -->
<%--                     <li><a href="<c:url value="/plan/plan.jsp" />">已加入旅遊清單項目</a></li> --%>
<!--                   </ul> -->
                </li>
                </ul>
<!-- 	------------------------行程------------------------ -->
              
              </c:if>
<!-- 	------------------------景點------------------------ -->
<!--               登入 -->
              </div>
            </div><!--container -->
        </nav>
          </div>

      </div>

    
