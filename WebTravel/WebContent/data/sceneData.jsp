<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <script src="../js/jquery-1.11.3.min.js"></script>
</head>
<body>

</body>

<script type="text/javascript">
$(function(){
	$.ajax({
		  'type':'get', //post、delete、put
		  'url':'scenic_spot_C_f.json',
		  'dataType':'json',  //json、script、html
// 		  'data':{"Schedule":ob.val()},
		  'success':function(datas){
// 			  alert(data.Infos.Info[0].Add)
			  $.each(datas.Infos.Info,function(index,data){
// 				  console.log(data.Region)
				  var city = data.Region;
				  var sceneName = data.Name;
				  var sceneContent = data.Toldescribe;
				  var photo = data.Picture1;
				  $.ajax({
					  'type':'get', //post、delete、put
					  'url':'../DataInsertServlet',
					  'dataType':'json',  //json、script、html
			 		  'data':{"city":city,
			 				  "sceneName":sceneName,
			 				  "sceneContent":sceneContent,
			 				  "photo":photo
			 		  },
// 					  'success':function(data){
// 					  }
				});




			  })
			  
			  
			  
//--------------------資料傳輸---------------------------------------
/*
			  $.ajax({
				  'type':'get', //post、delete、put
				  'url':'scenic_spot_C_f.json',
				  'dataType':'json',  //json、script、html
		 		  'data':{"Schedule":ob.val()},
				  'success':function(data){
				  }
			});
*/
// ------------------------------------------------------------			  
			  
			  
		  }
	});
});

</script>


</html>