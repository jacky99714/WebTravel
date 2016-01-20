<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>休閒時光</title>
	<link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">  
	<link href="<c:url value="/game/game.css"/>" rel="stylesheet">  

</head>
<body style="padding:71px;">	
	<jsp:include page="/WEB-INF/top/top.jsp"/>
	<div class="game">
		<div id="box" class="box"></div>	
	
		<div class="bar">
			<div class="enemybartext">BOSS HP:</div>
			<div class="enemybarline">	
				<div id="enemyhp"></div> 
			</div>			 			
		</div>
		
		<div class="user">
			<img class="littlephoto" id="photo2" >	
		
			<div class="userbar">
				<div class="bar">
					<div class="bartext">HP:</div>
					<div class="barline">	
						<div id="userhp"></div> 
					</div>			 			
				</div>
			
				<div class="bar">
					<div class="bartext">MP:</div>
					<div class="barline">						
						<div id="usermp"></div> 	  
					</div> 
				</div>				
			</div>		
		</div>
			
		<div id="btn" class="allbtn">
			<input class ="btn" id="reStart" type="button" value="重新開始"/>
		</div>
	
		<canvas id="canvas" width=" 460" height="300"> </canvas>	
		<audio  id="backAudio">
			<source src="audio/bgsound.mp3" type="audio/mp3"/>	
		</audio>		
		</div>
	    <hr class="featurette-divider">
	    <footer>
	    <p class="pull-right"><a href="#">Back to top</a></p>
	    <p> 2015 Travel, Inc. &middot; <a href="#">聯絡我們</a>
	    </footer>
	
	    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	    <!-- Include all compiled plugins (below), or include individual files as needed -->
	   
	    <script src=" <c:url value="/js/bootstrap.min.js"/>"></script>	
</body><script type="text/javascript" src="game.js"></script>
</html>