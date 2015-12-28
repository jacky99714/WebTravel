<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>輸入你的標題！</title>
<link rel="shortcut icon" href="<c:url value="/img/icon.ico"/>">  

    <!-- Bootstrap -->
     
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
	
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body style="padding:71px;">
  <jsp:include page="/top/top.jsp"/>

<!--     我是內容---------------------------- -->
    <div class="container-fluid">
    <table id="simpleTable" class="table table-hover">
  		<thead>
  			<th>景點編號</th>
  			<th>區域</th>
  			<th>縣市</th>
  			<th>景點名稱</th>
  			<th>內容</th>
  			<th>開始時間</th>
  			<th>結束時間</th>
  			<th></th>
  			<th></th>
  		</thead>
  		<tbody>
   		 <c:forEach var="scene" items="${sceneList}">
   			<tr>
	  			<td>${scene.sceneId}</td>
	  			<td>${scene.location}</td>
	  			<td>${scene.city}</td>
	  			<td>${scene.sceneName}</td>
	  			<td>${scene.sceneContent}</td>
	  			<td>${scene.timeStart}</td>
	  			<td>${scene.timeEnd}</td>
	  			<td><button value="${scene.sceneId}" class="btn btn-success btn-xs">加入收藏</button>   <button value="${scene.sceneId}" class="btn btn-danger btn-xs">刪除</button></td>
<%-- 	  			<td>${scene.memberId}</td> --%>
  			</tr>
		   </c:forEach>
  		</tbody>
	 </table>
    

<div class="modal hide fade">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    <h3>對話視窗標題</h3>
  </div>
  <div class="modal-body">
    <p>一個好的本體…</p>
  </div>
  <div class="modal-footer">
    <a href="#" class="btn">關閉</a>
    <a href="#" class="btn btn-primary">儲存變更</a>
  </div>
</div>

<!--  -->

    <hr class="featurette-divider">
    <footer>
    <p class="pull-right"><a href="#">Back to top</a></p>
    <p> 2015 Travel, Inc. &middot; <a href="#">聯絡我們</a>
    </footer>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src=" <c:url value="/js/bootstrap.min.js"/>"></script>
    
    <script type="text/javascript">
    
    
    
    
    $(function(){	  	
    	$(".alert").alert()
    	
//     	$('.del').click(function(){
    		//刪除
    		// 		//this -> class=del的<a>
//     		//$(this).parent() -> <td>
//     		//$(this).parent().remove();
    		
//     		//$(this).parent().parent() -> <tr>
//     		//$(this).parent().parent().remove();
//     		$(this).parents("tr").remove();
//     	});
    	
    	//$(document)
        //$('#simpleTable')
    	$('#simpleTable>tbody').on("click",'.btn-danger',function(){		
//     		alert($(this).val())

			 $( "#dialog-confirm" ).dialog({
			      resizable: false,
			      height:140,
			      modal: true,
			      buttons: {
			        "Delete all items": function() {
			          $( this ).dialog( "close" );
			        },
			        Cancel: function() {
			          $( this ).dialog( "close" );
			        }
			      }
			    });
			
			var scene = $(this).val()
			  $.ajax({
				  'type':'get', //post、delete、put
				  'url':'<c:url value="/DeleteCollectServlet"/>',
				  'dataType':'xml',  //json、script、html
				  'data':{"scene":scene}
// 				  'success':function(data){
// 					//data 就是一個XML DOM 
// 					$(data).find("Category").each(function(){
// 						//$(this) -> 表示Category物件
// 						console.log($(this).children("CategoryID").text());
// 						console.log($(this).children("CategoryName").text());
// 					})
// 				  }
			  });
    		$(this).parents("tr").remove();
    	});
    	   	
      });
    	
    </script>
    
    
    
    
  </body>
</html>