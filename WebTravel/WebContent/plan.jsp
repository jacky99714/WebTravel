<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>行程規劃</title>
	<style>
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
        
        td{
        	border:3px ridge purple;  
        }
	</style>
	
	<script>
             var imgId = 0;
             var totalImage = 0;
             var lineNum = 5;  // how many td tag does one tr tag has 
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
                        src.id = 0;                   //exchangeId
                        tar.id = srcId;
                        src.id = tarId;                    
                    }else{
                        var tr = srcParent.parentNode;
                        totalImage --;
                            if(srcParent.nextElementSibling !== null){
                                tr.removeChild(srcParent.nextElementSibling);
                            }else if(srcParent.previousElementSibling !== null){
                                tr.removeChild(srcParent.previousElementSibling);
                            }
                             tr.removeChild(srcParent);
                             srcParent.removeChild(src);                            
                        if(tr.id === "tr1"){
                            var tr1 = document.getElementById("tr1");
                            var tr2 = document.getElementById("tr2");
                            var moveUp = tr2.firstElementChild;
                            if(totalImage >= lineNum){
                                tr1.appendChild(createTd("line"));
                            }
                            if(moveUp !== null ){
                                tr1.appendChild(moveUp);
                            }
                            
                            if(tr2.firstElementChild !== null){
                                tr2.removeChild(tr2.firstElementChild);
                            }
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
                    var tdImg = createTd("image",imgsrc);
                    var tr;
                    
                    if(totalImage >= lineNum*2){
                        return;
                    }
                    if(Math.floor(totalImage / lineNum) === 0){
                        tr = document.getElementById("tr1");
                    }else{
                        tr = document.getElementById("tr2");
                    }
            
                    if(totalImage % lineNum !== 0){      
                         var tdLine = createTd("line",null);
                         tr.appendChild(tdLine);
                    }
                    tr.appendChild(tdImg);
                    
                    totalImage++;  
                } 
		
		window.onload = function(){
			var table = document.getElementById("tab");
			var tr1 = document.getElementById("tr1");
                        
                        appendImg("img/freeze_f.bmp");
                        appendImg("img/firen_f.bmp");
                        appendImg("img/firzen_f.bmp");
                        appendImg("img/john_f.bmp");
                        appendImg("img/justin_f.bmp");
                        appendImg("img/freeze_f.bmp");
                        appendImg("img/firen_f.bmp");
//                        appendImg("img/firzen_f.bmp");
//                        appendImg("img/john_f.bmp");
//                        appendImg("img/justin_f.bmp");
                    for(var i=1;i <= 4;i++){
                         document.getElementById("get"+i).addEventListener("click", click);                 
                    }
                   

		}
		
	</script>
</head>
<body>
	<div class="head">行程規劃</div>
	<div>我的收藏</div>
	<div>搜尋景點</div>
	
        <div id="collection">
            <img id="get1" src="img/firenAttack.png" draggable="true" ondragstart="drag(event)">
            <img id="get2" src="img/firzenAttack.png" draggable="true" ondragstart="drag(event)">
            <img id="get3" src="img/freezeAttack.png" draggable="true" ondragstart="drag(event)">
            <img id="get4" src="img/johnAttack.png" draggable="true" ondragstart="drag(event)">     
        </div>
        <div  style= "width:90px;height:90px" ondrop="drop(event)" ondragover="allowDrop(event)">
            <img id="garbage" src="img/garbage.png">
        </div> 
        
	<table id="tab" style="border:3px ridge #DDDDDD;">
		<tr id="tr1">		
		</tr>
		<tr id="tr2">		
		</tr>
	</table>
</body>

</html>