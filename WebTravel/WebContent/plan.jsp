<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
        
        table{
            border:3px ridge #DDDDDD
        }
    
        td{
            border:3px ridge purple;  
        }
	</style>
	
	<script>
         var table;
         var imgId = 0;
         var totalImage = 0;
         var maxImg = 5;  // max image in tr tag
         var maxLine = 5;   
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
             var tar = ev.currentTarget.firstElementChild;     //target image
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
                         var moveUp = tr2.firstElementChild;
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
             appendImg(img.src);
         }
////////////////////////////////////////////////////////////////		
         function createImg(imgsrc){
             var img = new Image(80,80);
             img.src = imgsrc;
             img.id = imgId;
             img.draggable = true;
             img.setAttribute('ondragstart', 'drag(event)');
             imgId++;
             return img;
         }

         function createLine(){
             var line = document.createElement("div");
             line.className = "line";
             return line;
         }

         function createTd(input,imgsrc){
             var td = document.createElement("td");
             if(input === "line"){
                td.appendChild(createLine());
             }else if(input === "image"){
                td.setAttribute('ondrop', 'drop(event)');
                td.setAttribute('ondragover', 'allowDrop(event)');
                td.appendChild(createImg(imgsrc));
             }
             return td;
         }
               
         function appendImg(imgsrc){
             if((maxLine * maxImg) === totalImage){
                 return;
             }

             var tdImg = createTd("image",imgsrc);
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
            table = document.getElementById("tab");
            totalImage = 0;

            appendImg("img/freeze_f.bmp");
            appendImg("img/firen_f.bmp");
            appendImg("img/firzen_f.bmp");
            appendImg("img/john_f.bmp");
            appendImg("img/justin_f.bmp");
            appendImg("img/freeze_f.bmp");
            appendImg("img/firen_f.bmp");
            appendImg("img/firzen_f.bmp");
            appendImg("img/john_f.bmp");
            appendImg("img/justin_f.bmp");
                for(var i=1;i <= 6;i++){
                    document.getElementById("get"+i).addEventListener("click", click);                 
                }
        }	
	</script>
</head>
<body>
	<div class="head">行程規劃</div>


        <div id="addContent" class="white_content"> 
            <img id="get1" src="img/firenAttack.png" draggable="true" ondragstart="drag(event)">
            <img id="get2" src="img/firzenAttack.png" draggable="true" ondragstart="drag(event)">
            <img id="get3" src="img/freezeAttack.png" draggable="true" ondragstart="drag(event)">
            <img id="get4" src="img/johnAttack.png" draggable="true" ondragstart="drag(event)"> 
            <img  id="closeAdd" class="close" src="img/close.png">
     
        </div>
        
        <div id="addFavorite" class="white_content"> 
            <img id="get5" src="img/firenDefense.png" draggable="true" ondragstart="drag(event)">
            <img id="get6" src="img/firzenDefense.png" draggable="true" ondragstart="drag(event)">
            <img  id="closeFavorite" class="close" src="img/close.png">
             <div>
            	<c:forEach var="favorite" items="${fav}">
            		${favorite}<br>
            	</c:forEach>
            </div>
        </div>
        <div id="fade" class="black_overlay"> </div>
  
        
        <div>
           <img id="favorite" src="img/favorite.png">
        </div>
        <div>
           <img id="add" src="img/add.png">
        </div>
        <div  style= "width:90px;height:90px" ondrop="drop(event)" ondragover="allowDrop(event)">
            <img id="garbage" src="img/garbage.png">
        </div> 
        
         <img id='base64image'                 
       			src='data:image/png;base64,${img}' />
	<table id="tab">
	</table>
</body>

</html>