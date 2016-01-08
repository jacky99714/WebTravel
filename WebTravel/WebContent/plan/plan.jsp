<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>行程規劃</title>
	<link rel="shortcut icon" href="<c:url value="/img/icon.ico"/>">
	<link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">  
	<link rel=stylesheet type="text/css" href="plan.css">

	<script>
         var table;
         var totalImage = 0;
         var maxImg = 4;  // max image in tr tag
         var maxLine = 5;   
         var scheduleArray = [];
///////////////////////////////////////////////////////////
		function schedule(memberId,scheduleName,scheduleOrder,sceneId){
			this.memberId = memberId;
			this.scheduleName = scheduleName;
			this.scheduleOrder = scheduleOrder;
			this.sceneId = sceneId;
		}

 /////////////////////////////////////////////////////////               
         function allowDrop(ev) {
             ev.preventDefault();
         }

         function drag(ev) {
             ev.dataTransfer.setData("text", ev.target.id);
         }

         function drop(ev) {
             ev.preventDefault();
             var src = document.getElementById (ev.dataTransfer.getData("text"));  //source image
             var srcTd = src.parentNode;
             var tar = ev.currentTarget;     //target 
      

             if(tar.id !== "garbage"){ 
                 var tarTd = tar.parentNode;
             	 tarTd.innerHTML = "";
             	 tarTd.appendChild(src); 
             	 tarTd.appendChild(createImgTitle(src.title)); 
                 srcTd.innerHTML = "";
                 srcTd.appendChild(tar);     
                 srcTd.appendChild(createImgTitle(tar.title)); 
                          
             }else{
         
            	 deleteImg(src.id.substring(3));
                 var tr = srcTd.parentNode;
                 totalImage --;
                 if(srcTd.nextElementSibling !== null){
                     tr.removeChild(srcTd.nextElementSibling);
                 }else if(srcTd.previousElementSibling !== null){
                     tr.removeChild(srcTd.previousElementSibling);
                 }
          
                 tr.removeChild(srcTd);

                 var trNum =  Math.ceil((totalImage+1) / maxImg); // how many tr tag
                 var srcLine = parseInt((tr.id).substring(2));  //source image tr number

                 if(srcLine+1 !== trNum){
                     for(var i = srcLine; i < (trNum-1); i++){
                         var tr1 = document.getElementById(("tr"+i));
                         var tr2 = document.getElementById(("tr"+(i+1)));
                         var moveUp = tr2.firstElementChild;        //move the first image to previous tr tag last childnode
                         if((totalImage+1) >= maxImg){
                             tr1.appendChild(createTd("line"));
                         }
                         if(moveUp !== null ){
                        	 tr1.appendChild(moveUp);                 
                         }

                         if(tr2.firstElementChild !== null){
                             tr2.removeChild(tr2.firstElementChild);
                         }
                     }   //end for                                          
                 }
                 if(totalImage % maxImg === 0){                   
                     table.removeChild(table.lastChild);
                 }
             }      
         }

         function click(ev){
             var img = ev.currentTarget;
             var sceneId = img.id.substring(3);
             if(!document.getElementById("img"+sceneId)){
            	 addImg(sceneId);
            	 appendImg(img.src,sceneId,img.title);    
             }    	                    
         }
////////////////////////////////////////////////////////////////
  		function getFavorite(){
	    	xhrFavorite = new XMLHttpRequest();
	    	if(xhrFavorite !== null){	
	    		xhrFavorite.addEventListener("readystatechange",callbackFavorite);
	    		xhrFavorite.open("get","GetFavoriteServlet",true); 
		    	xhrFavorite.send();	
	    	}else{
	    		alert("您的瀏覽器不支援Ajax功能!!");
	    	}	
		}
		
	    function callbackFavorite(){
	    	if(xhrFavorite.readyState === 4){ 	
	    		if(xhrFavorite.status === 200){
			    	var data = JSON.parse(xhrFavorite.responseText);
			    	createImgContent(data);
	    		}else{
	    			alert(xhrFavorite.status + ":" + xhrFavorite.statusText);
	    		}    		
	    	}  	
	    }
	    
  		function getSchedule(){
	    	xhrSchedule = new XMLHttpRequest();
	    	if(xhrSchedule !== null){	
	    		xhrSchedule.addEventListener("readystatechange",callbackSchedule);
	    		xhrSchedule.open("get","GetScheduleServlet",true); 
		    	xhrSchedule.send();	
	    	}else{
	    		alert("您的瀏覽器不支援Ajax功能!!");
	    	}	
		}

	    function callbackSchedule(){
	    	if(xhrSchedule.readyState === 4){ 	
	    		if(xhrSchedule.status === 200){
			    	var data = JSON.parse(xhrSchedule.responseText);
			    	appendScheduleContent(data);
	    		}else{
	    			alert(xhrSchedule.status + ":" + xhrSchedule.statusText);
	    		}    		
	    	}  	
	    }	
	    
  
  		function getSearch(select){ 	
	    	xhrSearch = new XMLHttpRequest();
	    	if(xhrSearch !== null){ 	
	    		xhrSearch.addEventListener("readystatechange",callbackSearch);	  
	    		xhrSearch.open("get","GetSceneLocationServlet?location="+select,true); 	
		    	xhrSearch.send();	
	    	}else{
	    		alert("您的瀏覽器不支援Ajax功能!!");
	    	}
 		}

	    function callbackSearch(){
	    	if(xhrSearch.readyState === 4){ 	
	    		if(xhrSearch.status === 200){
			    	var data = JSON.parse(xhrSearch.responseText);
			    	createImgContent(data);
	    		}else{
	    			alert(xhrSearch.status + ":" + xhrSearch.statusText);
	    		}    		
	    	}  	
	    }
	    
    
	    function createSchedule(arrayObject){
	    	xhrcreate = new XMLHttpRequest();
	    	if(xhrcreate !== null){	    
		    	xhrcreate.addEventListener("readystatechange",callbackCreateSchedule);
		    	xhrcreate.open("post","InsertScheduleServlet",true); 
		    	xhrcreate.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		    		
		    	xhrcreate.send("json="+arrayObject);		      	
	    	}else{
	    		alert("您的瀏覽器不支援Ajax功能!!");
	    	}	    	
	    }
	    
	    function callbackCreateSchedule(){
	    	if(xhrcreate.readyState === 4){ 	
	    		if(xhrcreate.status === 200){
	    			document.getElementById("insert").innerHTML = "資料新增成功";
	    		 	table.innerHTML = "";
	    		 	totalImage = 0;
	    		 	setTimeout(function (){
	    		 		document.getElementById("insert").innerHTML = "";
	    		 	}, 2000);
	    		
	    		}else{
	    			alert(xhrcreate.status + ":" + xhrcreate.statusText);
	    		}    		
	    	}  
	    }	    

	    
	    function addImg(sceneid){
	    	xhradd = new XMLHttpRequest();
	    	if(xhradd !== null){	    
	    		xhradd.addEventListener("readystatechange",null);	  
	    		xhradd.open("get","${pageContext.servletContext.contextPath}/AddScheduleServlet?scene="+sceneid,true); 	
		    	xhradd.send();		      	
	    	}else{
	    		alert("您的瀏覽器不支援Ajax功能!!");
	    	}		    	
	    }
	    
	    function deleteImg(sceneid){
	    	xhrdelete = new XMLHttpRequest();
	    	if(xhrdelete !== null){	    
	    		xhrdelete.addEventListener("readystatechange",null);	  
	    		xhrdelete.open("get","deleteSchedule?deleteId="+sceneid,true); 	
	    		alert("deleteImg "+sceneid);
		    	xhrdelete.send();		      	
	    	}else{
	    		alert("您的瀏覽器不支援Ajax功能!!");
	    	}		    	
	    }
/////////////////////////////////////////////
		 function createImgContent(data){
		    	var content = document.getElementById("content");  //顯示資料
		    	content.innerHTML="";
		    	for(var i=0; i < data.length;i++){
		            var div = document.createElement("div");
		            div.className = "imgContent";        
		    		var img = createImg('data:image/png;base64,'+data[i].scenePhoto,data[i].sceneId,data[i].sceneName);
		    		img.id = "fav"+data[i].sceneId;
		    		img.addEventListener("click", click);
		    		var divName = document.createElement("div");
		    		var text = document.createTextNode(data[i].sceneName);
		    		divName.appendChild(text);
		    		div.appendChild(img);
		    		div.appendChild(divName);
		    		content.appendChild(div);
		    	}	
		 } 
		 
		 function appendScheduleContent(data){  
		 	table.innerHTML = "";
		 	totalImage = 0;
		 	for(var i=0; i < data.length;i++){     
	    		imgid =  data[i].sceneId;
	    		imgsrc = 'data:image/png;base64,'+data[i].scenePhoto;
	    		imgtitle = data[i].sceneName;
	    		appendImg(imgsrc,imgid,imgtitle);
	    	}	
		 } 		 
         function createImg(imgsrc,sceneId,title){
             var img = new Image();
             img.src = imgsrc;
             img.id = "img"+sceneId;
             img.title = title;
             img.className = "img";
             img.draggable = true;
             img.setAttribute('ondragstart', 'drag(event)');
             img.setAttribute('ondrop', 'drop(event)');
             img.setAttribute('ondragover', 'allowDrop(event)');
             return img;
         }

         function createLine(){
        	 var img = new Image();
 			 img.value = "line";
        	 img.src = "img/forward.png";
        	 img.className = "img";
             return img;
         }

         function createTd(input,imgsrc,sceneId,title){
             var td = document.createElement("td");
             if(input === "line"){
                td.appendChild(createLine());
             }else if(input === "image"){
                td.appendChild(createImg(imgsrc,sceneId,title));
                td.appendChild(createImgTitle(title));
             }
             return td;
         }
         
         function createImgTitle(imgtitle){
    		var divName = document.createElement("div");
    		var text = document.createTextNode(imgtitle);
    		divName.appendChild(text);
    		return divName;
         }
               
         function appendImg(imgsrc,sceneId,title){
             if((maxLine * maxImg) === totalImage){
                 return;
             }
             
             var tdImg = createTd("image",imgsrc,sceneId,title);
             var tr;

             if( totalImage % maxImg === 0){
                tr = document.createElement("tr");
                tr.id = "tr"+ Math.floor(totalImage / maxImg );      
                table.appendChild(tr);
             }

             tr = document.getElementById("tr"+ Math.floor(totalImage / maxImg ));

             if(totalImage % maxImg !== 0){      
                 var tdLine = createTd("line",null);
                 tr.appendChild(tdLine);
             }
             tr.appendChild(tdImg);     
             totalImage++;  
         } 

        window.onload = function(){
        	table = document.getElementById("tab");
            document.getElementById("sure").addEventListener("click",function(){
            	var text =  document.getElementById('scheduleName').value;
            	if(text === ""){
            		alert("schedule name");
            		return;
            	}
            	scheduleArray = null;
            	scheduleArray = [];
            	//schedule(memberId,scheduleName,scheduleOrder,sceneID)
            	var td = document.getElementsByTagName("td");
            	var num = 0;
            	for (var i = 0; i < td.length;i++){
            		var img = td[i].firstElementChild;
            		if(img.value !== "line"){           
            			scheduleArray[num] = new schedule(${loginOk.memberId},text,num+1,img.id.substring(3));        
            			num++;
            			//${loginOk.memberId}
            		}
            	}
            	// schedule(memberId,scheduleName,scheduleOrder,sceneID)
           
              	createSchedule(JSON.stringify(scheduleArray));    	
            	
            });
            
            getSchedule();
            getFavorite();
            document.getElementById("fav").addEventListener("click", function(){
            	getFavorite();
            });       
            document.getElementById("北區").addEventListener("click", function(){
            	getSearch("北區");
            });            
            document.getElementById("中區").addEventListener("click", function(){
            	getSearch("中區");
            });
            document.getElementById("南區").addEventListener("click", function(){
            	getSearch("南區");
            });
            document.getElementById("東區").addEventListener("click", function(){
            	getSearch("東區");
            });       
            
            document.getElementById("reset").addEventListener("click", function(){
            	table.innerHTML = "";
            	totalImage = 0;
            	deleteImg(-1);        	
            });            

   
            totalImage = 0;
                
        }	
	</script>
</head>
<body style="padding:71px;">
	<jsp:include page="/WEB-INF/top/top.jsp"></jsp:include>
    <div class="container-fluid">
   		<div class="row">	
			<input id="scheduleName" type="text" placeholder="行程名稱"/>
			<button id="sure">行程確認</button>  
			<span id="insert"></span>  		
   		</div>
   		<hr/>
	    <div class="row">	
	  		<div class="col-md-8">
				<img id="garbage" class ="imgicon" src="img/garbage.png"  ondrop="drop(event)" ondragover="allowDrop(event)"/>	
				<img id="reset" class ="imgicon" src="img/reset.png" />	
				<table id="tab">
				</table>   		
	  		</div>
	  		<div class="col-md-4">
				<div class="btn-group" role="group" aria-label="fileMenu">
					<button id="fav" class="btn btn-default">我的收藏 </button>
				  	<div class="btn-group" role="group">
				    	<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					                          搜尋景點
					      	<span class="caret"></span>
				    	</button>
					    <ul class="dropdown-menu">
		 					<li id="北區"><a>北區</a></li>
		            		<li role="separator" class="divider"></li>
		            		<li id="中區"><a>中區</a></li>
		            		<li role="separator" class="divider"></li>
		            		<li id="南區"><a>南區</a></li>
		            		<li role="separator" class="divider"></li>
		            		<li id="東區"><a>東區</a></li>
					    </ul>
				  	</div>
				</div>	 
				<div id="content"></div>
				
				 		
    		</div>
		</div>
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
</body>
</html>