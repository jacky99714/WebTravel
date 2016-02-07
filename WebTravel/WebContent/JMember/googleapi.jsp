<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" name="viewport" content="initial-scale=1.0" charset=UTF-8">
<title>輸入你的標題！</title>
<link rel="shortcut icon" href="<c:url value="/img/icon.ico"/>">  

    <!-- Bootstrap -->
     
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
   <style type="text/css">
   .map {
    width: 640px;
    height: 480px;
}
   </style>
  </head>
  <body style="padding:71px;">
  <jsp:include page="/WEB-INF/top/top.jsp"/>

<!--     我是內容---------------------------- -->
    <div class="container-fluid">
		
		<div class="map"></div>
    </div>
<!--  -->
<script type="text/javascript">

$(function(){
	
	$('.map').tinyMap({
	    'zoom'  : 14,
// 	    'direction': [
// 	              	{
// 	              	    'from':['22.849440','121.067470'],
// 	              	    'to': ['22.889340','121.064470'],
//                         'travel': 'driving',
//             	        'waypoint': [
//             	                     {
//             	                         'location': '台北市信義區仁愛路4段505號',
//             	                         'text': '仁愛路中繼點',
//             	                         'icon': 'https://code.essoduke.org/images/2.png'
//             	                     },
//             	                     {
//             	                         'location': '台北市信義區仁愛路4段100號',
//             	                         'text': '仁愛路中繼點',
//             	                         'icon': 'https://code.essoduke.org/images/2.png'
//             	                     }
//             	                 ],
// 	              		 'renderAll': true
// 	              	}
// 	        ]
	    direction : [
	                 {
	                     'from': ["23.942930","120.931320921"],
	                     'fromText': '起點:紀念館',
	                     'waypoint': [
	                         {'location': ["23.795380", "120.945740"], 'text': '達瑪巒旅遊服務中心2','icon': 'https://code.essoduke.org/images/2.png'},
	                         {'location': ["23.850950", "120.922380"], 'text': '土亭仔步道3','icon': 'https://code.essoduke.org/images/2.png'},
	                         {'location': ["23.785740", "120.945770"], 'text': '快樂樂團4','icon': 'https://code.essoduke.org/images/2.png'}
	                     ],
	                     'to':  ["23.872350","120.920580"],
	                     'toText': '終點:內湖山步道',
	                     'travel': 'driving',
	                     'icon': {
	                         'from': 'https://code.essoduke.org/images/2.png',
	                         'to': 'https://code.essoduke.org/images/2.png',
	                     }
	                     
	                 }
	             ]

	});
	
});



</script>




    <hr class="featurette-divider">
    <footer>
    <p class="pull-right"><a href="#">Back to top</a></p>
    <p> 2015 Travel, Inc. &middot; <a href="#">聯絡我們</a>
    </footer>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
   
    <!-- Include all compiled plugins (below), or include individual files as needed -->
   
    <script src=" <c:url value="/JMember/js/jquery.tinyMap.min.js"/>"></script>
    <script src=" <c:url value="/js/bootstrap.min.js"/>"></script>
  </body>
</html>