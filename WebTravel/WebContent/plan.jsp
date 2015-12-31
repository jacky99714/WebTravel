<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<%@page import="model.util.TypeConveter" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>行程規劃</title>
	<style>
		.black_overlay{
            display: none;
            position: absolute;
            top: 0%;
            left: 0%;
            width: 100%;
            height: 100%;
            background-color: black;
            z-index:1001;
            -moz-opacity: 0.8;
            opacity:.80;
            filter: alpha(opacity=80);
        }

        .white_content {
            display: none;
            position: absolute;
            top: 10%;
            left: 10%;
            width: 75%;
            height: 75%;
            padding: 16px;
            border: 16px solid orange;
            background-color: white;
            z-index:1002;
            overflow: auto;
        }
        
        .close{
            position: absolute;
            top: 5px;
            right: 5px;
        }
        
        .head{
            text-align: center;
            font-size:36px;
        }

        .box {		
            border:3px ridge #DDDDDD;  
            width:560px;
            height:140px;	
        }
	
 		.line{
            width:100px;
            height:0px;
            border:3px ridge red;
        }
        
        .img{
        	 width:100px;
        	 height:100px;
        }
        
        .favcontent{
        	display:inline-block;
        }
        
        .icon{
        	 width:200px;
        	 height:120px;
        	 display:inline-block;     	
        }
        
        table{
            border:3px ridge #DDDDDD
        }
    
        td{
            border:3px ridge purple;  
        }
	</style>
	
	<script>
         var table;
         var totalImage = 0;
         var maxImg = 5;  // max image in tr tag
         var maxLine = 5;   
         
///////////////////////////////////////////////////////////
		function scheduleObject(memberId,scheduleName,scheduleOrder){
			this.memberId = memberId;
			this.scheduleName = scheduleName;
			this.scheduleOrder = scheduleOrder;
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
             var srcId = src.id;
             var srcParent = src.parentNode;
             var tar = ev.currentTarget;     //target image
             if(srcParent.id === "collection"){
                 return;
             }

             if(tar.id !== "garbage"){ 
                 var tarId = tar.id;
                 ev.currentTarget.replaceChild(src,tar);      //(new,old)
                 srcParent.appendChild(tar);                        
                 tar.id = srcId;     //exchangeId
                 src.id = tarId;                    
             }else{
                 var tr = srcParent.parentNode;
                 totalImage --;
                 if(srcParent.nextElementSibling !== null){
                     tr.removeChild(srcParent.nextElementSibling);
                 }else if(srcParent.previousElementSibling !== null){
                     tr.removeChild(srcParent.previousElementSibling);
                 }
                 srcParent.removeChild(src);  
                 tr.removeChild(srcParent);

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
             var id = "img"+img.id.substring(3);
             if(!document.getElementById(id)){
            	 appendImg(img.src,id,img.title); 
             }
                   
         }
////////////////////////////////////////////////////////////////
         
 		function getScene(){ 
			var select = document.getElementById("select").value;
	    	xhr = new XMLHttpRequest();
	    	if(xhr !== null){
		    	xhr.addEventListener("readystatechange",callback);
		    	xhr.open("get","GetSceneLocationServlet?location="+select,true); 
		    	xhr.send();		      	
	    	}else{
	    		alert("您的瀏覽器不支援Ajax功能!!");
	    	}
 		}

	    function callback(){
	    	if(xhr.readyState === 4){ 	
	    		if(xhr.status === 200){
			    	var data = JSON.parse(xhr.responseText);
			    	var searchcontent = document.getElementById("searchcontent");  //顯示資料
			    	searchcontent.innerHTML="";
			    	for(var i=0; i < data.length;i++){
			    		var img = createImg('data:image/png;base64,'+data[i].scenePhoto,data[i].sceneId,data[i].sceneName);
			    		searchcontent.appendChild(img);
			    	}

	    		}else{
	    			alert(xhr.status + ":" + xhr.statusText);
	    		}    		
	    	}  	
	    }
	    
	    function createSchedule(arrayObject){
	    	xhr = new XMLHttpRequest();
	    	if(xhr !== null){
	    		
		    	xhr.addEventListener("readystatechange",callbackSchedule);
		    	xhr.open("post","TestServlet",true); 
		    	xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
		    	xhr.send(arrayObject);		      	
	    	}else{
	    		alert("您的瀏覽器不支援Ajax功能!!");
	    	}	    	
	    }
	    
	    function callbackSchedule(){
	    	if(xhr.readyState === 4){ 	
	    		if(xhr.status === 200){
			    	var data = JSON.parse(xhr.responseText);
			   
	    		}else{
	    			alert(xhr.status + ":" + xhr.statusText);
	    		}    		
	    	}  	
	    }	    
/////////////////////////////////////////////
         function createImg(imgsrc,imgid,title){
             var img = new Image();
             img.src = imgsrc;
             img.title = title;
             img.id = imgid;
             img.className = "img";
             img.draggable = true;
             img.setAttribute('ondragstart', 'drag(event)');
             return img;
         }

         function createLine(){
             var line = document.createElement("div");
             line.className = "line";
             return line;
         }

         function createTd(input,imgsrc,imgid,imgtitle){
             var td = document.createElement("td");
             if(input === "line"){
                td.appendChild(createLine());
             }else if(input === "image"){
                td.setAttribute('ondrop', 'drop(event)');
                td.setAttribute('ondragover', 'allowDrop(event)');
                td.appendChild(createImg(imgsrc,imgid,imgtitle));
             }
             return td;
         }
               
         function appendImg(imgsrc,imgid,imgtitle){
      //  	 alert("total"+totalImage);
             if((maxLine * maxImg) === totalImage){
                 return;
             }
             
             var tdImg = createTd("image",imgsrc,imgid,imgtitle);
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
            document.getElementById("add").addEventListener("click",function(){
                document.getElementById('addContent').style.display='block';
                document.getElementById('addFavorite').style.display='none';
                document.getElementById('fade').style.display='block';
            });  
             
            document.getElementById("favorite").addEventListener("click",function(){
                document.getElementById('addContent').style.display='none';
                document.getElementById('addFavorite').style.display='block';
                document.getElementById('fade').style.display='block';
            });    

            document.getElementById("closeAdd").addEventListener("click",function(){
                document.getElementById('addContent').style.display='none';
                document.getElementById('addFavorite').style.display='none';
                document.getElementById('fade').style.display='none';
            });  
            
            document.getElementById("closeFavorite").addEventListener("click",function(){
                document.getElementById('addContent').style.display='none';
                document.getElementById('addFavorite').style.display='none';
                document.getElementById('fade').style.display='none';
            }); 
            
            document.getElementById("sure").addEventListener("click",function(){
            	var schedule = [];
            	for( var i=0; i<totalImage;i++){
            		schedule[i] = scheduleObject(1,i+"日遊",i);
            	}	
            	createSchedule(schedule);    	
            	
            });
            
            document.getElementById("select").addEventListener("change", getScene);
            table = document.getElementById("tab");
            totalImage = 0;

       
 
            for(var i=0;i < ${fn:length(fav)};i++){	
                document.getElementsByName("favimg")[i].addEventListener("click", click);                 
            }         
                
        }	
	</script>
</head>
<body>
	<div class="head">行程規劃</div>

        <div id="addContent" class="white_content"> 
            <img  id="closeAdd" class="close" src="img/close.png">
			<select id="select">
				<option value="北區">北區</option>
				<option value="中區">中區</option>
				<option value="南區">南區</option>
				<option value="東區">東區</option>
			</select>
			<div id="searchcontent">
			
			</div>		
        </div>
        
        <div id="addFavorite" class="white_content"> 
            <img  id="closeFavorite" class="close" src="img/close.png">
             <div class ="favcontent">
            	<c:forEach var="fav" varStatus="status" items="${fav}">          	
	          		<div class="favcontent">
          				<img id= 'fav${fav.sceneId}' name="favimg" title="${fav.sceneName}"  class="img"             
        					src='data:image/png;base64,${fav.scenePhoto}'/> 
        				<div>${fav.sceneName}</div>
	        		</div>
	        		<c:if test="${status.count %5==0}">
	        			<br/>
	        		</c:if>
            	</c:forEach>
            </div>
        </div>
        
        <div id="fade" class="black_overlay"> </div>
  
        <div class ="icon">
           <img id="garbage" class ="imgicon" src="img/garbage.png"  ondrop="drop(event)" ondragover="allowDrop(event)">
        </div> 
              
        <div class ="icon">
           <img id="favorite"  src="img/favorite.png">
        </div>
        
        <div class ="icon">
           <img id="add" class ="imgicon" src="img/add.png">
        </div>
	<table id="tab">
	</table>
	<button id="sure">行程確認</button>
</body>

</html>