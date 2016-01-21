
///////////////////////////////////////////////////////
//picture object
function imgToCanvas(type,img,sx,sy,sWidth,sHeight,dx,dy,dWidth,dHeight){
    this.type = type;                              //attack or defense or person
    this.img = new Image(); 					   //source image 								
    this.img.src = img;
    this.sx = sx;                                   //from source img left distance
    this.sy = sy;                                   //from source img top distance  
    this.sWidth = sWidth;                           //from source img width
    this.sHeight = sHeight;                         //from source img height
    this.dx = dx;                                   //to destination img left distance
    this.dy = dy;	                                //to destination img top distance
    this.dWidth = dWidth;                           //to destination img width
    this.dHeight = dHeight;                         //to destination img height
}

//person object 
function person(name,group,hp,mp,attack,defense,imgPerson,imgAttack,imgDefense){
	 this.name =name;                   //person name 
	 this.group = group;                //person group belong to enemy or ours
	 this.hp = hp;                      //hp  type:integer 
	 this.mp = mp;                      //mp  type:integer 
	 this.attack = attack;              //attack  type:integer
	 this.defense =defense;             //defense  type:integer  
	 this.imgPerson = imgPerson;        //pictuer of person  type:imgToCanvas
	 this.imgAttack = imgAttack;        //pictuer of person  type:imgToCanvas
	 this.imgDefense = imgDefense;      //pictuer of person  type:imgToCanvas
}

//question object
function question(ques,options,ans){   
        this.ques = ques;                  //question
        this.options = options;            //question options
        this.ans = ans;                    //question answer  
}	
//////////////////////////////////////////////////////////////////////////////////////////////  
var back = new imgToCanvas("background","img/bg.png",0,0,460,300,0,0,460,300);	//background image
var trea = new imgToCanvas("treasure","img/treasure.png",0,0,80,80,0,0,80,80);  //treasure image(getHp or getMp)
var questions;


var content;     //present question 
var user,enemy;

var allbtn;                  //all  button must append to this div tag
var walkBtn,DefenseBtn;     //dynamic create button
var userWalk = false;       //whether user can walk or not 
var userDefense = false;   //whether user ptotect himself from enemy attack
var enemyAngry = false;    //enemy is angry or not
  
	var bgSpeed;               // image frame speed
var choice = 0;            // user choose a person to play
var step;                  //calculate the peforming frame
var start = null;          //control  setInterval function
var state;                 //game state
var photo;                 //person photo
var photoChoice;           //user little photo 
var audio,ctx,box,fig;      //variable for document.getElementById()
///////////////////////////////////////////////////////////////////////////////////////
window.onload = function(){        
    document.getElementById("reStart").addEventListener("click", function(){
            reStart();
    });				
    audio = document.getElementById("backAudio");
    allbtn = document.getElementById("btn");
    box = document.getElementById("box");
    fig = document.getElementById("photo2");
    ctx = document.getElementById('canvas').getContext('2d');
    ctx.globalCompositeOperation="source-over";		
    reStart();
}; 

window.onkeydown = function (e) {
	
    var code = e.keyCode ? e.keyCode : e.which;
    if (code === 39){                                    //->
        if(document.getElementById("userWalkBtn")){
            walk();	
        }   	
    }else if(code === 90){                               //z
        if(document.getElementById("userDefenseBtn")){
            defense();	
        }	 		    	
    }else if(code === 82) {                              //r  
        reStart();      	
    }else if(code === 67){                               //c
        if(document.getElementById("select")){
                choose();	
        }	 		    	
    }else if(code === 83){                                //s	    	
        if(document.getElementById("play")){ 
            play();	
        }	    			   
    }

    if(state === "enemyWalk" || state === "userHurt"){
        if(document.getElementById("form")){
            var form = document.getElementById("form");
            if(code === 13){                             //enter
                answerQuestion();
            }else if(code === 49 || code === 97){       //1
                    form.ask[0].checked = true;
            }else if(code === 50 || code === 98){       //2
                    form.ask[1].checked = true;
            }else if(code === 51 || code === 99){       //3
                    form.ask[2].checked = true;
            }else if(code === 52 || code === 100){      //4
                    form.ask[3].checked = true;
            } 		    		
        }
    }   
};		
/////////////////////////////////////////////////////////////
//create input tag element when it does not exist
function createInput(id,type,className,name,value){		
    var input = document.createElement("input");
    if(id !== "noId"){
        input.id = id;	
    }	
    input.setAttribute("type", type);
    if(className !== "noClass"){
        input.className = className;
    }
    if(name !== "noName"){
                input.name = name;
            }	
            input.value = value;				
            return input;
        }
 //////////////////////////
function walk(){                                    
    if(userWalk){
        userWalk = false;  
        changeState("userWalk");	  
            }	 
        }
 
        function defense(){
            if(user.mp > 20 && !userDefense && state === "enemyAttack" &&
            !collide(enemy.imgAttack,user.imgDefense,10)){
                userDefense = true;		
                modify(-20,"usermp");			
    }					
}
////////////////////////////////////////////
//generate  questions ask to user
function getQuestion(){                            
	xhr = new XMLHttpRequest();
	if(xhr !== null){

    	xhr.addEventListener("readystatechange",callback);
    
    	xhr.open("get","GetQuestionServlet",true); 
    	xhr.send();		      	
	}else{
//		alert("您的瀏覽器不支援Ajax功能!!");
	}
}

function callback(){
	if(xhr.readyState === 4){ 	
		if(xhr.status === 200){
			
			//步驟三接收Server端回應的結果
	    	var data = JSON.parse(xhr.responseText);
	    	questions = new question(data.QName,[data.a,data.b,data.c,data.d],data.ans);
 			content.innerHTML = "";
	 		index = (Math.floor(Math.random() * 10) );        //0~9   random the number of  question 
			var div = document.createElement("div");          //create a div to display question
			var divtext = document.createTextNode(questions.ques);   
			div.appendChild(divtext);
			content.appendChild(div);
			
			var form = document.createElement("form");   //create a form tag to present answer to user
			form.id ="form";
			var radio,textnode,br;
			for(var i = 0;i < 4;i++){                    //create  radios to display question's options
				radio = createInput("noId","radio","noClass","ask",i+1);
				textnode = document.createTextNode(questions.options[i]);
				br = document.createElement("br");
				form.appendChild(radio);
				form.appendChild(textnode);
				form.appendChild(br);		
			}
			
			var button = createInput("answer","button","noClass","noName","Submit");   //create a button to get user answer
			form.appendChild(button);
			content.appendChild(form);
			button.addEventListener("click",function(){	 
				answerQuestion();
			});	

		}else{
	//		alert(xhr.status + ":" + xhr.statusText);
	    		}    		
	    	}  	
	    }
 
        //judge user's answer is correct or not
function answerQuestion(){
    var form = document.getElementById("form");	
    for(var i=0; i < form.ask.length; i++){
        if (form.ask[i].checked){ 
            var ans = form.ask[i].value;
            content.innerHTML = "";
            audio.src = "audio/attack.mp3";
            audio.loop = false;
            if(ans !== questions.ans){     //check user answer is correct or not
                changeState("enemyAttack");
            }else{
                changeState("userAttack");
            }
            break;
        }
    }	
}
//////////////////////////////////////////////////////
//reset picture when it changes state
function resetPosition(pic,sx,sy,dx,dy){       
    pic.sx = sx;
    pic.sy = sy;
    pic.dx = dx;
    pic.dy = dy;
}

//change state
function changeState(nextState){
    state = nextState;
    step = 0;		
    //resetPosition(who,type,sx,sy,dx,dy)
    if(state === "initial"){
        resetPosition(user.imgPerson,0,0,30,200);
        resetPosition(back.img,0,0,0,0);
    }else if(state === "userWalk"){
        bgSpeed = 50; 	
        resetPosition(user.imgPerson,0,0,30,200);
    }else if(state === "userAttack"){
        bgSpeed = 40; 	
        resetPosition(user.imgPerson,0,user.imgPerson.sHeight,30,200);
        resetPosition(user.imgAttack,0,0,110,200);	
        resetPosition(enemy.imgPerson,0,0,350,200);	
    }else if(state === "userHurt"){
        if(!userDefense){
             bgSpeed = 60; 
            resetPosition(user.imgPerson,0,user.imgPerson.sHeight*2,30,200);
            resetPosition(enemy.imgPerson,0,0,350,200);	
        }
    }else if(state === "enemyWalk"){	
        bgSpeed = 50;
        resetPosition(user.imgPerson,0,0,30,200);
        resetPosition(enemy.imgPerson,0,0,350,20);
        audio.src = "audio/boss.mp3";
    }else if(state === "enemyAttack"){
        bgSpeed = 50;
        resetPosition(user.imgPerson,0,0,30,200);
        resetPosition(user.imgDefense,0,0,70,200);
        resetPosition(enemy.imgPerson,0,enemy.imgPerson.sHeight,350,200);		
        resetPosition(enemy.imgAttack,0,0,270,200);	
    }else if(state === "enemyHurt"){	
        bgSpeed = 60;
        resetPosition(user.imgPerson,0,0,30,200);
        resetPosition(enemy.imgPerson,0,enemy.imgPerson.sHeight*2,350,200);	
    }else if(state === "enemyAngry"){	
        bgSpeed = 80;	
        resetPosition(user.imgPerson,0,0,30,200);
        resetPosition(enemy.imgPerson,0,enemy.imgPerson.sHeight*3,350,200);							
    }else if(state === "enemyDisappear"){
        bgSpeed = 60;
        content.innerHTML ="";
        resetPosition(user.imgPerson,0,0,30,200);
        resetPosition(enemy.imgPerson,0,0,350,200);					
    }else if(state === "getHp"){
        bgSpeed = 50;
        resetPosition(user.imgPerson,0,0,30,200);	
        resetPosition(trea,0,0,350,200);
    }else if(state === "getMp"){
        bgSpeed = 50;
        resetPosition(user.imgPerson,0,0,30,200);
        resetPosition(trea,0,trea.sHeight,350,200);
    }else if( state === "win" || state === "lose"){	
        
        if(document.getElementById("form")){
                box.innerHTML ="";
        }

        if(document.getElementById("userWalkBtn")){
            allbtn.removeChild(document.getElementById("userWalkBtn"));
        }

        if(document.getElementById("userDefenseBtn")){
            allbtn.removeChild(document.getElementById("userDefenseBtn"));
        }
        
        if(state === "win"){
            content.innerHTML = "恭喜您打倒了魔王，獲得優惠卷一張。";
            back = new imgToCanvas("background","img/winner.png",0,0,460,300,0,0,460,300);
        }else{
            content.innerHTML = "勝敗乃兵家常事，請大俠重新來過。";
            back = new imgToCanvas("background","img/loser.png",0,0,460,300,0,0,460,300);
 
        }
       
        back.img.onload = function(){
        	drawImg();
        };
        
    }			

    if(start === null){			
        start = setInterval(drawImg, bgSpeed);				
    }
}	
////////////////////////////////////////////////////////////////////
//calculate whether  imgAttack collide defense or user
function collide(imgA,imgB,move){        //imgA,imgB:imgToCanvas
    if((Math.abs(imgA.dx - imgB.dx )  - move - 40) < 0){
        return true;
    }else{
        return false;
    }
}		
///////////////////////////////////////////////////////////////
   //judge  which picture should draw on canvas
function pictureAppear(which){
    if(which === "back"){
        if(state !== "reStart"){
            return true;
        }
    }

    if(which === "user"){
        if(state !== "win" && state !== "lose" && state !== "reStart"){
            return true;
        }
    }else if(which === "enemy"){
        if(state !== "win" && state !== "lose" && state !== "userWalk" && state !== "initial"){				
            return true;	   	
        }
    }else if(which === "treasure"){
        if(state === "getHp" || state === "getMp"){
            return true;
        }
    }		
    return false;
}
//////////////////////////////////
// draw which picture 
function draw(which){
    ctx.drawImage(which.img, which.sx, which.sy, which.sWidth, which.sHeight,
                          which.dx, which.dy, which.dWidth, which.dHeight);	
}

//draw picture on screen
function drawImg() {	
    ctx.clearRect(0, 0, back.dWidth, back.dHeight);	  //clear canvas image
    if(pictureAppear("back")){
        draw(back);	
    }

    if(pictureAppear("user")){	
        draw(user.imgPerson);
    }	

    if(pictureAppear("enemy")){
       draw(enemy.imgPerson);				
    }	

    if(state === "userAttack"){
        if(step >= 4){
            draw(user.imgAttack);
        }			
    }		

    if(state === "enemyAttack"){	
        if(step >= 4 && (!collide(enemy.imgAttack,user.imgDefense,10) || !userDefense) ){
            draw(enemy.imgAttack);
        }
        if(userDefense && !collide(enemy.imgAttack,user.imgDefense,10)){
            draw(user.imgDefense);
        }		
    }	

    if(pictureAppear("treasure")){
        draw(trea);
    }

    changeImgPosioion();			
}  

//change from source image position and to destion image position On Canvas  
function changeImgPosioion(){
    step++;	
    if(state === "userWalk"){
        back.sx +=10;
        if( back.sx >= 1380){
            back.sx -= 1380;
        }
        user.imgPerson.sx += user.imgPerson.sWidth;				    		    
    }else if(state === "userAttack"){
        if(step >= 4){
            user.imgAttack.dx += 10;			
        }

        if(step < 7){
            user.imgPerson.sx += user.imgPerson.sWidth;			
        }				
    }else if(state === "userHurt"){
        if(!userDefense){
            user.imgPerson.sx += user.imgPerson.sWidth;	
            if(step <= 3){
                user.imgPerson.dx -= 10;
                user.imgPerson.dy -= 10;	
            }else if(step <= 6){
                back.sx -= 10;
                if( back.sx <= 0){
                    back.sx += 1380;
                }
                user.imgPerson.dx += 10;	
                user.imgPerson.dy += 10;	
            }
        }	    			    
    }else if(state === "enemyWalk"){	
        enemy.imgPerson.sx += user.imgPerson.sWidth;	
        enemy.imgPerson.dy += 30;			    		    
    }else if(state === "enemyAttack"){
        if(step >= 4){
            enemy.imgAttack.dx -= 10;			
        }	

        if(step < 7){
            enemy.imgPerson.sx += enemy.imgPerson.sWidth;			
        }					
    }else if(state === "enemyHurt"){

        if(step <= 3){
            enemy.imgPerson.dx += 10;	
            enemy.imgPerson.dy -= 10;	             
        }else if(step <= 6) {
            back.sx +=10;
            if( back.sx >= 1380){
                back.sx -= 1380;
            }
            enemy.imgPerson.dx -= 10;
            enemy.imgPerson.dy += 10;	
        }
        enemy.imgPerson.sx += user.imgPerson.sWidth;	
    }else if(state === "enemyAngry"){
        enemy.imgPerson.sx += user.imgPerson.sWidth;
    }else if(state === "enemyDisappear"){
        enemy.imgPerson.dx += 18;	
        enemy.imgPerson.sx += user.imgPerson.sWidth;
    }else if(state === "getHp" || state === "getMp"){
        if(step % 4 === 1){
            trea.sx += trea.sWidth;
        }	
        trea.dx -= 13;					
    }
    stopDrawing();
}

// stop  to call drawing function
function stopDrawing(){
    if(state === "userWalk"){
        if(step === 7){
            clearInterval(start);
            start = null;		
            if(Math.floor((Math.random() * 3) + 1) <= 1){    //probability 1/3 to face enemy
                audio.src = "audio/boss.mp3";
                if(!enemyAngry){
                        photo.src = "img/john_f.bmp";
                }else{
                        photo.src = "img/justin_f.bmp";
                }	
                changeState("enemyWalk");
            }else{
                userWalk = true;
            }	
        }				    		    
    }else if(state === "userAttack"){	
        if(step === 23){
            clearInterval(start);
            start = null;					
            content.innerHTML = "";
            audio.src = "audio/hurt.mp3";
            audio.loop = false;
            changeState("enemyHurt");
        }								
    }else if(state === "userHurt"){
        if(step === 7){
            clearInterval(start);
            start = null;
            if(!userDefense){
                modify(-(enemy.attack-user.defense),"userhp");		
            }				
            userDefense = false;
            if(user.hp === 0){
                audio.src = "";
                changeState("lose");
            }else{
                audio.src = "audio/boss.mp3";
                audio.loop = true;
                getQuestion();
            }
        }				    
    }else if(state === "enemyWalk"){	
        if(step === 7){
            clearInterval(start);
            start = null;
            getQuestion();	
        }			    		    
    }else if(state === "enemyAttack"){
        if(step === 23){
            clearInterval(start);
            start = null;
            if(!userDefense){
                    audio.src = "audio/hurt.mp3";	
            }
            changeState("userHurt");		
        }					
    }else if(state === "enemyHurt"){		
        if(step === 7){		
            modify(-(user.attack-enemy.defense),"enemyhp");		
            clearInterval(start);
            start = null;
            if(!enemyAngry && enemy.hp <= 40){
                enemy.imgPerson.img.src = "img/justin.png";
                enemy.imgAttack.img.src = "img/justinAttack.png";
                enemy.attack = 45;
                enemy.defense = 10;
                photo.src ="img/justin_f.bmp";
                content.innerHTML ="我生氣了，讓你見識我真正的力量。"
                changeState("enemyAngry");
                enemyAngry = true;
            }else{
                changeState("enemyDisappear");	
            }						
        }				    			    
    }else if(state === "enemyAngry"){
        if(step === 7){
            clearInterval(start);
            start = null;
            changeState("enemyDisappear");			
        }						
    }else if(state === "enemyDisappear"){
        if(step === 7){	
            clearInterval(start);
            start = null;
            photo.src = photoChoice;
            if(enemy.hp === 0){
                audio.src = "audio/win.mp3";
                audio.loop = false;
                changeState("win");
            }else{
                var random = Math.floor((Math.random() * 10)+1);
                if( random <= 3){            //probability 0.3 to get hp	
                        audio.src = "audio/treasure.mp3";
                        changeState("getHp");
                }else if(random <= 7){       //probability 0.4 to get mp	
                        audio.src = "audio/treasure.mp3";
                        changeState("getMp");
                }else{	
                        audio.src = "audio/bgsound.mp3";
                        audio.loop = true;
                        userWalk = true;
                }							
            }
        }				
    }else if(state === "getHp" || state === "getMp"){	
        if(step === 24){
            clearInterval(start);
            start = null;				
            if(state === "getHp"){
                modify(15,"userhp");
            }else{
                modify(15,"usermp");
            }		
            audio.src = "audio/bgsound.mp3";
            audio.loop = true;
            userWalk = true;
        }				
    }
}
/////////////////////////////////////////////////////		
//modify hp or mp
function modify(change,type){	
    if(type === "userhp"){
        user.hp += change;	
        if(user.hp > 100){
            user.hp = 100;
        }else if(user.hp < 0){
            user.hp = 0;			
        }
        display(user.hp,type);
    }else if(type === "usermp"){
        user.mp += change;	
        if(user.mp > 100){
            user.mp = 100;
        }else if(user.mp < 0){
            user.mp = 0;			
        }		
        display(user.mp,type);
    }else if(type === "enemyhp"){
        enemy.hp += change;	
        if(enemy.hp < 0){
            enemy.hp = 0;			
        }	
        display(enemy.hp,type);
    }			
}	
/////////////////////////////////////////////////////////////////				
//display hp or mp on screen
function display(number,type){
    var control = document.getElementById(type);			
    control.style.color = "black";	
    control.innerHTML = number;	

    if(type === "userhp"){
        if(number >= 60){
            control.style.backgroundColor = "#00FF00";
        }else if(number > 20){
            control.style.backgroundColor = "#FFFF33";
        }else{
            control.style.backgroundColor = "#FF3333";
        }
        control.style.width = number+"%";
    }else if(type === "usermp"){
        control.style.backgroundColor = "#CC00FF";	
        control.style.width = number+"%";
    }else if(type === "enemyhp"){
        if(number > 100){
                control.style.backgroundColor = "#00FF00";
        }else if(number > 40){
                control.style.backgroundColor = "#FFFF33";
        }else{
                control.style.backgroundColor = "#FF3333";
        }				
        control.style.width = (number/2.0)+"%";			
    }				
}

////////////////////////////////
//game reStart
function reStart(){
    state = "reStart";
    userWalk = false; 
    enemyAngry = false; 
    userDefense = false;
    choice = 2;         		
    bgSpeed = 60;
    audio.autoplay = false;
    audio.loop = false;
    audio.load();
    box.innerHTML = "";				
    if(document.getElementById("userWalkBtn")){
        allbtn.removeChild(document.getElementById("userWalkBtn"));
    }

    if(document.getElementById("userDefenseBtn")){
        allbtn.removeChild(document.getElementById("userDefenseBtn"));
    }

    content = document.createElement("div");
    content.className = "introduce";
    document.getElementById("photo2").src = "img/noChoose_f.png";
    var operation = "在某一天，天上突然降臨了一位魔王，由於他喜歡到處詢問根旅遊相關的問題，答不出來的人會被他殺害，使的村民苦不堪言，希望有勇者能除去魔王。";
    operation = operation + "如果勇者能解決魔王，村民將會奉上優惠卷作為報答。<br/>";
    operation = operation + "遊戲操作說明:<br/>";
    operation = operation + "可以使用鍵盤或滑鼠操作，在魔王攻擊時，可耗損魔力使用金鍾罩抵擋。<br/>";
    operation = operation + "鍵盤:<br/>";
    operation = operation + "R是重新開始，S是遊戲開始  ->是尋找敵人，Z是金鐘罩，C是選擇角色。<br/>";
    operation = operation + "可使用數字1、2、3、4、enter鍵回答魔王所問的問題。";
    content.innerHTML = operation;	
    box.appendChild(content);

    if(document.getElementById("walkBtn")){
        allbtn.removeChild(document.getElementById("walkBtn"));
    }
    if(document.getElementById("defenseBtn")){
        allbtn.removeChild(document.getElementById("defenseBtn"));
    }
    enemy = new person("join","enemy",200,100,40,0,
                     new imgToCanvas("person","img/john.png",0,0,80,80,350,200,80,80),
                     new imgToCanvas("attack","img/johnAttack.png",0,0,80,80,270,200,80,80),
                                     null); 
 

    display(0,"userhp");
    display(0,"usermp");
    display(0,"enemyhp");
    back = new imgToCanvas("background","img/bg.png",0,0,460,300,0,0,460,300);
    ctx.clearRect(0, 0, back.dWidth, back.dHeight);	

    if(document.getElementById("play")){			
        allbtn.removeChild(document.getElementById("play"));			
    }

    if(document.getElementById("select")){
        allbtn.removeChild(document.getElementById("select"));
    }	

    if(document.getElementById("walkBtn")){			
        allbtn.removeChild(document.getElementById("walkBtn"));			
    }

    if(document.getElementById("defenseBtn")){
        allbtn.removeChild(document.getElementById("defenseBtn"));
    }				
    if(start !== null){
        clearInterval(start);
        start = null;				
    }	
    start = setInterval(choose,1000);
}

//user choose a character which he wants to use
function choose(){
    if(!audio.autoplay && !audio.loop){
        audio.src = "audio/select.mp3";
        audio.autoplay = true;
        audio.loop = true;				
    }

    if(start !== null){
        clearInterval(start);
        start = null;				
    }

    box.innerHTML = "";			
    photo = document.createElement("img");
    photo.src = "img/firzen_f.bmp";
    photo.className = "photo";
    box.appendChild(photo);		
    content = document.createElement("div");
    content.className = "text";
    box.appendChild(content);

    choice = (choice+1)%3;
    if(choice === 0){
        photo.src = "img/firzen_f.bmp";
        fig.src = "img/firzen_f.bmp";
        content.innerHTML="冰火人，來自傳說中的冰火島，擁有絕技冰火兩重天，屬於平衡性的角色。";
    }else if(choice === 1){
        photo.src = "img/firen_f.bmp";
        fig.src = "img/firen_f.bmp";
        content.innerHTML="火人，來自傳說中的烈火島，擁有絕技火炎彈，屬於攻擊性的角色。";
    }else{
        photo.src = "img/freeze_f.bmp";
        fig.src = "img/freeze_f.bmp";
        content.innerHTML="冰人，來自傳說中的寒冰島，擁有絕技急凍球，屬於防禦性的角色。";
    }

    if(!document.getElementById("select")){
        var btn2 = createInput("select","button","btn","noName","選擇角色");
        allbtn.appendChild(btn2);
        btn2.addEventListener("click",function(){	
            choose();
        });
    }		

    if(!document.getElementById("play")){
        var btn = createInput("play","button","btn","noName","開始遊戲");
        allbtn.appendChild(btn);
        btn.addEventListener("click",function(){	
                play();
        });				
    }		
}	
//////////////////////////////////////////////////
//game start
function play(){		
    //person:name,group,hp,mp,attack,defense,imgPerson,imgAttack
    //imgPerson,imgAttack:type,img,sx,sy,dx,dy

    audio.src = "audio/bgsound.mp3";			
    if(document.getElementById("select")){
            allbtn.removeChild(document.getElementById("select"));
    }

    if(document.getElementById("play")){
            allbtn.removeChild(document.getElementById("play"));
    }

    if(!document.getElementById("userWalkBtn")){
            walkBtn = createInput("userWalkBtn","button","btn","noName","尋找敵人");
            allbtn.appendChild(walkBtn);
            walkBtn.addEventListener("click",function(){	
                    walk();
            });				
    }

    if(!document.getElementById("userDefenseBtn")){
            defenseBtn  = createInput("userDefenseBtn","button","btn","noName","金鐘罩");
            allbtn.appendChild(defenseBtn);
            defenseBtn.addEventListener("click",function(){	
                    defense();
            });				
    }

    if(choice === 0){ 
        photoChoice = "img/firzen_f.bmp";
        user = new person("firzen","we",60,50,25,25,
                            new imgToCanvas("person","img/firzen.png",0,0,80,80,30,200,80,80),
                            new imgToCanvas("attack","img/firzenAttack.png",0,0,80,80,110,200,80,80),
                            new imgToCanvas("defense","img/firzenDefense.png",0,0,80,80,110,200,80,80));			   
    }else if(choice === 1){
        photoChoice = "img/firen_f.bmp";
        user = new person("firen","we",60,50,30,20,
                            new imgToCanvas("person","img/firen.png",0,0,80,80,30,200,80,80),
                            new imgToCanvas("attack","img/firenAttack.png",0,0,80,80,110,200,80,80),
                            new imgToCanvas("defense","img/firenDefense.png",0,0,80,80,110,200,80,80));			
    }else if(choice === 2){
        photoChoice = "img/freeze_f.bmp";
        user = new person("freeze","we",60,50,20,30,
                            new imgToCanvas("person","img/freeze.png",0,0,80,80,30,200,80,80),
                            new imgToCanvas("attack","img/freezeAttack.png",0,0,80,80,110,200,80,80),
                            new imgToCanvas("defense","img/freezeDefense.png",0,0,80,80,110,200,80,80));			
    }
    user.imgPerson.img.onload = function(){
        display(user.hp,"userhp");
        display(user.mp,"usermp");
        display(enemy.hp,"enemyhp");
        content.innerHTML= "";
        changeState("initial");
        userWalk = true;	
    };	
}
