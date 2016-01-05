<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>行程規劃</title>
	<link rel=stylesheet type="text/css" href="plan.css">

	<script>
         var table;
         var totalImage = 0;
         var maxImg = 5;  // max image in tr tag
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
             var srcId = src.id;
             var srcParent = src.parentNode;
             var tar = ev.currentTarget;     //target td
             if(srcParent.id === "collection"){
                 return;
             }

             if(tar.id !== "garbage"){ 
                 var tarId = tar.id;
                 ev.currentTarget.parentNode.replaceChild(src,tar);      //(new,old)
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
  		function getImage(content){ 	
	    	xhr = new XMLHttpRequest();
	    	if(xhr !== null){
		    	if(content==="favcontent"){
		    		xhr.addEventListener("readystatechange",callbackFavorite);
		    		xhr.open("get","${pageContext.request.contextPath}/GetFavoriteServlet",true); 
		    	}else if(content==="searchContent"){
		    		xhr.addEventListener("readystatechange",callbackSearch);
		    		var select = document.getElementById("select").value;
		    		xhr.open("get","${pageContext.request.contextPath}/GetSceneLocationServlet?location="+select,true); 
		    	}
		    	xhr.send();	
	    	}else{
	    		alert("您的瀏覽器不支援Ajax功能!!");
	    	}
 		}

	    function callbackSearch(){
	    	if(xhr.readyState === 4){ 	
	    		if(xhr.status === 200){
			    	var data = JSON.parse(xhr.responseText);
			    	createImgContent(data,"searchContent");
	    		}else{
	    			alert(xhr.status + ":" + xhr.statusText);
	    		}    		
	    	}  	
	    }
	    
	    function callbackFavorite(){
	    	if(xhr.readyState === 4){ 	
	    		if(xhr.status === 200){
			    	var data = JSON.parse(xhr.responseText);
			    	createImgContent(data,"favcontent");
	    		}else{
	    			alert(xhr.status + ":" + xhr.statusText);
	    		}    		
	    	}  	
	    }	    
	    function createSchedule(arrayObject){
	    	xhr = new XMLHttpRequest();
	    	if(xhr !== null){	    
		    	xhr.addEventListener("readystatechange",callbackSchedule);
		    	xhr.open("post","${pageContext.request.contextPath}/InsertScheduleServlet",true); 
		    	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		    	xhr.send("json="+arrayObject);		      	
	    	}else{
	    		alert("您的瀏覽器不支援Ajax功能!!");
	    	}	    	
	    }
	    
	    function callbackSchedule(){
	    	if(xhr.readyState === 4){ 	
	    		if(xhr.status === 200){
	    			alert("success insert");   
	    		}else{
	    			alert(xhr.status + ":" + xhr.statusText);
	    		}    		
	    	}  	
	    }	    
/////////////////////////////////////////////
		 function createImgContent(data,content){
		    	var searchcontent = document.getElementById(content);  //顯示資料
		    	searchcontent.innerHTML="";
		    	for(var i=0; i < data.length;i++){
		            var div = document.createElement("div");
		            div.className = "favcontent";        
		    		var img = createImg('data:image/png;base64,'+data[i].scenePhoto,"fav"+data[i].sceneId,data[i].sceneName);
		    		img.addEventListener("click", click);
		    		var divName = document.createElement("div");
		    		var text = document.createTextNode(data[i].sceneName);
		    		divName.appendChild(text);
		    		div.appendChild(img);
		    		div.appendChild(divName);
		    		searchcontent.appendChild(div);
		    	}	
		 } 
         function createImg(imgsrc,imgid,title){
             var img = new Image();
             img.src = imgsrc;
             img.title = title;
             img.id = imgid;
             img.className = "img";
             img.draggable = true;
             img.setAttribute('ondragstart', 'drag(event)');
             img.setAttribute('ondrop', 'drop(event)');
             img.setAttribute('ondragover', 'allowDrop(event)');
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
//                 td.setAttribute('ondrop', 'drop(event)');
//                 td.setAttribute('ondragover', 'allowDrop(event)');
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
        	table = document.getElementById("tab");
            document.getElementById("add").addEventListener("click",function(){
                document.getElementById('addSearch').style.display='block';
                document.getElementById('addFavorite').style.display='none';
                document.getElementById('fade').style.display='block';
            });  
             
            document.getElementById("favorite").addEventListener("click",function(){
                document.getElementById('addSearch').style.display='none';
                document.getElementById('addFavorite').style.display='block';
                document.getElementById('fade').style.display='block';
            });    

            document.getElementById("closeAdd").addEventListener("click",function(){
                document.getElementById('addSearch').style.display='none';
                document.getElementById('addFavorite').style.display='none';
                document.getElementById('fade').style.display='none';
            });  
            
            document.getElementById("closeFavorite").addEventListener("click",function(){
                document.getElementById('addSearch').style.display='none';
                document.getElementById('addFavorite').style.display='none';
                document.getElementById('fade').style.display='none';
            }); 
            
            document.getElementById("sure").addEventListener("click",function(){
            	var text =  document.getElementById('scheduleName').value;
            	scheduleArray = null;
            	scheduleArray = [];
            	//schedule(memberId,scheduleName,scheduleOrder,sceneID)
            	var td = document.getElementsByTagName("td");
            	var num = 0;
            	for (var i = 0; i < td.length;i++){
            		if(i % 2 == 0){
            			var img = td[i].firstElementChild;

            			scheduleArray[num] = new schedule(1,text,num+1,img.id.substring(3));
            			num++;
            			//${loginOk.memberId}
            		}
            	}
            	// schedule(memberId,scheduleName,scheduleOrder,sceneID)
           
              	createSchedule(JSON.stringify(scheduleArray));    	
            	
            });
            
            document.getElementById("select").addEventListener("change", function(){
            	getImage("searchContent");
            });
            getImage("favcontent");
            getImage("searchContent");
   
            totalImage = 0;
                
        }	
	</script>
</head>
<body>
	<div class="head">行程規劃</div>

	<div id="addSearch" class="white_content"> 
		<img  id="closeAdd" class="close" src="img/close.png"/>
		<select id="select">
			<option value="北區">北區</option>
			<option value="中區">中區</option>
			<option value="南區">南區</option>
			<option value="東區">東區</option>
		</select>
		<div id ="searchContent" ></div>
	</div>
        
    <div id="addFavorite" class="white_content"> 
		<img  id="closeFavorite" class="close" src="img/close.png"/>		      	
        <div id="favcontent"></div>
	</div>
        
    <div id="fade" class="black_overlay"> </div>
  
	<div class ="icon">
	   <img id="garbage" class ="imgicon" src="img/garbage.png"  ondrop="drop(event)" ondragover="allowDrop(event)"/>
	</div> 
              
    <div class ="icon">
       <img id="favorite"  src="img/favorite.png">
    </div>
        
    <div class ="icon">
       <img id="add" class ="imgicon" src="img/add.png">
    </div>
        
    <div>
	    <input id="scheduleName" type="text" placeholder="行程名稱"/>
		<button id="sure">行程確認</button>   
    </div>
	<table id="tab">
	</table>
</body>
</html>