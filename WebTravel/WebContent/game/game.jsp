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
<body>	
		<div class="game">
			<div id="box" class="box"></div>	
			
			<div class="littlefig">
				<img id="photo2" >	
			</div>
			
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
		
			<div class="bar">
				<div class="enemybartext">BOSS HP:</div>
				<div class="enemybarline">	
					<div id="enemyhp"></div> 
				</div>			 			
			</div>
			<div id="btn" class="allbtn">
				<input class ="btn" id="reStart" type="button" value="重新開始"/>
			</div>
		
			<canvas id="canvas" width=" 460" height="300"> 		
			</canvas>	
			<audio  id="backAudio">
				<source src="audio/bgsound.mp3" type="audio/mp3"/>	
			</audio>		
		
		
		
		</div>
			

	
</body><script type="text/javascript" src="game.js"></script>
</html>